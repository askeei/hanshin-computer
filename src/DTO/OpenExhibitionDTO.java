package DTO;

public class OpenExhibitionDTO {
   int eno;
   String name;//추가
   String place;//추가
   String sdate;
   String edate;
   int price;
   String id;//수정
   int opened;//추가 - 개시 여부
   
   public int getOpened() {
      return opened;
   }
   public void setOpened(int opened) {
      this.opened = opened;
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
   
   public int getEno() {
      return eno;
   }
   public OpenExhibitionDTO setEno(int eno) {
      this.eno = eno;
      return this;
   }
   public String getSdate() {
      return sdate;
   }
   public OpenExhibitionDTO setSdate(String sdate) {
      this.sdate = sdate;
      return this;
   }
   public String getEdate() {
      return edate;
   }
   public OpenExhibitionDTO setEdate(String edate) {
      this.edate = edate;
      return this;
   }
   public int getPrice() {
      return price;
   }
   public OpenExhibitionDTO setPrice(int price) {
      this.price = price;
      return this;
   }
   public String getId() {
      return id;
   }
   public OpenExhibitionDTO setId(String id) {
      this.id = id;
      return this;
   }
   public String toString() {
	   String tmp;
	   int a = 0;
	   if(price == 0) tmp = "무료";
	   else tmp = Integer.toString(price);
        return "<tr><th>기간</th><td>"+ sdate + " ~ " + edate + "</td></tr>"
              + "<tr><th>장소</th><td>" + place + "</td></tr>"
              + "</td></tr>"
              + "<tr><th>가격</th><td>" + tmp + "</td></tr>";
  }
}