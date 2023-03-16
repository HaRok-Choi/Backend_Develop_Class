package trainReservation;

import java.util.Scanner;

import trainReservation.controller.ReservationController;

// 모든 프로세스, 메서드, 함수의 적용되는 garbage가 들어가면 garbage값이 나옴
public class MainApplication {
	
	private static ReservationController reservationController = new ReservationController();
	
	public static void main(String[] args) {
		
		while (true) {
			Scanner scanner = new Scanner(System.in);
			String endPoint = scanner.nextLine();
			
			if (endPoint.equals("POST /reservation")) 
				reservationController.reservation();
			if (endPoint.equals("GET /reservation"))
				reservationController.getReservation();
		}
	}
}
