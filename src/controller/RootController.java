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

	public static void rootInit(){		//시스템관리자용 초기화면
		int selectNum;
		int selectNum2;

		while(true) {

			view.UI.doRootMenu();
			selectNum = Scanner.getInt();
			if(selectNum == 4) return;
			else if(selectNum == 3) {
				System.out.println("*  1)조회  2)개시 승인  3)삭제  4)취소  	*");
				System.out.print(" ▶▷▶▷▶ 번호를 선택해주세요 # ");
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
			case 1:	//조회
				doMemberAdminInquiry();
				break;
			case 2:	//등록
				doAdminRegist();
				break;
			case 3:	//수정
				doMemberAdminUpdate();
				break;
			case 4:	//삭제
				doMemberAdminDelete();
				break;
			case 5:	//취소
				break;
			default:
				System.out.println(" ※ 잘못 입력하셨습니다!");
				break;
			}
		}
		else if(selectNum == 2) {	//공연장, 전시장 관리
			switch(selectNum2) {
			case 1:	//조회
				doPlaceInquiry();
				break;
			case 2:	//등록
				view.UI.doSelectPEStage();
				selectNum3= Scanner.getString();
				if(selectNum3.compareTo("1") == 0)
					doSPRegist();
				else if(selectNum3.compareTo("2") == 0)
					doSERegist();
				else
					System.out.println(" ※ 잘못 입력하셨습니다!");
				break;
			case 3:	//수정
				view.UI.doSelectPEStage();
				selectNum3= Scanner.getString();
				if(selectNum3.compareTo("1") == 0)
					doSPUpdate();
				else if(selectNum3.compareTo("2") == 0)
					doSEUpdate();
				else
					System.out.println(" ※ 잘못 입력하셨습니다!");
				break;
			case 4:	//삭제
				view.UI.doSelectPEStage();
				selectNum3= Scanner.getString();
				if(selectNum3.compareTo("1") == 0)
					doSPDelete();
				else if(selectNum3.compareTo("2") == 0)
					doSEDelete();
				else
					System.out.println(" ※ 잘못 입력하셨습니다!");
				break;

			case 5:	//취소
				break;
			default:
				System.out.println(" ※ 잘못 입력하셨습니다!");
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
				//TODO : 확인해바야댐 등록이 되었는지 안되었는지 확인 불가능 그래서 확인해야댐!
				view.UI.doSelectPE();
				selectNum3= Scanner.getString();
				if(selectNum3.compareTo("1")==0)
					doOPPublish();
				else if(selectNum3.compareTo("2") == 0)
					doOEPublish();
				else
					System.out.println(" ※ 잘못 입력하셨습니다!");
				break;
			case 3:
				view.UI.doSelectPE();
				selectNum3= Scanner.getString();
				if(selectNum3.compareTo("1")==0)
					doOPDelete();
				else if(selectNum3.compareTo("2") == 0)
					doOEDelete();
				else
					System.out.println(" ※ 잘못 입력하셨습니다!");
				break;
			case 4:
				break;
			}
		}

	}
	public static void doMemberAdminInquiry() { //회원, 관리자 조회
		System.out.println("*********************************");
		System.out.println(" \t  < 회원 목록 >");

		for(MemberDTO tmp: SystemController.memberDao.searchType(0)) {
			System.out.println(" "+tmp);
		}
		System.out.println("---------------------------------");
		System.out.println(" \t  < 관리자 목록 >");
		for(MemberDTO tmp: SystemController.memberDao.searchType(1)) {
			System.out.println(" "+tmp);
		}
	}
	public static void doAdminRegist() {	//관리자 등록
		System.out.println("*********************************");
		System.out.println("* \t       관리자 등록\t\t*");
		System.out.println("*********************************");
		do {
			System.out.print(" >> 아이디 : ");
			SystemController.memberDto.setId(Scanner.getString());
			if(SystemController.memberDao.checkID(SystemController.memberDto.getId()))
				System.out.println(" ※ 중복된 ID입니다! ");
			else break;
		} while(true);

		String passwd;
		do {
			System.out.print(" >> 비밀번호 : ");
			SystemController.memberDto.setPw(Encryption.Encrypting(Scanner.getString()));
			System.out.print(" >> 비밀번호 확인 : ");
			passwd = Encryption.Encrypting(Scanner.getString());
		} while(SystemController.memberDao.checkPasswd(SystemController.memberDto, passwd));

		System.out.print(" >> 이름 : ");
		SystemController.memberDto.setName(Scanner.getString());

		System.out.print(" >> 성별 : ");
		SystemController.memberDto.setSex(Scanner.getString());

		System.out.print(" >> 전화번호 : ");
		SystemController.memberDto.setPhone(Scanner.getString());

		SystemController.memberDto.setType(1);
		if(SystemController.memberDao.memberRegist(SystemController.memberDto))
			System.out.println(" ☆★ 관리자가 등록되었습니다 ★☆ ");
		else
			System.out.println(" ※ 다시 가입해주세요! ");
	}
	public static void doMemberAdminUpdate() { //관리자 수정
		System.out.println("*********************************");
		System.out.println("* \t       회원, 관리자 수정\t\t*");
		System.out.println("*********************************");
		String id;
		do {
			System.out.print(" >> 수정할 멤버 아이디 : ");
			id = Scanner.getString();
			if(SystemController.memberDao.checkID2(id))
				System.out.println(" ※ 존재하지 않는 ID입니다! ");
			else break;
		} while(true);

		String[] title = {"비밀번호", "이름", "성별", "전화번호"};
		for(int i = 0; i <SystemController.memberDao.getMemberTitleById(id).size(); i++) {
			//			System.out.print((i+1)+")"+SystemController.memberDao.getMemberTitleById(id).get(i)+" ");
			System.out.print((i+1)+")"+title[i]+"  ");
		}
		System.out.println();
		System.out.print(" >> 수정할 정보 선택 : ");
		int selectNum = Scanner.getInt();

		String content;
		System.out.print(" >> 수정할 내용 입력 : ");
		if(selectNum == 1)
			content = Encryption.Encrypting(Scanner.getString());
		else
			content = Scanner.getString();

		if(SystemController.memberDao.updateTitleById(id, 
				SystemController.memberDao.getMemberTitleById(id).get(selectNum-1), content)) {
			System.out.println(SystemController.memberDao.searchID(id));
		}
		else {
			System.out.println(" ※ 오류! 다시 시도하세요");
		}
	}
	public static void doMemberAdminDelete() { //회원 삭제
		System.out.println("*********************************");
		System.out.println("* \t       회원, 관리자 삭제\t\t*");
		System.out.println("*********************************");

		String id;

		do {
			System.out.print(" >> 삭제할 멤버 아이디 : ");
			id  = Scanner.getString();
			if(SystemController.memberDao.checkID2(id))
				System.out.println(" ※ 존재하지 않는 ID입니다! ");
			else break;
		} while(true);

		if(SystemController.memberDao.deleteById(id)) {
			System.out.println(" ☆★ 성공적으로 삭제되었습니다 ★☆");
		}
		else System.out.println(" ※ 다시 시도해주세요");
	}
	public static void doPlaceInquiry() {
		System.out.println("*********************************");
		System.out.println(" \t  < 공연장 목록 >");

		for(StagePerformanceDTO tmp: SystemController.pDao.totalInquiryStagePerformance()) {
			System.out.println(" "+tmp);
			System.out.println("---------------------------------");
		}
		System.out.println(" \t  < 전시장 목록 >");
		for(StageExhibitionDTO tmp: SystemController.eDao.totalInquirStageExhibition()) {
			System.out.println(" "+tmp);
			System.out.println("---------------------------------");
		}
	}
	public static void doSPRegist() {	//공연장 등록
		System.out.println("*********************************");
		System.out.println("* \t       공연장 등록\t\t*");
		System.out.println("*********************************");
		do {
			System.out.print(" >> 공연장 이름 : ");
			SystemController.spDto.setPlace(Scanner.getString());
			if(SystemController.pDao.checkSPName(SystemController.spDto.getPlace()))
				System.out.println(" ※ 중복된 공연장입니다! ");
			else break;
		} while(true);
		System.out.print(" >> R석 좌석수 : ");
		SystemController.spDto.setSeatOfR(Scanner.getInt());

		System.out.print(" >> S석 좌석수 : ");
		SystemController.spDto.setSeatOfS(Scanner.getInt());

		System.out.print(" >> A석 좌석수 : ");
		SystemController.spDto.setSeatOfA(Scanner.getInt());

		if(SystemController.pDao.StagePerformanceAdd(SystemController.spDto)) {
			System.out.println(" ☆★ 성공적으로 등록되었습니다 ★☆");
		}
		else System.out.println(" ※ 다시 시도해주세요");
	}
	public static void doSERegist() {	//전시장 등록
		System.out.println("*********************************");
		System.out.println("* \t       전시장 등록\t\t*");
		System.out.println("*********************************");
		do {
			System.out.print(" >> 전시장 이름 : ");
			SystemController.seDto.setPlace(Scanner.getString());
			if(SystemController.eDao.checkPlace(SystemController.seDto.getPlace()))
				System.out.println(" ※ 중복된 전시장입니다! ");
			else break;
		} while(true);
		System.out.print(" >> 폐관날짜 : ");
		SystemController.seDto.setClosure(Scanner.getString());


		if(SystemController.eDao.StageExhibitionAdd(SystemController.seDto)) {
			System.out.println(" ☆★ 성공적으로 등록되었습니다 ★☆");
		}
		else System.out.println(" ※ 다시 시도해주세요");

	}
	public static void doSPUpdate() {	//공연장 수정
		System.out.println("*********************************");
		System.out.println("* \t       공연장 수정\t\t*");
		System.out.println("*********************************");
		do {
			System.out.print(" >> 공연장 이름 : ");
			SystemController.spDto.setPlace(Scanner.getString());
			if(SystemController.pDao.checkSPName2(SystemController.spDto.getPlace()))
				System.out.println(" ※ 존재하지 않는 공연장입니다! ");
			else break;
		} while(true);


		do {
			System.out.print(" >> 수정할 공연장 이름 : ");
			SystemController.spDto.setPlace(Scanner.getString());
			if(SystemController.pDao.checkSPName(SystemController.spDto.getPlace()))
				System.out.println(" ※ 존재하는 공연장입니다! ");
			else break;
		} while(true);

		SystemController.pDao.deleteStagePerformance(SystemController.spDto.getPlace());	//공연장 삭제

		System.out.print(" >> R석 좌석수 : ");
		SystemController.spDto.setSeatOfR(Scanner.getInt());

		System.out.print(" >> S석 좌석수 : ");
		SystemController.spDto.setSeatOfS(Scanner.getInt());

		System.out.print(" >> A석 좌석수 : ");
		SystemController.spDto.setSeatOfA(Scanner.getInt());


		if(SystemController.pDao.StagePerformanceAdd(SystemController.spDto)) {
			System.out.println(" ☆★ 성공적으로 수정되었습니다 ★☆");
		}
		else System.out.println(" ※ 다시 시도해주세요");


	}

	public static void doSEUpdate() {	//전시장 수정
		System.out.println("*********************************");
		System.out.println("* \t       전시장 수정\t\t*");
		System.out.println("*********************************");
		do {
			System.out.print(" >> 전시장 이름 : ");
			SystemController.seDto.setPlace(Scanner.getString());
			if(SystemController.eDao.checkPlace2(SystemController.seDto.getPlace()))
				System.out.println(" ※ 존재하지 않는 전시장입니다! ");
			else break;
		} while(true);



		do {
			System.out.print(" >> 수정할 전시장 이름 : ");
			SystemController.seDto.setPlace(Scanner.getString());
			if(SystemController.eDao.checkPlace(SystemController.seDto.getPlace()))
				System.out.println(" ※ 존재하는 전시장입니다! ");
			else break;
		} while(true);
		SystemController.eDao.deleteStageExhibition(SystemController.seDto.getPlace()); //전시장 삭제


		System.out.print(" >> 폐관날짜 : ");
		SystemController.seDto.setClosure(Scanner.getString());


		if(SystemController.eDao.StageExhibitionAdd(SystemController.seDto)) {
			System.out.println(" ☆★ 성공적으로 수정되었습니다 ★☆");
		}
		else System.out.println(" ※ 다시 시도해주세요");

	}

	public static void doSPDelete() {	//공연장 삭제
		System.out.println("*********************************");
		System.out.println("* \t       공연장 삭제\t\t*");
		System.out.println("*********************************");
		do {
			System.out.print(" >> 삭제할 공연장 이름 : ");
			SystemController.spDto.setPlace(Scanner.getString());
			if(SystemController.pDao.checkSPName2(SystemController.spDto.getPlace()))
				System.out.println(" ※ 존재하지 않는 공연장입니다! ");
			else break;
		} while(true);

		if(SystemController.pDao.deleteStagePerformance(SystemController.spDto.getPlace())) {			//공연장 삭제
			System.out.println(" ☆★ 성공적으로 삭제되었습니다 ★☆");
		}
		else System.out.println(" ※ 다시 시도해주세요");

	}

	public static void doSEDelete() {	//전시장 삭제
		System.out.println("*********************************");
		System.out.println("* \t       전시장 삭제\t\t*");
		System.out.println("*********************************");
		do {
			System.out.print(" >> 삭제할 전시장 이름 : ");
			SystemController.seDto.setPlace(Scanner.getString());
			if(SystemController.eDao.checkPlace2(SystemController.seDto.getPlace()))
				System.out.println(" ※ 존재하지 않는 전시장입니다! ");
			else break;
		} while(true);
		if(SystemController.eDao.deleteStageExhibition(SystemController.seDto.getPlace())) { //전시장 삭제
			System.out.println(" ☆★ 성공적으로 삭제되었습니다 ★☆");
		}
		else System.out.println(" ※ 다시 시도해주세요");

	}

	//등록된 전시 삭제 
	private static void doOEDelete() {
		doOpenExhibitionInquiry();
		System.out.println(" >> 삭제할  전시회  번호를 입력해주세요");
		int eno = Scanner.getInt();
		if(SystemController.eDao.deleteOpenExhibition(eno))
			System.out.println("※ "+eno+" 번 전시회가 삭제가 완료 되었습니다 ※");
		else
			System.out.println(" ※ 잘못 입력하셨습니다!");
	}
	//등록된 공연 삭제
	private static void doOPDelete() {
		doOpenPlaceInquiry();
		System.out.println(" >> 삭제할  공연 번호를 입력해주세요");
		int pno = Scanner.getInt();
		if(SystemController.pDao.deleteOpenPerformance(pno))
			System.out.println("※ "+pno+" 번 공연이 삭제가 완료 되었습니다 ※");
		else
			System.out.println(" ※ 잘못 입력하셨습니다!");
	}
	//등록된 전시장 게시 (OE = OpenExhibition)
	private static void doOEPublish() {
		doOpenExhibitionInquiry();
		System.out.print(" ▶▷▶▷▶ 번호를  입력 해주세요 # ");
		int eno = Scanner.getInt();
		if(SystemController.eDao.openExhibitionPublish(eno))
			System.out.println("※ "+eno+" 번 전시회가 개시가 완료 되었습니다 ※");
		else
			System.out.println(" ※ 잘못 입력하셨습니다!");
	}
	//등록된 공연 개시 (OP = OpenPerformance)
	private static void doOPPublish() {
		doOpenPlaceInquiry();
		System.out.print(" ▶▷▶▷▶ 번호을  입력 해주세요 # ");
		int pno = Scanner.getInt();
		if(SystemController.pDao.openPerformPublish(pno))
			System.out.println("※ "+pno+" 번 공연이 개시가 완료 되었습니다 ※");
		else
			System.out.println(" ※ 잘못 입력하셨습니다!");
	}

	// 등록된 공연 목록들
	public static void doOpenPlaceInquiry() {
		System.out.println("*********************************");
		System.out.println(" \t  < 공연 목록 >");

		for (OpenPerformanceDTO tmp : SystemController.pDao.totalInquiryOpenPerformance()) {
			if (tmp.getOpened() == 1)
				System.out.println("------------개시 O 공연-------------");
			else
				System.out.println("------------개시 X 공연------------");
			System.out.println(" " + tmp);
			System.out.println("---------------------------------");
		}
	}

	// 등록된 전시 목록들
	public static void doOpenExhibitionInquiry() {
		System.out.println(" \t  < 전시회 목록 >");
		for (OpenExhibitionDTO tmp : SystemController.eDao.totalInquiryOpenExhibition()) {
			if (tmp.getOpened() == 1)
				System.out.println("------------개시 O 전시회------------");
			else
				System.out.println("------------개시 X 전시회-----------");
			System.out.println(" " + tmp);
			System.out.println("---------------------------------");
		}

	}
}
