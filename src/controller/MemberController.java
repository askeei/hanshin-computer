package controller;

import main.Scanner;

public class MemberController {
	private TicketController tk = new TicketController();
	public int firstQuestion(String id) {
		int select = 0;
		switch(select=Scanner.getInt()) {
		case 1:
			doMemberInfoUpdate(id);
			break;
		case 2:
			doTicketing(id);
			break;
		case 3:
			doTicketInquiry(id);
			break;
		case 4:
			doTicketCancel(id);
			break;
		case 5:
			break;
		}
		return select;
	}


	private void doMemberInfoUpdate(String id) {
		String[] title = {"비밀번호", "이름", "성별", "전화번호"};
		String content;
		
		for(int i = 0; i <SystemController.memberDao.getMemberTitleById(id).size(); i++) {
//			System.out.print((i+1)+")"+SystemController.memberDao.getMemberTitleById(id).get(i)+" ");
			System.out.print((i+1)+")"+title[i]+"  ");
		}
		System.out.println();
		System.out.print(" >> 수정할 정보 선택 : ");
		int selectNum = Scanner.getInt();
		
		System.out.print(" >> 수정할 내용 입력 : ");
		if(selectNum == 1)
			content = controller.Encryption.Encrypting(Scanner.getString());
		else content = Scanner.getString();
		
		if(SystemController.memberDao.updateTitleById(id, 
				SystemController.memberDao.getMemberTitleById(id).get(selectNum-1), content)) {
			System.out.println(SystemController.memberDao.searchID(id));
		}
		else {
			System.out.println(" ※ 오류! 다시 시도하세요");
		}

	}

	private void doTicketCancel(String id) {
		//TODO:자기 티켓 끊어야댐
		tk.showMyTicket(id);
		System.out.print(" > 취소 할 seat 좌석 을 입력해주세요   : ");
		String seat = Scanner.getString();	//
		//tk.cancelTicket(id,seat);	//
	}

	private void doTicketInquiry(String id) {
		//TODO:자기 티켓 확인
		tk.showMyTicket(id);
	}

	private void doTicketing(String id) {
		//TODO: 티켓팅 이제 좌석 받아서 해야함 티켓에 추가해야댐
		tk.ticketing(id);
	}
	
}
