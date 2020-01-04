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

		System.out.print(" >  공연 번호를 입력해주세요    : ");
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
//			System.out.println("***** 티켓 취소가 정상적으로 완료 되었습니다 *******");
//		else
//			System.out.println("***** 티켓 취소가 작동하지않았습니다 고객센터로 문의 주세요 ****");
//	}

	public void ticketing(String id) {
		TicketDTO ticket = new TicketDTO();
		ticket.setPno(pfDao.printSeat(this.showSeats(this.showPerformance())));
		System.out.print("  >   원하는 좌석을 입력해주세요(예: A03) :");
		ticket.setSeat(Scanner.getString().toUpperCase())
		.setId(id)
		.setTdate(getNowDate());

		System.out.print("  >  해당 좌석의 가격을 지불해주세요  : ");

		int chargeMoney = getCharge(ticket.getPno(),Scanner.getInt(),ticket.getSeat().charAt(0));

		if(chargeMoney == -1) {
			System.out.println("  해당 좌석의 가격보다 모자른 값을 지불하였습니다 다시이용해주세요 ");
			return ;
		}
		else
			System.out.println(" *  "+chargeMoney+" 원 잔액을 환불해드렸습니다!!");

		if(tkDao.ticketingRegist(ticket))
			System.out.println("* 예매가 완료 되었습니다   *");
		else
			System.out.println("* 예매가 정상 작동되지 않았습니다 *");
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
					System.out.println(" ※ 공연  '" + SystemController.pDao.memberInquiryOpenPerformance(i).getName() +"' 에 대한  예매자가 없습니다");
					continue;
				}
				view.TicketUI.showTicketUserAdmin(tkList, i);
			}
		}
		else System.out.println("* 공연 정보가 없습니다   *");
	}
}