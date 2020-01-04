package controller;

import DTO.*;
import main.Scanner;

public class AdminController {
	private static final String[] performanceTypeTitle = 
		{"concert", "musical", "opera", "act", "talk show", "etc"};

	private static final String[] exhibitionTypeTitle = 
		{"art", "photo", "caligraphy", "sculpture", "etc"};

	public static void adminInit(String id){

		while(true) {
			view.UI.doAdminMenu(id);
			String selectNum = Scanner.getString();
			if(selectNum.compareTo("7") == 0) return;   //�α׾ƿ�

			switch(selectNum) {
			case "1":   //�� ����,���� ���
				view.UI.doSelectPE();
				String selectNum2= Scanner.getString();
				if(selectNum2.compareTo("1") == 0)
					doPRegist(id);
				else if(selectNum2.compareTo("2") == 0)
					doERegist(id);
				else
					System.out.println(" �� �߸� �Է��ϼ̽��ϴ�!");
				break;
			case "2":
				doMyPEInquiry(id);   //�� ����,���� ��ȸ
				break;
			case "3":
				view.UI.doSelectPE();
				selectNum2= Scanner.getString();
				if(selectNum2.compareTo("1") == 0)
					doOpenPRegist(id);
				else if(selectNum2.compareTo("2") == 0)
					doOpenERegist(id);
				break;
			case "4":
				doOpenPEUpdate(id);
				break;
			case "5":
				doOpenPEDelete(id);
				break;
			case "6":
				new TicketController().adminTicketCurrent(id);
				break;
			default:
				System.out.println(" �� �߸� �Է��ϼ̽��ϴ�!");
			}
		}
	}

	public static void doPRegist(String id) { // ���� �ȵ� ���� ���(P:Performance)
		System.out.println("*********************************");
		System.out.println("* \t       ���� ���\t\t*");
		System.out.println("*********************************");
		do {
			System.out.print(" >> ���� �̸� : ");
			SystemController.pDto.setName(Scanner.getString());
			if(SystemController.pDao.checkName(SystemController.pDto.getName()))
				System.out.println(" �� �ߺ��� �����Դϴ�! ");
			else break;
		} while(true);

		for(int i = 0; i< performanceTypeTitle.length; i++) {
			System.out.print((i+1)+") " + performanceTypeTitle[i] + "  ");
			if(i == 2) System.out.println();
		}
		System.out.println();
		System.out.print(" >> Ÿ�� : ");
		SystemController.pDto.setType(performanceTypeTitle[Scanner.getInt()-1]);

		System.out.print(" >> �����ð� : ");
		SystemController.pDto.setTime(Scanner.getInt());

		SystemController.pDto.setId(id);

		if(SystemController.pDao.performanceAdd(
				SystemController.pDto))
			System.out.println(" �١� ������ ��ϵǾ����ϴ� �ڡ� ");
		else
			System.out.println(" �� �ٽ� �õ����ּ���! ");
	}

	public static void doERegist(String id) { // ���� �ȵ� ���� ���(E:Exhibition)
		System.out.println("*********************************");
		System.out.println("* \t       ���� ���\t\t*");
		System.out.println("*********************************");
		do {
			System.out.print(" >> ���� �̸� : ");
			SystemController.eDto.setName(Scanner.getString());
			if(SystemController.eDao.checkName(SystemController.eDto.getName()))
				System.out.println(" �� �ߺ��� �����Դϴ�! ");
			else break;
		} while(true);


		for(int i = 0; i< exhibitionTypeTitle.length; i++) {
			System.out.print((i+1)+") " + exhibitionTypeTitle[i] + "  ");
			if(i == 2) System.out.println();
		}
		System.out.println();
		System.out.print(" >> �帣 : ");
		SystemController.eDto.setGenre(exhibitionTypeTitle[Scanner.getInt()-1]);

		System.out.print(" >> ������ : ");
		SystemController.eDto.setSponsor(Scanner.getString());


		SystemController.eDto.setId(id);

		if(SystemController.eDao.exhibitionAdd(
				SystemController.eDto))
			System.out.println(" �١� ���ð� ��ϵǾ����ϴ� �ڡ� ");
		else
			System.out.println(" �� �ٽ� �õ����ּ���! ");
	}

