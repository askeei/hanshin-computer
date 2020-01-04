package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import DAO.PerformanceDAO;
import DAO.TicketDAO;
//import DAO.TicketDAO;
import DTO.OpenPerformanceDTO;
import DTO.TicketDTO;
import main.Scanner;

public class TicketController {
	private PerformanceDAO pfDao=new PerformanceDAO();
	private TicketDAO tkDao =new TicketDAO();
	public void ticketControl(String id) {

	}
	private int showPerformance() {
		Vector<OpenPerformanceDTO> opList= pfDao.totalInquiryOpenPerformanceOpened();
		view.TicketUI.showPerformanceInfo(opList);

		System.out.print(" >  ���� ��ȣ�� �Է����ּ���    : ");
		int select = Scanner.getInt();
		return select;
	}
	public int[] showSeats(int pno) {
		int info[] = pfDao.getSeats(pno);
		return info;
	}
	public void showMyTicket(String id) {
		Vector<TicketDTO> tkList = tkDao.selectTicket(id);
		for(TicketDTO tk : tkList) {
			OpenPerformanceDTO opf = pfDao.memberInquiryOpenPerformance(tk.getPno());
			view.TicketUI.showTicketInfo(tk,opf,id);
		}
	}
//	public void cancelTicket(String id, String seat) {
//		if(tkDao.cancelTicket(id,seat))
//			System.out.println("***** Ƽ�� ��Ұ� ���������� �Ϸ� �Ǿ����ϴ� *******");
//		else
//			System.out.println("***** Ƽ�� ��Ұ� �۵������ʾҽ��ϴ� �����ͷ� ���� �ּ��� ****");
//	}

	public void ticketing(String id) {
		TicketDTO ticket = new TicketDTO();
		ticket.setPno(pfDao.printSeat(this.showSeats(this.showPerformance())));
		System.out.print("  >   ���ϴ� �¼��� �Է����ּ���(��: A03) :");
		ticket.setSeat(Scanner.getString().toUpperCase())
		.setId(id)
		.setTdate(getNowDate());

		System.out.print("  >  �ش� �¼��� ������ �������ּ���  : ");

		int chargeMoney = getCharge(ticket.getPno(),Scanner.getInt(),ticket.getSeat().charAt(0));

		if(chargeMoney == -1) {
			System.out.println("  �ش� �¼��� ���ݺ��� ���ڸ� ���� �����Ͽ����ϴ� �ٽ��̿����ּ��� ");
			return ;
		}
		else
			System.out.println(" *  "+chargeMoney+" �� �ܾ��� ȯ���ص�Ƚ��ϴ�!!");

		if(tkDao.ticketingRegist(ticket))
			System.out.println("* ���Ű� �Ϸ� �Ǿ����ϴ�   *");
		else
			System.out.println("* ���Ű� ���� �۵����� �ʾҽ��ϴ� *");
		return;
	}

	private int getCharge(int pno,int money, char seat) {

		int price = -1;

		switch(seat) {
		case 'R':
			price = SystemController.pDao.priceOfSeatR(pno);
			break;
		case 'S':
			price = SystemController.pDao.priceOfSeatS(pno);
			break;
		case 'A':
			price = SystemController.pDao.priceOfSeatA(pno);
			break;
		}
		if(price > money) return -1;
		else return money -price;
	}

	private String getNowDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yy. MM. dd");
		return sdf.format(date);
	}
	public void adminTicketCurrent(String id) {
		Vector<Integer> pnoList = pfDao.adminInquiryPno(id);
		if(pnoList !=null) {
			for (int i : pnoList) {
				Vector<TicketDTO> tkList = tkDao.adminTicketCurrent(i);
				if(tkList.size()== 0) {
					System.out.println(" �� ����  '" + SystemController.pDao.memberInquiryOpenPerformance(i).getName() +"' �� ����  �����ڰ� �����ϴ�");
					continue;
				}
				view.TicketUI.showTicketUserAdmin(tkList, i);
			}
		}
		else System.out.println("* ���� ������ �����ϴ�   *");
	}
}