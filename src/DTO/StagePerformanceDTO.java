package DTO;

public class StagePerformanceDTO {
	private String place;
	private int seatOfR;
	private int seatOfS;
	private int seatOfA;
	
	public String getPlace() {
		return place;
	}
	public StagePerformanceDTO setPlace(String place) {
		this.place = place;
		return this;
	}
	public int getSeatOfS() {
		return seatOfS;
	}
	public StagePerformanceDTO setSeatOfS(int seatOfS) {
		this.seatOfS = seatOfS;
		return this;
	}
	public int getSeatOfR() {
		return seatOfR;
	}
	public StagePerformanceDTO setSeatOfR(int seatOfR) {
		this.seatOfR = seatOfR;
		return this;
	}
	public int getSeatOfA() {
		return seatOfA;
	}
	public StagePerformanceDTO setSeatOfA(int seatOfA) {
		this.seatOfA = seatOfA;
		return this;
	}
	
	public String toString() {
	      return "[" + place + "] S¼® : " + seatOfS + ", R¼® : " 
	    		  + seatOfR + ", A¼® : " + seatOfA;
	}
}
