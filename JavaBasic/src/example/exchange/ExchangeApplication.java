package example.exchange;

import java.util.Scanner;

// 환전기 어플리케이션
// Input : 금액, 넣을 화폐, 바꿀 화폐
// Output : 금액, 바뀐 화폐

public class ExchangeApplication {
	
	private static String[] managedCurrencies = {
		"KRW", "USD", "JPY"
	};
	
	private static ExchangeRate[] exchangeRates = {
//		원화 - 달러
			new ExchangeRate("KRW", "USD", 0.76 / 1000),
//		원화 - 엔
			new ExchangeRate("KRW", "JPY", 104.11 / 1000),
//		달러 - 원화
			new ExchangeRate("USD", "KRW", 1322.50 / 1),
//		달러 - 엔
			new ExchangeRate("USD", "JPY", 137.68 / 1),
//		엔 - 원화
			new ExchangeRate("JPY", "KRW", 1000 / 104.11),
//		엔 - 달러
			new ExchangeRate("JPY", "USD", 0.76 / 104.11),
	};
	
	public static void main(String[] args) {
		
//		입력
		Scanner scanner = new Scanner(System.in);
		String exchangingCurrency = null;
		String exchangedCurrency = null;
		int amount = 0;
		
		try {
			System.out.print("넣을 화폐 : ");
			exchangingCurrency = scanner.nextLine();
			System.out.print("바꿀 화폐 : ");
			exchangedCurrency = scanner.nextLine();
			System.out.print("금액 : ");
			amount = scanner.nextInt();
		} catch (Exception exception) {
//			exception.printStackTrace();
			System.out.println("입력값의 타입이 맞지않습니다.");
			return;
		}
		
		
//		입력 검증
//		모두 입력했는지
		if (exchangingCurrency.isBlank() || exchangedCurrency.isBlank()) {
			System.out.println("모두 입력해주세요.");
			return;
		}
		
//		입력한 화폐가 동일 할 때
		if (exchangingCurrency.equals(exchangedCurrency)) {
			System.out.println("동일한 화폐로 변경할 수 없습니다.");
		}
		
//		유용한 금액이 아닐 때 (금액이 양수가 아닐 때)
		if (amount <= 0) {
			System.out.println("유효한 금액이 아닙니다.");
		}
		
//		관리하고있는 화폐 단위가 아닐 때
		boolean hasExchanging = false;
		boolean hasExchanged = false;
		
		for (String managedCurrency : managedCurrencies) {
			if (exchangingCurrency.equals(managedCurrency)) {
				hasExchanging = true;
			}
			if (exchangedCurrency.equals(managedCurrency)) {
				hasExchanged = true;
			}
		}
		
		if (!(hasExchanging && hasExchanged)) {
			System.out.println("유효하지 않은 화폐 단위입니다.");
			return;
		}
		
		double resultAmount = amount;
		
		for (ExchangeRate exchangeRate : exchangeRates) {
			boolean isSame = exchangingCurrency.equals(exchangeRate.getExchangingCurrency()) && exchangedCurrency.equals(exchangeRate.getExchangedCurrency());
			if (isSame) {
				resultAmount *= exchangeRate.getExchangeRate();
				break;	// 만족하면 프로세스가 종료 될 수 있게끔(메모리 낭비 방지)
			}
		}
		
//		정상 출력
		System.out.println(exchangedCurrency + ": " + resultAmount);
		
	}
}
