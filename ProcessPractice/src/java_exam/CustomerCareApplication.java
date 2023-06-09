package java_exam;

import java.util.Scanner;

public class CustomerCareApplication {

	public static void main(String[] args) {

		while (true) {
			Scanner scanner = new Scanner(System.in);
			CustomerInformation customerInformation = new CustomerInformation();

			System.out.print("이름 : ");
			customerInformation.setName(scanner.nextLine());

			System.out.print("성별 : ");
			customerInformation.setGender(scanner.nextLine());

			System.out.print("주소 : ");
			customerInformation.setAddress(scanner.nextLine());

			System.out.print("전화번호 : ");
			customerInformation.setPhoneNumber(scanner.nextLine());

			try {
				System.out.print("마케팅 수신 여부 : ");
				customerInformation.setMarketingReceived(scanner.nextBoolean());

				System.out.print("개인정보 수집 동의 여부 : ");
				customerInformation.setConsentToCollectPersonalInformation(scanner.nextBoolean());
			} catch (Exception exception) {
				System.out.println("true나 false만 입력하세요.");
				continue;
			}

			if (customerInformation.vaild()) {
				System.out.println("모든 값을 입력하세요.");
				continue;
			}

			System.out.println(customerInformation.toString());
		}
	}
}
