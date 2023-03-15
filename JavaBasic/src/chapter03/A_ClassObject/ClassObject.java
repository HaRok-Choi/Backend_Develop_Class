package chapter03.A_ClassObject;

// class
// 객체를 정의해 놓은 것
// 객체를 생성하는 기반
// 객체를 정의하는 틀 또는 설계도

// 클래스는 객체의 상태를 나타내는 필드와 객체의 행동을 나타내는 메소드로 구성됨
// 필드: 클래스에 포함된 변수 혹은 상수
// 메소드: 어떠한 특정 작업을 수행하기 위한 명령문의 집합 

// object
// 실제로 존재하는 모든것들
// 클래스로 생성된 실체

// 클래스로 생성된 각각의 객체는 독립적으로 존재함
// 같은 클래스로 생성된 객체라 하더라도 각각이 가지고 있는 '속성 값'은 다를 수 있음(일반적으로 다름)

// 클래스 선언 방법
// class 클래스명 { 속성1, 속성2, ..., 기능1, 기능2, ... }
// 속성: 변수, 특성, 필드, 상태
// 기능: 메소드, 함수, 행위

class SmartPhone {
//	상태 -> 기종, 색상, 메모리, 전화번호, 전원
	String modelName;
	String color;
	int memory;
	String telNumber;
	boolean power;

//	기능 -> 전화걸기, 영상시청, 메세지 보내기, 전원키고 끄기

	void call(String toTelNumber) {
		System.out.println(toTelNumber + "로 전화를 겁니다.");
	}

	void showVideo() {
		System.out.println("영상을 시청합니다.");
	}

	void sendMessage(String message, String toTelNumber) {
		System.out.println(toTelNumber + "로 " + message + "를 보냅니다.");
	}

	void setPower() {
		power = !power;
	}

}

public class ClassObject {
	public static void main(String[] args) {
//		인스턴스
//		특정 클래스로 생성된 객체를 '인스턴스'라 함
//		클래스로 객체를 생성하는 행위를 '인스턴스화'라고 함

//		인스턴스 선언, 생성 방법
//		클래스 참조변수명(인스턴스명) = new 클래스명();
		SmartPhone iPhone14 = new SmartPhone();
		SmartPhone iPhone14Pro = new SmartPhone();

		System.out.println(iPhone14);
		System.out.println(iPhone14Pro);

//		인스턴스의 속성 접근 및 기능 사용
//		속성 접근: 참조변수.멤버변수;
//		기능 사용: 참조변수.메소드([매개변수[, ...]])
		iPhone14.modelName = "Samsung";
		iPhone14.color = "blue";
		iPhone14.memory = 256;
		iPhone14.telNumber = "010-1231-1241";
		iPhone14.power = false;

		System.out.println(iPhone14.modelName);
		System.out.println(iPhone14.telNumber);
		System.out.println("==========================================================");

		System.out.println(iPhone14Pro.modelName);
		System.out.println(iPhone14Pro.memory);
		System.out.println(iPhone14Pro.power);

		iPhone14.call("010-1111-1111");
		iPhone14.showVideo();
		System.out.println(iPhone14.power);
		iPhone14.sendMessage("ㅎㅇ", "010-1111-1111");
		iPhone14.setPower();
		System.out.println(iPhone14.power);

		iPhone14Pro = iPhone14; // 값이 아니라 주소를 넘겨준거임(공간의 구조만 알려줌)
		iPhone14Pro.telNumber = "010-9999-9999";
		System.out.println(iPhone14);
		System.out.println(iPhone14Pro);
//		↑ 주소가 같음
		System.out.println("==========================================================");

//		객체배열
//		클래스명[] 객체배열명 = new 클래스면[길이];
		SmartPhone[] smartPhonList = new SmartPhone[3];

		smartPhonList[0] = iPhone14;
		smartPhonList[1] = iPhone14Pro;
		smartPhonList[2] = new SmartPhone();

//		SmartPhone smartPhone = new SmartPhone();
		for (int index = 0; index < smartPhonList.length; index++) {
			SmartPhone smartPhone = new SmartPhone();
			smartPhone.telNumber = "010-1111-111" + index;
			smartPhonList[index] = smartPhone;
		}

		for (SmartPhone phone : smartPhonList) {
			System.out.println(phone.telNumber);
//			↑ 주소가 다 다름
		}

	}

}
