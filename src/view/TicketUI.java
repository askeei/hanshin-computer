package view;

import java.util.Vector;

import DAO.PerformanceDAO;
import DTO.OpenPerformanceDTO;
import DTO.TicketDTO;

public class TicketUI {
	public static void showTicketInfo(TicketDTO ticket,OpenPerformanceDTO opf,String id) {

		String ticketInfo[] = {"* �¼�  :",ticket.getSeat(),"* ���� ��¥ :",ticket.getTdate()};

		String opfInfo[] = {"* ���� �̸� : ",opf.getName() ,"* ���� �� : ",opf.getPlace(), "* ���� ���� �ð�: ",opf.getStime()};
		System.out.println("******* "+ id +"  ����  Ƽ�� ����   *********");
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
		System.out.println("|           ���� ���� LIST          |");
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
