package java_exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApplication {
	static List<User> userList = new ArrayList<>();
	public static void main(String[] args) {
		String email = null;
		
		while (true) {
			User user = new User();
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("이메일 : ");
			user.setEmail(scanner.nextLine());
			
			System.out.print("비밀번호 : ");
			user.setPassword(scanner.nextLine());
			
			System.out.print("비밀번호 확인 : ");
			user.setPasswordCheck(scanner.nextLine());
			
			System.out.print("이름 : ");
			user.setName(scanner.nextLine());
			
			System.out.print("전화번호 : ");
			user.setTelNumber(scanner.nextLine());
			
			if (user.valid()) {
				System.out.println("모두 입력하세요.");
				continue;
			}
			
			if (user.getEmail().equals(email)) {
				System.out.println("이메일이 존재합니다.");
				continue;
			}
			
			if (!user.getPassword().equals(user.getPasswordCheck())) {
				System.out.println("비밀번호가 서로 다릅니다.");
				continue;
			}
			userList.add(user);
			System.out.println(user.toString());
			break;
		}
	}
}
