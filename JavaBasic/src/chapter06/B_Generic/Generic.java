package chapter06.B_Generic;

// 제너릭
// 다양한 타입을 다루는 메서드나 클래스에 컴파일 시 타입을 체크하는 기능
// 컴파일 시 타입을 체크하기 때문에 유연하게 개발을 할 수 있음

class GenericClass<D> {
	
	boolean status;
	String message;
	D data; 
	
//	<D> -> 타입변수
	static <D> GenericClass<D> getInstance(boolean status, String message, D data) {
		GenericClass<D> instance = new GenericClass<D>();
		instance.status=status;
		instance.message=message;
		instance.data=data;
		
		return instance;
	}
	
}

public class Generic {
	public static void main(String[] args) {
		
		GenericClass<Integer> generic1 = new GenericClass<>(); // 위의 D를 Integer형식으로 받음
		GenericClass<String> generic2 = new GenericClass<>(); // 위의 D가 String형식으로 받음
		
//		generic1.data = "String"; -> generic1은 Integer형식이라 안됨
		generic2.data = "String";

		GenericClass<?> generic3 = GenericClass.getInstance(true, "message", "String");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
