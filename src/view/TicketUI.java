package view;

import java.util.Vector;

import DAO.PerformanceDAO;
import DTO.OpenPerformanceDTO;
import DTO.TicketDTO;

public class TicketUI {
	public static void showTicketInfo(TicketDTO ticket,OpenPerformanceDTO opf,String id) {

		String ticketInfo[] = {"* 좌석  :",ticket.getSeat(),"* 예약 날짜 :",ticket.getTdate()};

		String opfInfo[] = {"* 공연 이름 : ",opf.getName() ,"* 공연 장 : ",opf.getPlace(), "* 공연 시작 시간: ",opf.getStime()};
		System.out.println("******* "+ id +"  님의  티켓 정보   *********");
		for(int i =0; i< ticketInfo.length; i +=1) {
			if(i %2 == 0) 
				System.out.print(ticketInfo[i]+" ");
			else 
				System.out.println(ticketInfo[i]+" ");
		}
		System.out.println("");
		for(int i=0; i<opfInfo.length;i+=1) {
			if(i%2 == 0)
				System.out.print(opfInfo[i]+" ");
			else
				System.out.println(opfInfo[i]+" ");
		}
		System.out.println("*********************************");
	}
	public static void showPerformanceInfo(Vector<OpenPerformanceDTO> opfList) {
		System.out.println("---------------------------------");
		System.out.println("|           공연 정보 LIST          |");
		System.out.println("---------------------------------");				
		for(OpenPerformanceDTO opf : opfList) {
			System.out.println(opf);
			System.out.println("---------------------------------");
		}
	}
	public static void showTicketUserAdmin(Vector<TicketDTO> tkList, int i) {
		for (TicketDTO tk : tkList) {
			System.out.println("---------------------------------");
			System.out.println("|\t"+new PerformanceDAO().memberInquiryOpenPerformance(i).getName()+"\t|");
			System.out.println("---------------------------------");
			System.out.println(tk);
		}
	}
}
