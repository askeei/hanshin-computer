package DTO;

public class PerformanceDTO {
	String name;
	String type;
	int time;
	String id;//추가
	
	public String getName() {
		return name;
	}
	public PerformanceDTO setName(String name) {
		this.name = name;
		return this;
	}

	public PerformanceDTO setType(String type) {
		this.type = type;
		return this;
	}
	public String getType() {
		return type;
	}

	public int getTime() {
		return time;
	}
	public PerformanceDTO setTime(int time) {
		this.time = time;
		return this;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String toString() {
	      return " 공연이름 : " + name + "\n 공연유형 : " + type + " / 공연시간 : " + time ;
	}
}