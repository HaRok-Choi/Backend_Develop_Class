package trainReservation;

import trainReservation.controller.ReservationController;

// 모든 프로세스, 메서드, 함수의 적용되는 garbage가 들어가면 garbage값이 나옴
public class MainApplication {
	
	private static ReservationController reservationController = new ReservationController();
	
	public static void main(String[] args) {
		
		reservationController.reservation();
		
	}

}
