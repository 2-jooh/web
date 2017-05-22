package file.upload.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import file.upload.vo.ImgUploadVO;



public class ImageUploadServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//이미지를 저장할 경로
		ServletContext ctx = getServletContext();
		String imageDir = ctx.getRealPath("/up_images"); //  /:applicaiotn Root경로. 그안에 up_images라는 파일이 어디에있는지 알려줌 
														 //  실제 파일경로 리턴, => 업로드된 파일(이미지)를 저장할 디렉토리 
		//System.out.println(imageDir);
		
		String temDir = ctx.getInitParameter("tempdir"); //업로드 된 파일을 저장할 임시 디렉토리 
		
		//1. DiskFileItemFactory 객체 생성 - 임시 저장소 정보 설정
		DiskFileItemFactory factory = new DiskFileItemFactory(1024*1024, new File(temDir)); //DiskFileItemFactory->tomcat안붙은거 import, 1MB를 임시저장로소 쓰고 나머지는 file에
		ImgUploadVO vo = new ImgUploadVO();
		List<String> imageName = new ArrayList<>();
		
		//2. ServletFileUpload 객체 생성 - DiskFileItemFactory 객체를 전달
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		//3. 요청 파라미터 조회 작업
		try {
			List <FileItem> list = upload.parseRequest(request);
			
			for(FileItem item : list){
				String reqName = item.getFieldName(); //요청 파라미터 조회
				fileName = UUID.randomUUID();
				if(item.isFormField()){//일반 요청파라미터
					String reqValue = item.getString("UTF=8"); // 요청파라미터 조회, 인코딩 설정 반드시 해야함 
					//requset대신 VO에 요청파라미터 set
					if(reqName.equals("uploader")){
						vo.setUploader(reqValue);
					}else if(reqName.equals("comment")){
						vo.setComment(reqValue);
					}
				}else{//파일 요청파라미터
					String fileName = item.getName();
					if(item.getSize()!=0){ //getSize():업로드된 파일의 크기(Byte) 리턴, 즉 업로드된파일이 없을때 
						//1. 임시경로의 파일을 최종 경로로 이동
						item.write(new File(imageDir, fileName)); //매개변수로 받은 파일을 imageDir에 카피 
						//2. 임시 경로의 파일을 삭제
						item.delete();
						imageName.add(fileName);
						//request.setAttribute(reqName, fileName); //업로드된파일명 
					}
				}
				
			}//for문 끝
			vo.setImageNames(imageName);
			
			//======> Model 호출에서 Business Logic 처리 
			request.setAttribute("result", vo);
			
			//응답처리
			request.getRequestDispatcher("/upload_result.jsp").forward(request, response);
		} catch (Exception e) {
			//이러 처리 페이지로 이동 
			e.printStackTrace();
			throw new ServletException(e); //예외처리를 톰캣에게 맡긴다.
		}
	}
}







