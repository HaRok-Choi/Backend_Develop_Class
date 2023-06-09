package trainReservation.entity;

// 정차역 Entity class
// 정차역 (class -> 정차역에서도 역명, 정차시간, 출발/도착시간이 있기 때문)
public class StopStation {
	private String stationName;
	private String departureTime;
	private String arrivalTime;

	public StopStation() {}

	public StopStation(String stationName, String arrivalTime, String departureTime) {
		this.stationName = stationName;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}

	public String getStationName() {
		return stationName;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	@Override
	public String toString() {
		return "StopStation [stationName: " + stationName 
				+ ", departureTime: " + departureTime
				+ ", arrivalTime: " + arrivalTime + "]";
	}

}
