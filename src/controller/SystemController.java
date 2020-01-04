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

	public static void init() {	//프로그램 초기화면
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
				System.out.println(" * 오류! 잘못 입력하셨습니다");
			}
		}
	}
	
	private static void doPerformanceExhibitionInquiry() {
		System.out.println("*********************************");
		System.out.println(" \t  < 공연 목록 >");

		for(OpenPerformanceDTO tmp: SystemController.pDao.totalInquiryOpenPerformance()) {
			System.out.println(tmp);
			System.out.println("---------------------------------");
		}

		System.out.println(" \t  < 전시회 목록 >");
		for(OpenExhibitionDTO tmp: SystemController.eDao.totalInquiryOpenExhibition()) {
			System.out.println(tmp);
			System.out.println("---------------------------------");
		}
		
	}

	static void doRegistMember(MemberDTO member) {	//회원가입
		System.out.println("*********************************");
		System.out.println("* \t       회원가입\t\t*");
		System.out.println("*********************************");
		do {
			System.out.print(" >> 아이디 : ");
			member.setId(Scanner.getString());
			if(SystemController.memberDao.checkID(member.getId()))
				System.out.println(" ※ 중복된 ID입니다!");
			else break;
		} while(true);

		String passwd;
		do {
			System.out.print(" >> 비밀번호 : ");
			member.setPw(controller.Encryption.Encrypting(Scanner.getString()));
			System.out.print(" >> 비밀번호 확인 : ");
			passwd = controller.Encryption.Encrypting(Scanner.getString());
		} while(SystemController.memberDao.checkPasswd(member, passwd));

		System.out.print(" >> 이름 : ");
		member.setName(Scanner.getString());

		System.out.print(" >> 성별 : ");
		member.setSex(Scanner.getString());

		System.out.print(" >> 전화번호 : ");
		member.setPhone(Scanner.getString());

		member.setType(0);
		if(SystemController.memberDao.memberRegist(member))
			System.out.println(" ☆★ 회원가입이 되신것을 축하드립니다 ★☆ ");
		else
			System.out.println(" 다시 가입해주세요! ");
	}

	static void doLogin() {	//로그인
		String id;
		String pw;
		int count = 0;

		System.out.println("*********************************");
		System.out.println("* \t       로그인\t\t\t*");
		System.out.println("*********************************");

		System.out.print(" >> ID : ");
		id = Scanner.getString();

		System.out.print(" >> PASSWORD : ");
		pw = Encryption.Encrypting((Scanner.getString()));

		switch(memberDao.login(id, pw)) {
		case -1:
			System.out.println(" ※ 아이디나 비밀번호가 다릅니다! ");
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
		System.out.println(" ▶▷▶▷▶프로그램을 종료합니다");
		System.exit(0);
	}
}