	public static void doMyPEInquiry(String id) {   //�� ����,���� ��ȸ
		view.UI.doSelectPE();
		String selectPE = Scanner.getString();

		if(selectPE.compareTo("1") == 0) {
			if(SystemController.pDao.adminInquiryPerformanceById(id) == null) {
				System.out.println(" �� �߰��� ������ �����ϴ�! ");
				return;
			}
			System.out.println("*********************************");
			System.out.println("* \t    ���� ����� ���� ��ȸ\t\t*");
			System.out.println("*********************************");

			for(PerformanceDTO tmp: SystemController.pDao.adminInquiryPerformanceById(id))
				System.out.println(tmp);

			System.out.println("*\t   * Opened *\t\t*");
			for(OpenPerformanceDTO tmp: SystemController.pDao.adminInquiryOpenPerformanceById(id))
				System.out.println(tmp);
		}
		else if(selectPE.compareTo("2") == 0) {
			if(SystemController.eDao.adminInquiryExhibitionById(id) == null) {
				System.out.println(" �� �߰��� ���ð� �����ϴ�! ");
				return;
			}
			System.out.println("*********************************");
			System.out.println("* \t    ���� ����� ���� ��ȸ\t\t*");
			System.out.println("*********************************");

			for(ExhibitionDTO tmp: SystemController.eDao.adminInquiryExhibitionById(id))
				System.out.println(tmp);

			System.out.println("*\t   * Opened *\t\t*");
			for(OpenExhibitionDTO tmp: SystemController.eDao.adminInquiryOpenExhibitionById(id))
				System.out.println(tmp);

		}
		else
			System.out.println(" �� �߸� �Է��ϼ̽��ϴ�! ");

	}

	public static void doOpenPRegist(String id) { // ���� ��û(P:Performance)
		if(SystemController.pDao.adminInquiryPerformanceById(id) == null) {
			System.out.println(" �� �߰��� ������ �����ϴ�! ");
			return;
		}

		System.out.println("*********************************");
		System.out.println("* \t       ���� ��û\t\t*");
		System.out.println("* \t    ���� �߰��� ���� ���\t\t*");
		System.out.println("*********************************");

		for(PerformanceDTO tmp: SystemController.pDao.adminInquiryPerformanceById(id))
			System.out.println(tmp);

		do {
			System.out.print(" >> ���� �̸� : ");
			SystemController.opDto.setName(Scanner.getString());
			if(!SystemController.pDao.checkName(SystemController.opDto.getName()))
				System.out.println(" �� �������� �ʴ� �����Դϴ�! ");
			else break;
		} while(true);

		int stageIndex = 1;
		for(StagePerformanceDTO tmp:SystemController.pDao.totalInquiryStagePerformance())
			System.out.println(" "+(stageIndex++)+" "+tmp);
		System.out.println("*********************************");
		System.out.print(" >> ������ ��ȣ : ");
		int stageSelectNum = Scanner.getInt();

		SystemController.opDto.setPlace(
				SystemController.pDao.totalInquiryStagePerformance()
				.elementAt(stageSelectNum-1).getPlace());

		System.out.print(" >> ���۳�¥(00. 00. 00) : ");
		SystemController.opDto.setSdate(Scanner.getString());

		System.out.print(" >> ���ᳯ¥(00. 00. 00) : ");
		SystemController.opDto.setEdate(Scanner.getString());

		System.out.print(" >> ���۽ð�(00:00) : ");
		SystemController.opDto.setStime(Scanner.getString());

		System.out.print(" >> R�� ���� : ");
		SystemController.opDto.setPriceSeatR(Scanner.getInt());
		System.out.print(" >> S�� ���� : ");
		SystemController.opDto.setPriceSeatS(Scanner.getInt());
		System.out.print(" >> A�� ���� : ");
		SystemController.opDto.setPriceSeatA(Scanner.getInt());
		SystemController.opDto.setId(id);
		SystemController.opDto.setOpened(0);

		if(SystemController.pDao.openPerformanceAdd(
				SystemController.opDto))
			System.out.println(" �١� ������ ��û�Ǿ����ϴ� �ڡ� ");
		else
			System.out.println(" �� �ٽ� �õ����ּ���! ");
	}

