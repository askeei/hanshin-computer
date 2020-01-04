package view;

import controller.*;
import main.Scanner;
import DAO.MemberDAO;

public class UI {

	static String[] management = {"��ȸ", "���", "����", "����", "���"};

	public static void doInitMenu() {
		System.out.println("*********************************");
		System.out.println("* \t       ������ ����!\t    ���4��   *");
		System.out.println("*********************************");
		System.out.println("*  1) ����,����ȸ ��ȸ\t\t*");
		System.out.println("*  2) ȸ������\t\t\t*");
		System.out.println("*  3) �α���\t\t\t*");
		System.out.println("*  4) ����\t\t\t*");
		System.out.println("*********************************");
		System.out.print(" ���������� ��ȣ�� �������ּ��� # ");
	}

	public static void doRootMenu() {
		System.out.println("*********************************");
		System.out.println("*\t<< �ý��۰����ڿ� >>\t\t*");
		System.out.println("*********************************");
		System.out.println("*  1. ������(admin) ����\t\t*");
		System.out.println("*  2. ������,������ ����\t\t*");
		System.out.println("*  3. ��ϵ� ��� ����,���� ����\t\t*");
		System.out.println("*  4. �α׾ƿ�\t\t\t*");
		System.out.println("*********************************");
		System.out.print(" ���������� ��ȣ�� �������ּ��� # ");
	}
	public static void doRootMenu2() {
		System.out.println("*********************************");
		System.out.print("*  ");
		for(int i =0; i<management.length; i++) {
			System.out.print((i+1) + ")" + management[i] +"  ");
		}
		System.out.println("\t*");
		System.out.println("*********************************");
		System.out.print(" ���������� ��ȣ�� �������ּ��� # ");
	}
	
	public static void doAdminMenu(String id) {
		System.out.println("*********************************");
		System.out.println("* \t       ������ ����!\t    ���4��   *");
		System.out.println("* \t�ݰ����ϴ� ������ "+ new DAO.MemberDAO().searchID(id).getName()+"��!\t*");
		System.out.println("*********************************");
		System.out.println("*  1. �� ����,���� ���\t\t*");
		System.out.println("*  2. �� ����,���� ��ȸ\t\t*");
		System.out.println("*  3. �� ����,���� ��û\t\t*");
		System.out.println("*  4. �� ����,���� ����\t\t*");
		System.out.println("*  5. �� ����,���� ����\t\t*");
		System.out.println("*  6. �� ���� ���� ��Ȳ\t\t*");
		System.out.println("*  7. �α׾ƿ�\t\t\t*");
		System.out.println("*********************************");
		System.out.print(" ���������� ��ȣ�� �������ּ��� # ");
	}

	
	public static void doSelectPE() {
		System.out.println("*  1) ����   2) ����\t\t\t*");
		System.out.print(" ���������� ��ȣ�� �������ּ��� # ");
	}
	
	public static void doSelectPEStage() {
		System.out.println("*  1) ������   2) ������\t\t*");
		System.out.print(" ���������� ��ȣ�� �������ּ��� # ");
	}
	public static void doMemberMenu(String id) {
		System.out.println("*********************************");
		System.out.println("* \t       ������ ����!\t    ���4��   *");
		System.out.println("* \t�ݰ����ϴ� ȸ�� "+ new DAO.MemberDAO().searchID(id).getName()+"��!\t*");
		System.out.println("*********************************");
		System.out.println("*  1) ȸ������ ����\t\t\t*");
		System.out.println("*  2) Ƽ�� ����\t\t\t*");
		System.out.println("*  3) ���� ��ȸ\t\t\t*");
		System.out.println("*  4) ���� ���\t\t\t*");
		System.out.println("*  5) �α� �ƿ�\t\t\t*");
		System.out.println("*********************************");
		System.out.print(" ���������� ��ȣ�� �������ּ��� # ");
	}
	
}
