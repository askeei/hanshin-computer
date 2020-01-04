package controller;

import DTO.MemberDTO;
import DTO.OpenExhibitionDTO;
import DTO.OpenPerformanceDTO;
import DTO.PerformanceDTO;
import DTO.StageExhibitionDTO;
import DTO.StagePerformanceDTO;
import main.Scanner;

public class RootController {
	static String selectNum3;

	public static void rootInit(){		//�ý��۰����ڿ� �ʱ�ȭ��
		int selectNum;
		int selectNum2;

		while(true) {

			view.UI.doRootMenu();
			selectNum = Scanner.getInt();
			if(selectNum == 4) return;
			else if(selectNum == 3) {
				System.out.println("*  1)��ȸ  2)���� ����  3)����  4)���  	*");
				System.out.print(" ���������� ��ȣ�� �������ּ��� # ");
				selectNum2 = Scanner.getInt();
				controller.RootController.doRootManagement(selectNum, selectNum2);
			}
			else {
				view.UI.doRootMenu2();
				selectNum2 = Scanner.getInt();
				controller.RootController.doRootManagement(selectNum, selectNum2);
			}
		}
	}

	public static void doRootManagement(int selectNum, int selectNum2) {
		if(selectNum == 1) {
			switch(selectNum2) {
			case 1:	//��ȸ
				doMemberAdminInquiry();
				break;
			case 2:	//���
				doAdminRegist();
				break;
			case 3:	//����
				doMemberAdminUpdate();
				break;
			case 4:	//����
				doMemberAdminDelete();
				break;
			case 5:	//���
				break;
			default:
				System.out.println(" �� �߸� �Է��ϼ̽��ϴ�!");
				break;
			}
		}
		else if(selectNum == 2) {	//������, ������ ����
			switch(selectNum2) {
			case 1:	//��ȸ
				doPlaceInquiry();
				break;
			case 2:	//���
				view.UI.doSelectPEStage();
				selectNum3= Scanner.getString();
				if(selectNum3.compareTo("1") == 0)
					doSPRegist();
				else if(selectNum3.compareTo("2") == 0)
					doSERegist();
				else
					System.out.println(" �� �߸� �Է��ϼ̽��ϴ�!");
				break;
			case 3:	//����
				view.UI.doSelectPEStage();
				selectNum3= Scanner.getString();
				if(selectNum3.compareTo("1") == 0)
					doSPUpdate();
				else if(selectNum3.compareTo("2") == 0)
					doSEUpdate();
				else
					System.out.println(" �� �߸� �Է��ϼ̽��ϴ�!");
				break;
			case 4:	//����
				view.UI.doSelectPEStage();
				selectNum3= Scanner.getString();
				if(selectNum3.compareTo("1") == 0)
					doSPDelete();
				else if(selectNum3.compareTo("2") == 0)
					doSEDelete();
				else
					System.out.println(" �� �߸� �Է��ϼ̽��ϴ�!");
				break;

			case 5:	//���
				break;
			default:
				System.out.println(" �� �߸� �Է��ϼ̽��ϴ�!");
			}
		}else if(selectNum == 3) {

			switch(selectNum2) {
			case 1:
				view.UI.doSelectPE();
				selectNum3= Scanner.getString();
				if(selectNum3.compareTo("1")==0)
					doOpenPlaceInquiry();
				else if(selectNum3.compareTo("2") == 0)
					doOpenExhibitionInquiry();
				break;
			case 2:
				//TODO : Ȯ���عپߴ� ����� �Ǿ����� �ȵǾ����� Ȯ�� �Ұ��� �׷��� Ȯ���ؾߴ�!
				view.UI.doSelectPE();
				selectNum3= Scanner.getString();
				if(selectNum3.compareTo("1")==0)
					doOPPublish();
				else if(selectNum3.compareTo("2") == 0)
					doOEPublish();
				else
					System.out.println(" �� �߸� �Է��ϼ̽��ϴ�!");
				break;
			case 3:
				view.UI.doSelectPE();
				selectNum3= Scanner.getString();
				if(selectNum3.compareTo("1")==0)
					doOPDelete();
				else if(selectNum3.compareTo("2") == 0)
					doOEDelete();
				else
					System.out.println(" �� �߸� �Է��ϼ̽��ϴ�!");
				break;
			case 4:
				break;
			}
		}

	}
	public static void doMemberAdminInquiry() { //ȸ��, ������ ��ȸ
		System.out.println("*********************************");
		System.out.println(" \t  < ȸ�� ��� >");

		for(MemberDTO tmp: SystemController.memberDao.searchType(0)) {
			System.out.println(" "+tmp);
		}
		System.out.println("---------------------------------");
		System.out.println(" \t  < ������ ��� >");
		for(MemberDTO tmp: SystemController.memberDao.searchType(1)) {
			System.out.println(" "+tmp);
		}
	}
	public static void doAdminRegist() {	//������ ���
		System.out.println("*********************************");
		System.out.println("* \t       ������ ���\t\t*");
		System.out.println("*********************************");
		do {
			System.out.print(" >> ���̵� : ");
			SystemController.memberDto.setId(Scanner.getString());
			if(SystemController.memberDao.checkID(SystemController.memberDto.getId()))
				System.out.println(" �� �ߺ��� ID�Դϴ�! ");
			else break;
		} while(true);

		String passwd;
		do {
			System.out.print(" >> ��й�ȣ : ");
			SystemController.memberDto.setPw(Encryption.Encrypting(Scanner.getString()));
			System.out.print(" >> ��й�ȣ Ȯ�� : ");
			passwd = Encryption.Encrypting(Scanner.getString());
		} while(SystemController.memberDao.checkPasswd(SystemController.memberDto, passwd));

		System.out.print(" >> �̸� : ");
		SystemController.memberDto.setName(Scanner.getString());

		System.out.print(" >> ���� : ");
		SystemController.memberDto.setSex(Scanner.getString());

		System.out.print(" >> ��ȭ��ȣ : ");
		SystemController.memberDto.setPhone(Scanner.getString());

		SystemController.memberDto.setType(1);
		if(SystemController.memberDao.memberRegist(SystemController.memberDto))
			System.out.println(" �١� �����ڰ� ��ϵǾ����ϴ� �ڡ� ");
		else
			System.out.println(" �� �ٽ� �������ּ���! ");
	}
	public static void doMemberAdminUpdate() { //������ ����
		System.out.println("*********************************");
		System.out.println("* \t       ȸ��, ������ ����\t\t*");
		System.out.println("*********************************");
		String id;
		do {
			System.out.print(" >> ������ ��� ���̵� : ");
			id = Scanner.getString();
			if(SystemController.memberDao.checkID2(id))
				System.out.println(" �� �������� �ʴ� ID�Դϴ�! ");
			else break;
		} while(true);

		String[] title = {"��й�ȣ", "�̸�", "����", "��ȭ��ȣ"};
		for(int i = 0; i <SystemController.memberDao.getMemberTitleById(id).size(); i++) {
			//			System.out.print((i+1)+")"+SystemController.memberDao.getMemberTitleById(id).get(i)+" ");
			System.out.print((i+1)+")"+title[i]+"  ");
		}
		System.out.println();
		System.out.print(" >> ������ ���� ���� : ");
		int selectNum = Scanner.getInt();

		String content;
		System.out.print(" >> ������ ���� �Է� : ");
		if(selectNum == 1)
			content = Encryption.Encrypting(Scanner.getString());
		else
			content = Scanner.getString();

		if(SystemController.memberDao.updateTitleById(id, 
				SystemController.memberDao.getMemberTitleById(id).get(selectNum-1), content)) {
			System.out.println(SystemController.memberDao.searchID(id));
		}
		else {
			System.out.println(" �� ����! �ٽ� �õ��ϼ���");
		}
	}
	public static void doMemberAdminDelete() { //ȸ�� ����
		System.out.println("*********************************");
		System.out.println("* \t       ȸ��, ������ ����\t\t*");
		System.out.println("*********************************");

		String id;

		do {
			System.out.print(" >> ������ ��� ���̵� : ");
			id  = Scanner.getString();
			if(SystemController.memberDao.checkID2(id))
				System.out.println(" �� �������� �ʴ� ID�Դϴ�! ");
			else break;
		} while(true);

		if(SystemController.memberDao.deleteById(id)) {
			System.out.println(" �١� ���������� �����Ǿ����ϴ� �ڡ�");
		}
		else System.out.println(" �� �ٽ� �õ����ּ���");
	}
	public static void doPlaceInquiry() {
		System.out.println("*********************************");
		System.out.println(" \t  < ������ ��� >");

		for(StagePerformanceDTO tmp: SystemController.pDao.totalInquiryStagePerformance()) {
			System.out.println(" "+tmp);
			System.out.println("---------------------------------");
		}
		System.out.println(" \t  < ������ ��� >");
		for(StageExhibitionDTO tmp: SystemController.eDao.totalInquirStageExhibition()) {
			System.out.println(" "+tmp);
			System.out.println("---------------------------------");
		}
	}
	public static void doSPRegist() {	//������ ���
		System.out.println("*********************************");
		System.out.println("* \t       ������ ���\t\t*");
		System.out.println("*********************************");
		do {
			System.out.print(" >> ������ �̸� : ");
			SystemController.spDto.setPlace(Scanner.getString());
			if(SystemController.pDao.checkSPName(SystemController.spDto.getPlace()))
				System.out.println(" �� �ߺ��� �������Դϴ�! ");
			else break;
		} while(true);
		System.out.print(" >> R�� �¼��� : ");
		SystemController.spDto.setSeatOfR(Scanner.getInt());

		System.out.print(" >> S�� �¼��� : ");
		SystemController.spDto.setSeatOfS(Scanner.getInt());

		System.out.print(" >> A�� �¼��� : ");
		SystemController.spDto.setSeatOfA(Scanner.getInt());

		if(SystemController.pDao.StagePerformanceAdd(SystemController.spDto)) {
			System.out.println(" �١� ���������� ��ϵǾ����ϴ� �ڡ�");
		}
		else System.out.println(" �� �ٽ� �õ����ּ���");
	}
	public static void doSERegist() {	//������ ���
		System.out.println("*********************************");
		System.out.println("* \t       ������ ���\t\t*");
		System.out.println("*********************************");
		do {
			System.out.print(" >> ������ �̸� : ");
			SystemController.seDto.setPlace(Scanner.getString());
			if(SystemController.eDao.checkPlace(SystemController.seDto.getPlace()))
				System.out.println(" �� �ߺ��� �������Դϴ�! ");
			else break;
		} while(true);
		System.out.print(" >> �����¥ : ");
		SystemController.seDto.setClosure(Scanner.getString());


		if(SystemController.eDao.StageExhibitionAdd(SystemController.seDto)) {
			System.out.println(" �١� ���������� ��ϵǾ����ϴ� �ڡ�");
		}
		else System.out.println(" �� �ٽ� �õ����ּ���");

	}
	public static void doSPUpdate() {	//������ ����
		System.out.println("*********************************");
		System.out.println("* \t       ������ ����\t\t*");
		System.out.println("*********************************");
		do {
			System.out.print(" >> ������ �̸� : ");
			SystemController.spDto.setPlace(Scanner.getString());
			if(SystemController.pDao.checkSPName2(SystemController.spDto.getPlace()))
				System.out.println(" �� �������� �ʴ� �������Դϴ�! ");
			else break;
		} while(true);


		do {
			System.out.print(" >> ������ ������ �̸� : ");
			SystemController.spDto.setPlace(Scanner.getString());
			if(SystemController.pDao.checkSPName(SystemController.spDto.getPlace()))
				System.out.println(" �� �����ϴ� �������Դϴ�! ");
			else break;
		} while(true);

		SystemController.pDao.deleteStagePerformance(SystemController.spDto.getPlace());	//������ ����

		System.out.print(" >> R�� �¼��� : ");
		SystemController.spDto.setSeatOfR(Scanner.getInt());

		System.out.print(" >> S�� �¼��� : ");
		SystemController.spDto.setSeatOfS(Scanner.getInt());

		System.out.print(" >> A�� �¼��� : ");
		SystemController.spDto.setSeatOfA(Scanner.getInt());


		if(SystemController.pDao.StagePerformanceAdd(SystemController.spDto)) {
			System.out.println(" �١� ���������� �����Ǿ����ϴ� �ڡ�");
		}
		else System.out.println(" �� �ٽ� �õ����ּ���");


	}

