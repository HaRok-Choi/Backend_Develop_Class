package trainReservation.entity;

// 비용 Entity class
// 비용 (class -> 출발역, 도착역, 금액)
// 독립적
public class Cost {
	private String departureStation;
	private String arrivalStation;
	private int amount;

	public Cost() {}

	public Cost(String departureStation, String arrivalStation, int amount) {
		this.departureStation = departureStation;
		this.arrivalStation = arrivalStation;
		this.amount = amount;
	}
	
//	읽기 전용이라 setter는 굳이 필요없는 규칙이 있음
	public String getDepartureStation() {
		return departureStation;
	}

	public String getArrivalStation() {
		return arrivalStation;
	}

	public int getAmount() {
		return amount;
	}

	@Override
	public String toString() {
//		Object에 toString이라는 클래스가 있는데 Override한 것이다.
		return "Cost [departureStation: " + departureStation + 
				", arrivalStation: " + arrivalStation + 
				", amount: " + amount + "]";
	}

}
