package DTO;

public class ExhibitionDTO {
	String name;
	String genre;
	String sponsor;
	String id;//�߰�
	
	public String getName() {
		return name;
	}
	public ExhibitionDTO setName(String name) {
		this.name = name;
		return this;
	}
	public String getGenre() {
		return genre;
	}
	public ExhibitionDTO setGenre(String genre) {
		this.genre = genre;
		return this;
	}
	public String getSponsor() {
		return sponsor;
	}
	public ExhibitionDTO setSponsor(String sponsor) {
		this.sponsor = sponsor;
		return this;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String toString() {
	      return "�����̸� : " + name + " \n �帣 : " + genre + " / ������ : " + sponsor + "";
	}
	
	
}