	public static void doSEUpdate() {	//������ ����
		System.out.println("*********************************");
		System.out.println("* \t       ������ ����\t\t*");
		System.out.println("*********************************");
		do {
			System.out.print(" >> ������ �̸� : ");
			SystemController.seDto.setPlace(Scanner.getString());
			if(SystemController.eDao.checkPlace2(SystemController.seDto.getPlace()))
				System.out.println(" �� �������� �ʴ� �������Դϴ�! ");
			else break;
		} while(true);



		do {
			System.out.print(" >> ������ ������ �̸� : ");
			SystemController.seDto.setPlace(Scanner.getString());
			if(SystemController.eDao.checkPlace(SystemController.seDto.getPlace()))
				System.out.println(" �� �����ϴ� �������Դϴ�! ");
			else break;
		} while(true);
		SystemController.eDao.deleteStageExhibition(SystemController.seDto.getPlace()); //������ ����


		System.out.print(" >> �����¥ : ");
		SystemController.seDto.setClosure(Scanner.getString());


		if(SystemController.eDao.StageExhibitionAdd(SystemController.seDto)) {
			System.out.println(" �١� ���������� �����Ǿ����ϴ� �ڡ�");
		}
		else System.out.println(" �� �ٽ� �õ����ּ���");

	}

	public static void doSPDelete() {	//������ ����
		System.out.println("*********************************");
		System.out.println("* \t       ������ ����\t\t*");
		System.out.println("*********************************");
		do {
			System.out.print(" >> ������ ������ �̸� : ");
			SystemController.spDto.setPlace(Scanner.getString());
			if(SystemController.pDao.checkSPName2(SystemController.spDto.getPlace()))
				System.out.println(" �� �������� �ʴ� �������Դϴ�! ");
			else break;
		} while(true);

		if(SystemController.pDao.deleteStagePerformance(SystemController.spDto.getPlace())) {			//������ ����
			System.out.println(" �١� ���������� �����Ǿ����ϴ� �ڡ�");
		}
		else System.out.println(" �� �ٽ� �õ����ּ���");

	}

