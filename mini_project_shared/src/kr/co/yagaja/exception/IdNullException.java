package kr.co.yagaja.exception;

public class IdNullException extends Exception {
	//runtimeException계열로 상속받겠다 싶으면 RunTimeException을 상속!
			public IdNullException(){}  //문자열받는 생성자가 있으니 없는걸 일단 만들어준다. 습관적으로 만드는것.
			                                             //만약 전달하는 message없으면 둘다 안해도 된다.
			public IdNullException(String message){
				
				 super(message);
			}
	}

