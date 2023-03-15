package chapter04.B_Polymorphism;

// 다형성
// 조상클래스 타입에 참조변수로 자손클래스의 인스턴스를 참조할 수 있도록 하는 것
// 참조변수의 형변환

class SuperClass {
	int number1;
	int number2;
	
	public SuperClass(int number1, int number2) {
		this.number1 = number1;
		this.number2 = number2;
	}
	
	void method1() {}
	void method2() {}
}

class SubClass1 extends SuperClass {
	int number3;
	
	SubClass1(int number1, int number2, int number3) {
		super(number1, number2);
		this.number3 = number3;
	}
	void method3() {}
}

class SubClass2 extends SuperClass {
	int number4;
	
	SubClass2(int number1, int number2) {
		super(number1, number2);
	}
	
//	Override
	void method1() {
		System.out.println("Override!!");
	}
}

public class Polymorphism {
	public static void main(String[] args) {
		
		SuperClass superClass = new SuperClass(1, 2);	// superClass -> 참조변수
		SubClass1 subClass1 = new SubClass1(11, 22, 33);
		SubClass2 subClass2= new SubClass2(111, 222);
		
//		자손타입 -> 조상타입 (Up casting) : 자동 형변환 가능
		SuperClass super1 = subClass1;
		SuperClass super2 = subClass2;
		
//		참조변수의 형변환을 한다고 하더라도 인스턴스가 가지고 있는 데이터에는 아무런 영향을 미치지 않음
//		단지 인스턴스의 사용 범위를 조절하는 것
		SubClass1 sub1 = (SubClass1) super1;
		System.out.println(subClass1.number3);
		System.out.println(sub1.number3);
		
//		↓ 주소는 다 같음
		System.out.println(subClass1);
		System.out.println(super1);
		System.out.println(sub1);
		
		super2.method1();
		
//		조상타입 -> 자손타입 (Down casting) : 자동 형변환 불가능
//		명시적으로 해줘야됨
//		SubClass1 sub1 = (SubClass1) superClass;
//		SubClass1 sub2 = (SubClass1) superClass;
	}
}