	public static void doSEDelete() {	//������ ����
		System.out.println("*********************************");
		System.out.println("* \t       ������ ����\t\t*");
		System.out.println("*********************************");
		do {
			System.out.print(" >> ������ ������ �̸� : ");
			SystemController.seDto.setPlace(Scanner.getString());
			if(SystemController.eDao.checkPlace2(SystemController.seDto.getPlace()))
				System.out.println(" �� �������� �ʴ� �������Դϴ�! ");
			else break;
		} while(true);
		if(SystemController.eDao.deleteStageExhibition(SystemController.seDto.getPlace())) { //������ ����
			System.out.println(" �١� ���������� �����Ǿ����ϴ� �ڡ�");
		}
		else System.out.println(" �� �ٽ� �õ����ּ���");

	}

	//��ϵ� ���� ���� 
	private static void doOEDelete() {
		doOpenExhibitionInquiry();
		System.out.println(" >> ������  ����ȸ  ��ȣ�� �Է����ּ���");
		int eno = Scanner.getInt();
		if(SystemController.eDao.deleteOpenExhibition(eno))
			System.out.println("�� "+eno+" �� ����ȸ�� ������ �Ϸ� �Ǿ����ϴ� ��");
		else
			System.out.println(" �� �߸� �Է��ϼ̽��ϴ�!");
	}
	//��ϵ� ���� ����
	private static void doOPDelete() {
		doOpenPlaceInquiry();
		System.out.println(" >> ������  ���� ��ȣ�� �Է����ּ���");
		int pno = Scanner.getInt();
		if(SystemController.pDao.deleteOpenPerformance(pno))
			System.out.println("�� "+pno+" �� ������ ������ �Ϸ� �Ǿ����ϴ� ��");
		else
			System.out.println(" �� �߸� �Է��ϼ̽��ϴ�!");
	}
	//��ϵ� ������ �Խ� (OE = OpenExhibition)
	private static void doOEPublish() {
		doOpenExhibitionInquiry();
		System.out.print(" ���������� ��ȣ��  �Է� ���ּ��� # ");
		int eno = Scanner.getInt();
		if(SystemController.eDao.openExhibitionPublish(eno))
			System.out.println("�� "+eno+" �� ����ȸ�� ���ð� �Ϸ� �Ǿ����ϴ� ��");
		else
			System.out.println(" �� �߸� �Է��ϼ̽��ϴ�!");
	}
	//��ϵ� ���� ���� (OP = OpenPerformance)
	private static void doOPPublish() {
		doOpenPlaceInquiry();
		System.out.print(" ���������� ��ȣ��  �Է� ���ּ��� # ");
		int pno = Scanner.getInt();
		if(SystemController.pDao.openPerformPublish(pno))
			System.out.println("�� "+pno+" �� ������ ���ð� �Ϸ� �Ǿ����ϴ� ��");
		else
			System.out.println(" �� �߸� �Է��ϼ̽��ϴ�!");
	}

	// ��ϵ� ���� ��ϵ�
	public static void doOpenPlaceInquiry() {
		System.out.println("*********************************");
		System.out.println(" \t  < ���� ��� >");

		for (OpenPerformanceDTO tmp : SystemController.pDao.totalInquiryOpenPerformance()) {
			if (tmp.getOpened() == 1)
				System.out.println("------------���� O ����-------------");
			else
				System.out.println("------------���� X ����------------");
			System.out.println(" " + tmp);
			System.out.println("---------------------------------");
		}
	}

	// ��ϵ� ���� ��ϵ�
	public static void doOpenExhibitionInquiry() {
		System.out.println(" \t  < ����ȸ ��� >");
		for (OpenExhibitionDTO tmp : SystemController.eDao.totalInquiryOpenExhibition()) {
			if (tmp.getOpened() == 1)
				System.out.println("------------���� O ����ȸ------------");
			else
				System.out.println("------------���� X ����ȸ-----------");
			System.out.println(" " + tmp);
			System.out.println("---------------------------------");
		}

	}
}
