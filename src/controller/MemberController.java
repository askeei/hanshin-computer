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
		String[] title = {"��й�ȣ", "�̸�", "����", "��ȭ��ȣ"};
		String content;
		
		for(int i = 0; i <SystemController.memberDao.getMemberTitleById(id).size(); i++) {
//			System.out.print((i+1)+")"+SystemController.memberDao.getMemberTitleById(id).get(i)+" ");
			System.out.print((i+1)+")"+title[i]+"  ");
		}
		System.out.println();
		System.out.print(" >> ������ ���� ���� : ");
		int selectNum = Scanner.getInt();
		
		System.out.print(" >> ������ ���� �Է� : ");
		if(selectNum == 1)
			content = controller.Encryption.Encrypting(Scanner.getString());
		else content = Scanner.getString();
		
		if(SystemController.memberDao.updateTitleById(id, 
				SystemController.memberDao.getMemberTitleById(id).get(selectNum-1), content)) {
			System.out.println(SystemController.memberDao.searchID(id));
		}
		else {
			System.out.println(" �� ����! �ٽ� �õ��ϼ���");
		}

	}

	private void doTicketCancel(String id) {
		//TODO:�ڱ� Ƽ�� ����ߴ�
		tk.showMyTicket(id);
		System.out.print(" > ��� �� seat �¼� �� �Է����ּ���   : ");
		String seat = Scanner.getString();	//
		//tk.cancelTicket(id,seat);	//
	}

	private void doTicketInquiry(String id) {
		//TODO:�ڱ� Ƽ�� Ȯ��
		tk.showMyTicket(id);
	}

	private void doTicketing(String id) {
		//TODO: Ƽ���� ���� �¼� �޾Ƽ� �ؾ��� Ƽ�Ͽ� �߰��ؾߴ�
		tk.ticketing(id);
	}
	
}
