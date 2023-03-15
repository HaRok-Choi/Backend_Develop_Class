package chapter03.E_Inheritance;

// 상속
// 기존 클래스를 재사용해서 새로운 클래스를 작성하는 것
// 코드의 재사용성을 높이고 코드의 중복을 제거 -> 생산성이 향상, 유지보수성이 향상

// 사용 방법:
// class 클래스명 extends 조상클래스 { ... }

class Human {
	String name;
	int age;
	String telNumber;
	String country;
	
	public Human() { }
	
	Human(String name, int age) {
		this.name = name;
		this.age = age;
		this.telNumber = "010-1111-2222";
		this.country = "Korea";
	}
	
	void eat(String food) {
		System.out.println(this.name + "이(가) " + food + "를 먹습니다.");
	}
}

// Developer 클래스는 Human의 속성과 기능을 모두 사용 가능
class Developer extends Human {
	String position;
	String language;
	
	public Developer() { }
	
	Developer(String name, int age, String position, String language) {
//		super(): 부모클래스의 생성자를 지칭
		super(name, age);
		this.position = position;
		this.language = language;
	}
	
	void develop() {
		System.out.println(super.name + "이(가) " + this.language + "로 " + this.position + " 개발을 합니다.");
	}
}

public class Inheritance {
	public static void main(String[] args) {
		
		Developer developer1 = new Developer();
		
		developer1.name = "harok";
		developer1.position = "BackEnd";
		developer1.language = "Java";
		
		developer1.eat("사과");
		developer1.develop();
		
		Developer developer2 = new Developer("Harok", 26, "FrontEnd", "JavaScript");
		developer2.eat("바나나");
		developer2.develop();
		
		
	}
}
