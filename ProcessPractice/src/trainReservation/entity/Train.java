package trainReservation.entity;

import java.util.List;

// 기차 정보 Entity class
public class Train {
	private String trainNumber; // 열차번호
	private String departureTimes; // 출발시간
	private String departureStation; // 출발역
	private String arrivalTime; // 도착시간
	private String arrivalStation; // 도착역
	private int takeMinute; // 걸리는 시간(분 단위)
	private String type; // 기차종류

	private List<StopStation> stopStations;
	private List<Seat> seats;
	
	public Train() {}

	public Train(String trainNumber, String departureStation, String departureTimes, String arrivalStation,
			String arrivalTime, int takeMinute, String type, List<StopStation> stopStations, List<Seat> seats) {
		this.trainNumber = trainNumber;
		this.departureTimes = departureTimes;
		this.departureStation = departureStation;
		this.arrivalTime = arrivalTime;
		this.arrivalStation = arrivalStation;
		this.takeMinute = takeMinute;
		this.type = type;
		this.stopStations = stopStations;
		this.seats = seats;
	}

	public String getTrainNumber() {
		return trainNumber;
	}

	public String getDepartureTimes() {
		return departureTimes;
	}

	public String getDepartureStation() {
		return departureStation;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public String getArrivalStation() {
		return arrivalStation;
	}

	public int getTakeMinute() {
		return takeMinute;
	}

	public String getType() {
		return type;
	}

	public List<StopStation> getStopStations() {
		return stopStations;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	@Override
	public String toString() {
		return "Train [trainNumber: " + trainNumber + ", departureTimes: " + departureTimes 
				+ ", departureStation: "+ departureStation + ", arrivalTime: " + arrivalTime 
				+ ", arrivalStation: " + arrivalStation+ ", takeMinute: " + takeMinute 
				+ ", type: " + type + ", stopStations: " + stopStations + ", seats: "+ seats + "]";
	}
	
	
}
