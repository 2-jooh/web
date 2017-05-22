package kr.co.yagaja.service;

import java.io.IOException;
import java.util.ArrayList;

import kr.co.yagaja.exception.IdCheckSuccessException;
import kr.co.yagaja.exception.IdDuplicationException;
import kr.co.yagaja.exception.IdNullException;
import kr.co.yagaja.exception.LoginFailException;
import kr.co.yagaja.vo.Member;

public interface MemberService{

    
	
	 Member loginProcess(String id, String password) throws LoginFailException, IOException ;
	
		
     public int joinMemberById(Member member) throws IdDuplicationException, IdNullException, IdCheckSuccessException; 

 	public String idDuplicationCheck(String id) throws IdDuplicationException, IdCheckSuccessException, IdNullException, IOException;


}