package chapter02.B_Switch;

import java.util.Scanner;

// switch 조건문
// 비교할 변수를 case 값과 비교하여 같은 case를 찾아
// 해당 case 구문부터 끝까지 실행
// break문으로 해당 switch를 종료
// default문으로 해당하는 case가 없을 때 실행할 구문을 작성

// ★ if - else처럼 생각하지말자
public class Switch {

	public static void main(String[] args) {
//		switch 사용 방법

//		switch문은 조건에 따라서 코드 실행 범위를 지정하는 것

		Scanner scanner = new Scanner(System.in);
		int chapter = scanner.nextInt();

		switch (chapter) {
		case 1:
			System.out.println("기본 문법 공부");
		case 2:
			System.out.println("제어문 공부");
			break;
		case 3:
			System.out.println("객체지향 기본 공부");
		case 4:
			System.out.println("객체지향 응용 공부");
		case 5:
			System.out.println("자바 고급 공부");
		default:
			System.out.println("범위초과");
//			default는 필수가 아님 
		}

	}

}
