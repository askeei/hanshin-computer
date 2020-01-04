package controller;

import DTO.*;

import java.io.IOException;

import DAO.*;
import main.Scanner;;

public class SystemController {

	public static MemberDTO memberDto = new MemberDTO();
	public static MemberDAO memberDao = new MemberDAO();
	
	public static PerformanceDTO pDto = new PerformanceDTO();
	public static ExhibitionDTO eDto = new ExhibitionDTO();
	
	public static StagePerformanceDTO spDto = new StagePerformanceDTO();
	public static StageExhibitionDTO seDto = new StageExhibitionDTO();
	
	public static OpenPerformanceDTO opDto = new OpenPerformanceDTO();
	public static OpenExhibitionDTO oeDto = new OpenExhibitionDTO();
	
	public static PerformanceDAO pDao = new PerformanceDAO();
	public static ExhibitionDAO eDao = new ExhibitionDAO();
	
	public static TicketDAO tDao = new TicketDAO();
	
	static String selectMenu = null;

	public static void init() {	//���α׷� �ʱ�ȭ��
		while(true) {
			view.UI.doInitMenu();

			switch(selectMenu = Scanner.getString()){
			case "1":
				doPerformanceExhibitionInquiry();
				break;
			case "2":
				doRegistMember(memberDto);
				break;
			case "3":
				doLogin();
				break;
			case "4":
				doExit();
			default:
				System.out.println(" * ����! �߸� �Է��ϼ̽��ϴ�");
			}
		}
	}
	
	private static void doPerformanceExhibitionInquiry() {
		System.out.println("*********************************");
		System.out.println(" \t  < ���� ��� >");

		for(OpenPerformanceDTO tmp: SystemController.pDao.totalInquiryOpenPerformance()) {
			System.out.println(tmp);
			System.out.println("---------------------------------");
		}

		System.out.println(" \t  < ����ȸ ��� >");
		for(OpenExhibitionDTO tmp: SystemController.eDao.totalInquiryOpenExhibition()) {
			System.out.println(tmp);
			System.out.println("---------------------------------");
		}
		
	}

	static void doRegistMember(MemberDTO member) {	//ȸ������
		System.out.println("*********************************");
		System.out.println("* \t       ȸ������\t\t*");
		System.out.println("*********************************");
		do {
			System.out.print(" >> ���̵� : ");
			member.setId(Scanner.getString());
			if(SystemController.memberDao.checkID(member.getId()))
				System.out.println(" �� �ߺ��� ID�Դϴ�!");
			else break;
		} while(true);

		String passwd;
		do {
			System.out.print(" >> ��й�ȣ : ");
			member.setPw(controller.Encryption.Encrypting(Scanner.getString()));
			System.out.print(" >> ��й�ȣ Ȯ�� : ");
			passwd = controller.Encryption.Encrypting(Scanner.getString());
		} while(SystemController.memberDao.checkPasswd(member, passwd));

		System.out.print(" >> �̸� : ");
		member.setName(Scanner.getString());

		System.out.print(" >> ���� : ");
		member.setSex(Scanner.getString());

		System.out.print(" >> ��ȭ��ȣ : ");
		member.setPhone(Scanner.getString());

		member.setType(0);
		if(SystemController.memberDao.memberRegist(member))
			System.out.println(" �١� ȸ�������� �ǽŰ��� ���ϵ帳�ϴ� �ڡ� ");
		else
			System.out.println(" �ٽ� �������ּ���! ");
	}

	static void doLogin() {	//�α���
		String id;
		String pw;
		int count = 0;

		System.out.println("*********************************");
		System.out.println("* \t       �α���\t\t\t*");
		System.out.println("*********************************");

		System.out.print(" >> ID : ");
		id = Scanner.getString();

		System.out.print(" >> PASSWORD : ");
		pw = Encryption.Encrypting((Scanner.getString()));

		switch(memberDao.login(id, pw)) {
		case -1:
			System.out.println(" �� ���̵� ��й�ȣ�� �ٸ��ϴ�! ");
			break;
		case 2:
			RootController.rootInit();
			break;
		case 1:
			AdminController.adminInit(id);
			break;
		case 0:
			while(true) {
				view.UI.doMemberMenu(id);
				MemberController memberController = new MemberController();
				if(memberController.firstQuestion(id) ==5) 
					break;
			}
		default:
			break;
		}
	}
	static void doExit() {
		System.out.println(" �������������α׷��� �����մϴ�");
		System.exit(0);
	}
}
