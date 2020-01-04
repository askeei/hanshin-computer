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
			if(selectNum.compareTo("7") == 0) return;   //로그아웃

			switch(selectNum) {
			case "1":   //새 공연,전시 등록
				view.UI.doSelectPE();
				String selectNum2= Scanner.getString();
				if(selectNum2.compareTo("1") == 0)
					doPRegist(id);
				else if(selectNum2.compareTo("2") == 0)
					doERegist(id);
				else
					System.out.println(" ※ 잘못 입력하셨습니다!");
				break;
			case "2":
				doMyPEInquiry(id);   //내 공연,전시 조회
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
				System.out.println(" ※ 잘못 입력하셨습니다!");
			}
		}
	}

	public static void doPRegist(String id) { // 개시 안된 공연 등록(P:Performance)
		System.out.println("*********************************");
		System.out.println("* \t       공연 등록\t\t*");
		System.out.println("*********************************");
		do {
			System.out.print(" >> 공연 이름 : ");
			SystemController.pDto.setName(Scanner.getString());
			if(SystemController.pDao.checkName(SystemController.pDto.getName()))
				System.out.println(" ※ 중복된 공연입니다! ");
			else break;
		} while(true);

		for(int i = 0; i< performanceTypeTitle.length; i++) {
			System.out.print((i+1)+") " + performanceTypeTitle[i] + "  ");
			if(i == 2) System.out.println();
		}
		System.out.println();
		System.out.print(" >> 타입 : ");
		SystemController.pDto.setType(performanceTypeTitle[Scanner.getInt()-1]);

		System.out.print(" >> 공연시간 : ");
		SystemController.pDto.setTime(Scanner.getInt());

		SystemController.pDto.setId(id);

		if(SystemController.pDao.performanceAdd(
				SystemController.pDto))
			System.out.println(" ☆★ 공연이 등록되었습니다 ★☆ ");
		else
			System.out.println(" ※ 다시 시도해주세요! ");
	}

	public static void doERegist(String id) { // 개시 안된 전시 등록(E:Exhibition)
		System.out.println("*********************************");
		System.out.println("* \t       전시 등록\t\t*");
		System.out.println("*********************************");
		do {
			System.out.print(" >> 전시 이름 : ");
			SystemController.eDto.setName(Scanner.getString());
			if(SystemController.eDao.checkName(SystemController.eDto.getName()))
				System.out.println(" ※ 중복된 전시입니다! ");
			else break;
		} while(true);


		for(int i = 0; i< exhibitionTypeTitle.length; i++) {
			System.out.print((i+1)+") " + exhibitionTypeTitle[i] + "  ");
			if(i == 2) System.out.println();
		}
		System.out.println();
		System.out.print(" >> 장르 : ");
		SystemController.eDto.setGenre(exhibitionTypeTitle[Scanner.getInt()-1]);

		System.out.print(" >> 주최자 : ");
		SystemController.eDto.setSponsor(Scanner.getString());


		SystemController.eDto.setId(id);

		if(SystemController.eDao.exhibitionAdd(
				SystemController.eDto))
			System.out.println(" ☆★ 전시가 등록되었습니다 ★☆ ");
		else
			System.out.println(" ※ 다시 시도해주세요! ");
	}

	public static void doMyPEInquiry(String id) {   //내 공연,전시 조회
		view.UI.doSelectPE();
		String selectPE = Scanner.getString();

		if(selectPE.compareTo("1") == 0) {
			if(SystemController.pDao.adminInquiryPerformanceById(id) == null) {
				System.out.println(" ※ 추가한 공연이 없습니다! ");
				return;
			}
			System.out.println("*********************************");
			System.out.println("* \t    내가 등록한 공연 조회\t\t*");
			System.out.println("*********************************");

			for(PerformanceDTO tmp: SystemController.pDao.adminInquiryPerformanceById(id))
				System.out.println(tmp);

			System.out.println("*\t   * Opened *\t\t*");
			for(OpenPerformanceDTO tmp: SystemController.pDao.adminInquiryOpenPerformanceById(id))
				System.out.println(tmp);
		}
		else if(selectPE.compareTo("2") == 0) {
			if(SystemController.eDao.adminInquiryExhibitionById(id) == null) {
				System.out.println(" ※ 추가한 전시가 없습니다! ");
				return;
			}
			System.out.println("*********************************");
			System.out.println("* \t    내가 등록한 전시 조회\t\t*");
			System.out.println("*********************************");

			for(ExhibitionDTO tmp: SystemController.eDao.adminInquiryExhibitionById(id))
				System.out.println(tmp);

			System.out.println("*\t   * Opened *\t\t*");
			for(OpenExhibitionDTO tmp: SystemController.eDao.adminInquiryOpenExhibitionById(id))
				System.out.println(tmp);

		}
		else
			System.out.println(" ※ 잘못 입력하셨습니다! ");

	}

	public static void doOpenPRegist(String id) { // 공연 신청(P:Performance)
		if(SystemController.pDao.adminInquiryPerformanceById(id) == null) {
			System.out.println(" ※ 추가한 공연이 없습니다! ");
			return;
		}

		System.out.println("*********************************");
		System.out.println("* \t       공연 신청\t\t*");
		System.out.println("* \t    내가 추가한 공연 목록\t\t*");
		System.out.println("*********************************");

		for(PerformanceDTO tmp: SystemController.pDao.adminInquiryPerformanceById(id))
			System.out.println(tmp);

		do {
			System.out.print(" >> 공연 이름 : ");
			SystemController.opDto.setName(Scanner.getString());
			if(!SystemController.pDao.checkName(SystemController.opDto.getName()))
				System.out.println(" ※ 존재하지 않는 공연입니다! ");
			else break;
		} while(true);

		int stageIndex = 1;
		for(StagePerformanceDTO tmp:SystemController.pDao.totalInquiryStagePerformance())
			System.out.println(" "+(stageIndex++)+" "+tmp);
		System.out.println("*********************************");
		System.out.print(" >> 공연장 번호 : ");
		int stageSelectNum = Scanner.getInt();

		SystemController.opDto.setPlace(
				SystemController.pDao.totalInquiryStagePerformance()
				.elementAt(stageSelectNum-1).getPlace());

		System.out.print(" >> 시작날짜(00. 00. 00) : ");
		SystemController.opDto.setSdate(Scanner.getString());

		System.out.print(" >> 종료날짜(00. 00. 00) : ");
		SystemController.opDto.setEdate(Scanner.getString());

		System.out.print(" >> 시작시간(00:00) : ");
		SystemController.opDto.setStime(Scanner.getString());

		System.out.print(" >> R석 가격 : ");
		SystemController.opDto.setPriceSeatR(Scanner.getInt());
		System.out.print(" >> S석 가격 : ");
		SystemController.opDto.setPriceSeatS(Scanner.getInt());
		System.out.print(" >> A석 가격 : ");
		SystemController.opDto.setPriceSeatA(Scanner.getInt());
		SystemController.opDto.setId(id);
		SystemController.opDto.setOpened(0);

		if(SystemController.pDao.openPerformanceAdd(
				SystemController.opDto))
			System.out.println(" ☆★ 공연이 신청되었습니다 ★☆ ");
		else
			System.out.println(" ※ 다시 시도해주세요! ");
	}

	public static void doOpenERegist(String id){ // 전시 신청(E:Exhibition)
		if(SystemController.eDao.adminInquiryExhibitionById(id) == null) {
			System.out.println(" ※ 추가한 전시가 없습니다! ");
			return;
		}
		System.out.println("*********************************");
		System.out.println("* \t       전시 신청\t\t*");
		System.out.println("* \t    내가 추가한 전시 목록\t\t*");
		System.out.println("*********************************");

		for(ExhibitionDTO tmp: SystemController.eDao.adminInquiryExhibitionById(id))
			System.out.println(tmp);
		do {
			System.out.print(" >> 전시 이름 : ");
			SystemController.oeDto.setName(Scanner.getString());
			if(!SystemController.eDao.checkName(SystemController.oeDto.getName()))
				System.out.println(" ※ 존재하지 않는 전시입니다! ");
			else break;
		} while(true);

		int stageIndex = 1;
		for(StageExhibitionDTO tmp:SystemController.eDao.totalInquirStageExhibition())
			System.out.println(" "+(stageIndex++)+" "+tmp);
		System.out.println("*********************************");
		System.out.print(" >> 전시장 번호 : ");
		int stageSelectNum = Scanner.getInt();

		SystemController.oeDto.setPlace(
				SystemController.eDao.totalInquirStageExhibition()
				.elementAt(stageSelectNum-1).getPlace());

		System.out.print(" >> 시작날짜(00. 00. 00) : ");
		SystemController.oeDto.setSdate(Scanner.getString());

		System.out.print(" >> 종료날짜(00. 00. 00) : ");
		SystemController.oeDto.setEdate(Scanner.getString());

		System.out.print(" >> 가격 : ");
		SystemController.oeDto.setPrice(Scanner.getInt());

		SystemController.oeDto.setId(id);
		SystemController.oeDto.setOpened(0);

		if(SystemController.eDao.openExhibitionAdd(
				SystemController.oeDto))
			System.out.println(" ☆★ 전시가 신청되었습니다 ★☆ ");
		else
			System.out.println(" ※ 다시 시도해주세요! ");
	}

	public static void doOpenPEUpdate(String id){
		view.UI.doSelectPE();
		String selectPE = Scanner.getString();

		if(selectPE.compareTo("1") == 0) {
			if(SystemController.pDao.adminInquiryPerformanceById(id) == null) {
				System.out.println(" ※ 추가한 공연이 없습니다! ");
				return;
			}
			System.out.println("*********************************");
			System.out.println("* \t       공연 변경\t\t*");
			System.out.println("* \t    내가 추가한 공연 목록\t\t*");
			System.out.println("*********************************");

			for(OpenPerformanceDTO tmp: SystemController.pDao.adminInquiryOpenPerformanceById(id))
				System.out.println(tmp);
			do {
				System.out.print(" >> 공연 번호 : ");
				SystemController.opDto.setPno(Scanner.getInt());
				if(!SystemController.pDao.checkNum(SystemController.opDto.getPno()))
					System.out.println(" ※ 존재하지 않는 공연입니다! ");
				else break;
			} while(true);

			System.out.println(" 1)시작날짜 2)종료날짜 3)시작시간\n"
					+ " 4)R석 가격 5)S석 가격 6)A석 가격");

			System.out.print(" >> 수정할 정보 선택 : ");
			int selectNum = Scanner.getInt();

			System.out.print(" >> 수정할 내용 입력 : ");
			String content = Scanner.getString();

			if(selectNum <4 &&
					SystemController.pDao.updateTitleById1(SystemController.opDto.getPno(), 
							SystemController.pDao.getMemberTitleById(id).get(selectNum+1), content)) 
				System.out.println(" ☆★ 수정되었습니다 ★☆ ");
			else if(selectNum >= 4 &&
					SystemController.pDao.updateTitleById2(SystemController.opDto.getPno(), 
							SystemController.pDao.getMemberTitleById(id).get(selectNum+1), content))
				System.out.println(" ☆★ 수정되었습니다 ★☆ ");
			else 
				System.out.println(" ※ 오류! 다시 시도하세요");
		}
		else if(selectPE.compareTo("2") == 0) {
			if(SystemController.eDao.adminInquiryExhibitionById(id) == null) {
				System.out.println(" ※ 추가한 전시가 없습니다! ");
				return;
			}
			System.out.println("*********************************");
			System.out.println("* \t       전시 변경\t\t*");
			System.out.println("* \t    내가 추가한 전시 목록\t\t*");
			System.out.println("*********************************");

			for(OpenExhibitionDTO tmp: SystemController.eDao.adminInquiryOpenExhibitionById(id))
				System.out.println(tmp);

			do {
				System.out.print(" >> 전시 번호 : ");
				SystemController.oeDto.setEno(Scanner.getInt());
				if(!SystemController.eDao.checkoeNum(SystemController.oeDto.getEno()))
					System.out.println(" ※ 존재하지 않는 전시입니다! ");
				else break;
			} while(true);

			System.out.println(" 1)시작날짜 2)종료날짜 3)가격");

			System.out.print(" >> 수정할 정보 선택 : ");
			int selectNum = Scanner.getInt();

			System.out.print(" >> 수정할 내용 입력 : ");
			String content = Scanner.getString();

			if(selectNum <3 &&
					SystemController.eDao.updateTitleById1(SystemController.oeDto.getEno(), 
							SystemController.eDao.getMemberTitleById(id).get(selectNum+1), content)) 
				System.out.println(" ☆★ 수정되었습니다 ★☆ ");
			else if(selectNum == 3 &&
					SystemController.eDao.updateTitleById2(SystemController.oeDto.getEno(), 
							SystemController.eDao.getMemberTitleById(id).get(selectNum+1), content))
				System.out.println(" ☆★ 수정되었습니다 ★☆ ");
			else 
				System.out.println(" ※ 오류! 다시 시도하세요");
		}
	}
	public static void doOpenPEDelete(String id){
		view.UI.doSelectPE();
		String selectPE = Scanner.getString();

		if(selectPE.compareTo("1") == 0) {
			if(SystemController.pDao.adminInquiryPerformanceById(id) == null) {
				System.out.println(" ※ 추가한 공연이 없습니다! ");
				return;
			}
			System.out.println("*********************************");
			System.out.println("* \t       공연 삭제\t\t*");
			System.out.println("* \t    내가 추가한 공연 목록\t\t*");
			System.out.println("*********************************");
			for(OpenPerformanceDTO tmp: SystemController.pDao.adminInquiryOpenPerformanceById(id))
				System.out.println(tmp);
			do {
				System.out.print(" >> 공연 번호 : ");
				SystemController.opDto.setPno(Scanner.getInt());
				if(!SystemController.pDao.checkNum(SystemController.opDto.getPno()))
					System.out.println(" ※ 존재하지 않는 공연입니다! ");
				else break;
			} while(true);

			if(SystemController.tDao.searchByPno(SystemController.opDto.getPno()))
				System.out.println(" ※ 공연 티켓이 존재합니다!");
			else if(SystemController.pDao.deleteOpenPerformance(SystemController.opDto.getPno()))
				System.out.println(" ☆★ 삭제되었습니다 ★☆ ");
			else 
				System.out.println(" ※ 오류! 다시 시도하세요");
		}
		else if(selectPE.compareTo("2") == 0) {
			if(SystemController.eDao.adminInquiryExhibitionById(id) == null) {
				System.out.println(" ※ 추가한 전시가 없습니다! ");
				return;
			}
			System.out.println("*********************************");
			System.out.println("* \t       전시 삭제\t\t*");
			System.out.println("* \t    내가 추가한 전시 목록\t\t*");
			System.out.println("*********************************");

			for(OpenExhibitionDTO tmp: SystemController.eDao.adminInquiryOpenExhibitionById(id))
				System.out.println(tmp);

			do {
				System.out.print(" >> 전시 번호 : ");
				SystemController.oeDto.setEno(Scanner.getInt());
				if(!SystemController.eDao.checkoeNum(SystemController.oeDto.getEno()))
					System.out.println(" ※ 존재하지 않는 전시입니다! ");
				else break;
			} while(true);

			if(SystemController.eDao.deleteOpenExhibition(SystemController.oeDto.getEno()))
				System.out.println(" ☆★ 삭제되었습니다 ★☆ ");
			else 
				System.out.println(" ※ 오류! 다시 시도하세요");
		}
	}
}