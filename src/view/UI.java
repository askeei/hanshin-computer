package view;

import controller.*;
import main.Scanner;
import DAO.MemberDAO;

public class UI {

	static String[] management = {"조회", "등록", "수정", "삭제", "취소"};

	public static void doInitMenu() {
		System.out.println("*********************************");
		System.out.println("* \t       예전에 내가!\t    고기4조   *");
		System.out.println("*********************************");
		System.out.println("*  1) 공연,전시회 조회\t\t*");
		System.out.println("*  2) 회원가입\t\t\t*");
		System.out.println("*  3) 로그인\t\t\t*");
		System.out.println("*  4) 종료\t\t\t*");
		System.out.println("*********************************");
		System.out.print(" ▶▷▶▷▶ 번호를 선택해주세요 # ");
	}

	public static void doRootMenu() {
		System.out.println("*********************************");
		System.out.println("*\t<< 시스템관리자용 >>\t\t*");
		System.out.println("*********************************");
		System.out.println("*  1. 관리자(admin) 관리\t\t*");
		System.out.println("*  2. 공연장,전시장 관리\t\t*");
		System.out.println("*  3. 등록된 모든 공연,전시 관리\t\t*");
		System.out.println("*  4. 로그아웃\t\t\t*");
		System.out.println("*********************************");
		System.out.print(" ▶▷▶▷▶ 번호를 선택해주세요 # ");
	}
	public static void doRootMenu2() {
		System.out.println("*********************************");
		System.out.print("*  ");
		for(int i =0; i<management.length; i++) {
			System.out.print((i+1) + ")" + management[i] +"  ");
		}
		System.out.println("\t*");
		System.out.println("*********************************");
		System.out.print(" ▶▷▶▷▶ 번호를 선택해주세요 # ");
	}
	
	public static void doAdminMenu(String id) {
		System.out.println("*********************************");
		System.out.println("* \t       예전에 내가!\t    고기4조   *");
		System.out.println("* \t반갑습니다 관리자 "+ new DAO.MemberDAO().searchID(id).getName()+"님!\t*");
		System.out.println("*********************************");
		System.out.println("*  1. 새 공연,전시 등록\t\t*");
		System.out.println("*  2. 내 공연,전시 조회\t\t*");
		System.out.println("*  3. 내 공연,전시 신청\t\t*");
		System.out.println("*  4. 내 공연,전시 수정\t\t*");
		System.out.println("*  5. 내 공연,전시 삭제\t\t*");
		System.out.println("*  6. 내 공연 예매 현황\t\t*");
		System.out.println("*  7. 로그아웃\t\t\t*");
		System.out.println("*********************************");
		System.out.print(" ▶▷▶▷▶ 번호를 선택해주세요 # ");
	}

	
	public static void doSelectPE() {
		System.out.println("*  1) 공연   2) 전시\t\t\t*");
		System.out.print(" ▶▷▶▷▶ 번호를 선택해주세요 # ");
	}
	
	public static void doSelectPEStage() {
		System.out.println("*  1) 공연장   2) 전시장\t\t*");
		System.out.print(" ▶▷▶▷▶ 번호를 선택해주세요 # ");
	}
	public static void doMemberMenu(String id) {
		System.out.println("*********************************");
		System.out.println("* \t       예전에 내가!\t    고기4조   *");
		System.out.println("* \t반갑습니다 회원 "+ new DAO.MemberDAO().searchID(id).getName()+"님!\t*");
		System.out.println("*********************************");
		System.out.println("*  1) 회원정보 수정\t\t\t*");
		System.out.println("*  2) 티켓 예매\t\t\t*");
		System.out.println("*  3) 예매 조회\t\t\t*");
		System.out.println("*  4) 예매 취소\t\t\t*");
		System.out.println("*  5) 로그 아웃\t\t\t*");
		System.out.println("*********************************");
		System.out.print(" ▶▷▶▷▶ 번호를 선택해주세요 # ");
	}
	
}
