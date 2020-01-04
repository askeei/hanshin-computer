package DTO;

public class OpenPerformanceDTO {
	int pno;
	String name;//�߰�
	String place;//�߰�
	String sdate;
	String edate;
	String stime;
	int priceSeatR;
	int priceSeatS;
	int priceSeatA;
	String id;//����
	int opened;//�߰� - ���� ����
	
	public int getOpened() {
		return opened;
	}
	public void setOpened(int opened) {
		this.opened = opened;
	}
	public int getPno() {
		return pno;
	}
	public OpenPerformanceDTO setPno(int pno) {
		this.pno = pno;
		return this;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
	public String getSdate() {
		return sdate;
	}
	public OpenPerformanceDTO setSdate(String sdate) {
		this.sdate = sdate;
		return this;
	}
	public String getEdate() {
		return edate;
	}
	public OpenPerformanceDTO setEdate(String edate) {
		this.edate = edate;
		return this;
	}
	public String getStime() {
		return stime;
	}
	public OpenPerformanceDTO setStime(String stime) {
		this.stime = stime;
		return this;
	}
	
	public int getPriceSeatR() {
		return priceSeatR;
	}
	public OpenPerformanceDTO setPriceSeatR(int priceSeatR) {
		this.priceSeatR = priceSeatR;
		return this;
	}
	public int getPriceSeatS() {
		return priceSeatS;
	}
	public OpenPerformanceDTO setPriceSeatS(int priceSeatS) {
		this.priceSeatS = priceSeatS;
		return this;
	}
	public int getPriceSeatA() {
		return priceSeatA;
	}
	public OpenPerformanceDTO setPriceSeatA(int priceSeatA) {
		this.priceSeatA = priceSeatA;
		return this;
	}
	public String getId() {
		return id;
	}
	public OpenPerformanceDTO setId(String id) {
		this.id = id;
		return this;
	}
	public String toString() {
	      return "<tr><th>�Ⱓ</th><td>"+ sdate + " ~ " + edate + "</td></tr>"
	    		  + "<tr><th>���</th><td>" + place + "</td></tr>"
	    		  + "<tr><th>���۽ð�</th><td>" + stime + "</td></tr>"
	    		  + "<tr><th>����</th><td>R�� " + priceSeatR + " / S�� " 
	    		  + priceSeatS + " / A�� " + priceSeatA + "</td></tr>";
	}
}
