package DTO;

public class StageExhibitionDTO {
	String place;
	String closure;
	public String getPlace() {
		return place;
	}
	public StageExhibitionDTO setPlace(String place) {
		this.place = place;
		return this;
	}
	public String getClosure() {
		return closure;
	}
	public StageExhibitionDTO setClosure(String closure) {
		this.closure = closure;
		return this;
	}
	public String toString() {
	      return " 전시장소 : " + place + " /\n 폐관날짜 : " + closure;
	}
}
