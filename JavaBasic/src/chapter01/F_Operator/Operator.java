package chapter01.F_Operator;

// 연산자
// 산술연산자, 대입연산자, 관계연산자, 논리연산자, 삼항연산자
// ( )로 묶어주면 가독성이 좋아짐

public class Operator {

	public static void main(String[] args) {
//		산술연산자(All 좌항 기준)

//		덧셈연산자 : +
		int addResult = 8 + 3;
		System.out.println(addResult);

//		뺄셈 연산자 : -
		int minusResult = 8 - 3;
		System.out.println(minusResult);

//		곱셈 연산자 : *
		int multiResult = 8 * 3;
		System.out.println(multiResult);

//		니눗셈 연산자 : /
//		나눈 값을 반환
		int remainderResult = 8 / 3;
		float float1 = 2.6666F;
		int number1 = (int) float1;

		System.out.println(number1);
		System.out.println(remainderResult);

		double remainderResult2 = 8.0 / 3.0;
		System.out.println(remainderResult2);

//		나머지 연산자 : %
//		나눈 나머지를 반환
		int remainderResult3 = 8 % 3;
		System.out.println(remainderResult3);

//		정수와 정수를 연산하면 정수가 반환됨
//		실수와 정수를 연산하면 실수가 반환됨
//		실수와 실수를 연산하면 실수가 반환됨

//		증감연산자: '변수' 자신을 1 증가 혹은 감소

//		증가연산자: ++
//		연산자의 좌항 or 우항의 값을 1 증가 시킴
		int integer1 = 10;
		++integer1;
		System.out.println(integer1);
		integer1++;
		System.out.println(integer1);

		integer1 = 0;
		System.out.println(integer1);
		System.out.println(++integer1);

		System.out.println(integer1);
		System.out.println(integer1++);

		System.out.println(integer1);
//		상수에는 증감연산자 사용 불가능

//		감소연산자: --
//		연산자의 좌항 or 우항에 값을 1 감소 시킴
		int integer2 = 10;
		--integer2;
		integer2--;

		int number2 = 8;
		int number3 = 3;
		int sampleNumber = number2 / number3++;
		System.out.println(sampleNumber);

//		대입연산자 (좌항기준)
//		좌항에 우항을 (누적)대입
//		좌항의 변수에 좌항 변수와 우항을 연산한 결과를 대입

//		= : 좌항에 우항을 대입
		int number4 = 10;

//		+= : 좌항에 우항을 더한 값을 좌항에 대입
		number4 += 3;
		System.out.println(number4);

//		-= : 좌항에 우항을 뺀 값을 좌항에 대입
		number4 -= 6;
		System.out.println(number4);

//		*= : 좌항에 우항을 곱한 값을 좌항에 대입
		number4 *= 3;
		System.out.println(number4);

//		/= : 좌항에 우항으 나눈 값을 좌항에 대입
		number4 /= 5;
		System.out.println(number4);

//		%= : 좌항에 우항을 나눈 나머지를 좌항에 대입
		number4 %= 3;
		System.out.println(number4);
//		대입 연산자의 좌항에는 무조건 변수만 지정할 수 있음

//		비교 연산자
//		좌항을 우항과 비교한 결과를 논리(true, false) 값으로 반환

//		==
//		좌항이 우항과 같다면 true, 아니면 false 반환
		boolean boolean1 = 10 == 12;
		System.out.println(boolean1);

//		!=
//		좌항이 우항과 다르면 true, 아니면 false 반환
		boolean boolean2 = 10 != 12;
		System.out.println(boolean2);

//		>, >=
//		좌항이 우항보다 크면 true, 아니면 false 반환
//		좌항이 우항보다 크거나 같으면 true, 아니면 false 반환
		boolean boolean3 = 10 > 10;
		boolean boolean4 = 10 >= 10;
		System.out.println(boolean3);
		System.out.println(boolean4);

//		<, <=
//		좌항이 우항보다 작으면 true, 아니면 false 반환
//		좌항이 우항보다 작거나 같으면 true, 아니면 false 반환		
		boolean boolean5 = 8 < 10;
		boolean boolean6 = 10 <= 10;
		System.out.println(boolean5);
		System.out.println(boolean6);

//		논리 연산자

//		&&: AND 연산
//		좌항과 우항이 모두 true일 때 true, 아니면 false
		int number5 = 8;
		int number6 = 3;
		boolean boolean7 = (number5 > number6) && true;

//		||: OR 연산
//		좌항과 우항 중 하나라도 true이면 true, 아니면 false
		boolean boolean8 = false || false;

		boolean boolean9 = (number6 > number5) && (number5++ > number6);
		System.out.println(number5);
		boolean boolean10 = (number5 > number6) || (number6 > ++number5);
		System.out.println(number5);
//		AND나 OR연산을 쓸 때 앞의 식이 결정되면 뒷 연산은 적용하지않음
		
//		!: NOT
//		논리값의 부정을 반환
		boolean boolean11 = !(number5 > number6);
		System.out.println(boolean11);
		
//		삼항 연산자
//		조건에 따라 다른 결과를 반환하는 연산자
//		조건 ? 참일때 결과 : 거짓일때 결과
		String string1 = number5 > number6 ? "3보다 큼" : "3보다 크지 않다";
		System.out.println(string1);

	}

}