	public static void doOpenERegist(String id){ // ���� ��û(E:Exhibition)
		if(SystemController.eDao.adminInquiryExhibitionById(id) == null) {
			System.out.println(" �� �߰��� ���ð� �����ϴ�! ");
			return;
		}
		System.out.println("*********************************");
		System.out.println("* \t       ���� ��û\t\t*");
		System.out.println("* \t    ���� �߰��� ���� ���\t\t*");
		System.out.println("*********************************");

		for(ExhibitionDTO tmp: SystemController.eDao.adminInquiryExhibitionById(id))
			System.out.println(tmp);
		do {
			System.out.print(" >> ���� �̸� : ");
			SystemController.oeDto.setName(Scanner.getString());
			if(!SystemController.eDao.checkName(SystemController.oeDto.getName()))
				System.out.println(" �� �������� �ʴ� �����Դϴ�! ");
			else break;
		} while(true);

		int stageIndex = 1;
		for(StageExhibitionDTO tmp:SystemController.eDao.totalInquirStageExhibition())
			System.out.println(" "+(stageIndex++)+" "+tmp);
		System.out.println("*********************************");
		System.out.print(" >> ������ ��ȣ : ");
		int stageSelectNum = Scanner.getInt();

		SystemController.oeDto.setPlace(
				SystemController.eDao.totalInquirStageExhibition()
				.elementAt(stageSelectNum-1).getPlace());

		System.out.print(" >> ���۳�¥(00. 00. 00) : ");
		SystemController.oeDto.setSdate(Scanner.getString());

		System.out.print(" >> ���ᳯ¥(00. 00. 00) : ");
		SystemController.oeDto.setEdate(Scanner.getString());

		System.out.print(" >> ���� : ");
		SystemController.oeDto.setPrice(Scanner.getInt());

		SystemController.oeDto.setId(id);
		SystemController.oeDto.setOpened(0);

		if(SystemController.eDao.openExhibitionAdd(
				SystemController.oeDto))
			System.out.println(" �١� ���ð� ��û�Ǿ����ϴ� �ڡ� ");
		else
			System.out.println(" �� �ٽ� �õ����ּ���! ");
	}

