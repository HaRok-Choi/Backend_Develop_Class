package trainReservation.entity;

// 좌석 Entity class
// 남아있는 좌석 (class -> 호차, 좌석번호, 좌석상태)
public class Seat {
	private int roomNumber;
	private String seatNumber;
	private boolean seatStatus;
	
	public Seat() {}
	
	public Seat(int roomNumber, String seatNumber, boolean seatStatus) {
		this.roomNumber = roomNumber;
		this.seatNumber = seatNumber;
		this.seatStatus = seatStatus;
	}

//	웬만하면 this.을 찍는 습관을 들이는것이 좋음(매개변수가 들어오면 헷갈릴 수도 있기 때문)
	public int getRoomNumber() {
		return roomNumber;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public boolean isSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(boolean seatStatus) {
		this.seatStatus = seatStatus;
	}

	@Override
	public String toString() {
		return "Seat [roomNumber: " + roomNumber + ", seatNumber: " + seatNumber + ", seatStatus: " + seatStatus + "]";
	}
	
	
}
