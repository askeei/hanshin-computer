package DTO;

// ���� ���� ��� �޼ҵ�
public class TicketDTO {
	int tno;
	String id;
	int pno;
	String seat;
	String tdate;
	
	public int getTno() {
		return tno;
	}
	public TicketDTO setTno(int tno) {
		this.tno = tno;
		return this;
	}
	public String getId() {
		return id;
	}
	public TicketDTO setId(String id) {
		this.id = id;
		return this;
	}
	public int getPno() {
		return pno;
	}
	public TicketDTO setPno(int pno) {
		this.pno = pno;
		return this;
	}
	public String getSeat() {
		return seat;
	}
	public TicketDTO setSeat(String seat) {
		this.seat = seat;
		return this;
	}
	public String getTdate() {
		return tdate;
	}
	public TicketDTO setTdate(String tdate) {
		this.tdate = tdate;
		return this;
	}
	
	public String toString() {
		return " Ƽ�Ϲ�ȣ : "+ tno + " / ȸ��ID : "+ id + "\n �¼� : " + seat + " / ���ų�¥ : " + tdate;
	}
	
}