	public static void doOpenPEUpdate(String id){
		view.UI.doSelectPE();
		String selectPE = Scanner.getString();

		if(selectPE.compareTo("1") == 0) {
			if(SystemController.pDao.adminInquiryPerformanceById(id) == null) {
				System.out.println(" �� �߰��� ������ �����ϴ�! ");
				return;
			}
			System.out.println("*********************************");
			System.out.println("* \t       ���� ����\t\t*");
			System.out.println("* \t    ���� �߰��� ���� ���\t\t*");
			System.out.println("*********************************");

			for(OpenPerformanceDTO tmp: SystemController.pDao.adminInquiryOpenPerformanceById(id))
				System.out.println(tmp);
			do {
				System.out.print(" >> ���� ��ȣ : ");
				SystemController.opDto.setPno(Scanner.getInt());
				if(!SystemController.pDao.checkNum(SystemController.opDto.getPno()))
					System.out.println(" �� �������� �ʴ� �����Դϴ�! ");
				else break;
			} while(true);

			System.out.println(" 1)���۳�¥ 2)���ᳯ¥ 3)���۽ð�\n"
					+ " 4)R�� ���� 5)S�� ���� 6)A�� ����");

			System.out.print(" >> ������ ���� ���� : ");
			int selectNum = Scanner.getInt();

			System.out.print(" >> ������ ���� �Է� : ");
			String content = Scanner.getString();

			if(selectNum <4 &&
					SystemController.pDao.updateTitleById1(SystemController.opDto.getPno(), 
							SystemController.pDao.getMemberTitleById(id).get(selectNum+1), content)) 
				System.out.println(" �١� �����Ǿ����ϴ� �ڡ� ");
			else if(selectNum >= 4 &&
					SystemController.pDao.updateTitleById2(SystemController.opDto.getPno(), 
							SystemController.pDao.getMemberTitleById(id).get(selectNum+1), content))
				System.out.println(" �١� �����Ǿ����ϴ� �ڡ� ");
			else 
				System.out.println(" �� ����! �ٽ� �õ��ϼ���");
		}
		else if(selectPE.compareTo("2") == 0) {
			if(SystemController.eDao.adminInquiryExhibitionById(id) == null) {
				System.out.println(" �� �߰��� ���ð� �����ϴ�! ");
				return;
			}
			System.out.println("*********************************");
			System.out.println("* \t       ���� ����\t\t*");
			System.out.println("* \t    ���� �߰��� ���� ���\t\t*");
			System.out.println("*********************************");

			for(OpenExhibitionDTO tmp: SystemController.eDao.adminInquiryOpenExhibitionById(id))
				System.out.println(tmp);

			do {
				System.out.print(" >> ���� ��ȣ : ");
				SystemController.oeDto.setEno(Scanner.getInt());
				if(!SystemController.eDao.checkoeNum(SystemController.oeDto.getEno()))
					System.out.println(" �� �������� �ʴ� �����Դϴ�! ");
				else break;
			} while(true);

			System.out.println(" 1)���۳�¥ 2)���ᳯ¥ 3)����");

			System.out.print(" >> ������ ���� ���� : ");
			int selectNum = Scanner.getInt();

			System.out.print(" >> ������ ���� �Է� : ");
			String content = Scanner.getString();

			if(selectNum <3 &&
					SystemController.eDao.updateTitleById1(SystemController.oeDto.getEno(), 
							SystemController.eDao.getMemberTitleById(id).get(selectNum+1), content)) 
				System.out.println(" �١� �����Ǿ����ϴ� �ڡ� ");
			else if(selectNum == 3 &&
					SystemController.eDao.updateTitleById2(SystemController.oeDto.getEno(), 
							SystemController.eDao.getMemberTitleById(id).get(selectNum+1), content))
				System.out.println(" �١� �����Ǿ����ϴ� �ڡ� ");
			else 
				System.out.println(" �� ����! �ٽ� �õ��ϼ���");
		}
	}
	public static void doOpenPEDelete(String id){
		view.UI.doSelectPE();
		String selectPE = Scanner.getString();

		if(selectPE.compareTo("1") == 0) {
			if(SystemController.pDao.adminInquiryPerformanceById(id) == null) {
				System.out.println(" �� �߰��� ������ �����ϴ�! ");
				return;
			}
			System.out.println("*********************************");
			System.out.println("* \t       ���� ����\t\t*");
			System.out.println("* \t    ���� �߰��� ���� ���\t\t*");
			System.out.println("*********************************");
			for(OpenPerformanceDTO tmp: SystemController.pDao.adminInquiryOpenPerformanceById(id))
				System.out.println(tmp);
			do {
				System.out.print(" >> ���� ��ȣ : ");
				SystemController.opDto.setPno(Scanner.getInt());
				if(!SystemController.pDao.checkNum(SystemController.opDto.getPno()))
					System.out.println(" �� �������� �ʴ� �����Դϴ�! ");
				else break;
			} while(true);

			if(SystemController.tDao.searchByPno(SystemController.opDto.getPno()))
				System.out.println(" �� ���� Ƽ���� �����մϴ�!");
			else if(SystemController.pDao.deleteOpenPerformance(SystemController.opDto.getPno()))
				System.out.println(" �١� �����Ǿ����ϴ� �ڡ� ");
			else 
				System.out.println(" �� ����! �ٽ� �õ��ϼ���");
		}
		else if(selectPE.compareTo("2") == 0) {
			if(SystemController.eDao.adminInquiryExhibitionById(id) == null) {
				System.out.println(" �� �߰��� ���ð� �����ϴ�! ");
				return;
			}
			System.out.println("*********************************");
			System.out.println("* \t       ���� ����\t\t*");
			System.out.println("* \t    ���� �߰��� ���� ���\t\t*");
			System.out.println("*********************************");

			for(OpenExhibitionDTO tmp: SystemController.eDao.adminInquiryOpenExhibitionById(id))
				System.out.println(tmp);

			do {
				System.out.print(" >> ���� ��ȣ : ");
				SystemController.oeDto.setEno(Scanner.getInt());
				if(!SystemController.eDao.checkoeNum(SystemController.oeDto.getEno()))
					System.out.println(" �� �������� �ʴ� �����Դϴ�! ");
				else break;
			} while(true);

			if(SystemController.eDao.deleteOpenExhibition(SystemController.oeDto.getEno()))
				System.out.println(" �١� �����Ǿ����ϴ� �ڡ� ");
			else 
				System.out.println(" �� ����! �ٽ� �õ��ϼ���");
		}
	}
}