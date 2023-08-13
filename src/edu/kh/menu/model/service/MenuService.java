package edu.kh.menu.model.service;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import edu.kh.menu.model.vo.Menu;

public class MenuService {
	
	private Scanner sc = new Scanner(System.in);
	
	private List<Menu> menu = new LinkedList<Menu>();
	
	public MenuService() {
		menu.add(new Menu("후라이드 치킨", "16000원", "한국산"));
		menu.add(new Menu("양념 치킨", "17000원", "한국산"));
		menu.add(new Menu("간장 치킨", "17000원", "한국산"));
		menu.add(new Menu("반반 치킨(선택 가능)", "17000원", "한국산"));
		menu.add(new Menu("치즈볼(4개)", "4000원", "한국산"));
		menu.add(new Menu("음료수", "3000원", "한국산"));
		
	}
	
	public void program() {
		
		int menuNum = 0;
		
		do {
			System.out.println("===== 메뉴리스트 =====\n");
			System.out.println("1. 메뉴 조회");
			System.out.println("2. 메뉴 등록");
			System.out.println("3. 메뉴 수정");
			System.out.println("4. 메뉴 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("\n메뉴를 선택하세요 : ");
			
			try {
				menuNum = sc.nextInt();
				System.out.println();
				
				switch(menuNum) {
				case 1 : showmenu(); break;
				case 2 : addmenu(); break;
				case 3 : fixmenu(); break;
				case 4 : deletemenu(); break;
				case 0 : System.out.print("프로그램 종료"); break;
				default : System.out.print("메뉴에 작성된 번호만 입력하세요");
				}		
			} catch(InputMismatchException e) {
				
				System.out.println("\nerror : 입력형식이 유효하지 않습니다");
				
				sc.nextLine();
				
				menuNum = -1;
				
			}
			
		} while(menuNum != 0);
			
	}
	
	public void showmenu() {
		
		System.out.println("===== 메뉴 =====");
		System.out.println();
		
		if(menu.isEmpty() ) {
			System.out.println("메뉴가 없습니다");
			
			return;
		}
		int index = 1;
		for(Menu m : menu) {
			System.out.print( (index++) + "번 : ");
			System.out.println(m);
		}
		System.out.println();
			
	}
	
	public String addmenu() {
		
		System.out.println("===== 메뉴 추가 ======");
		
		System.out.print("메뉴명 : ");
		String name = sc.next();
		
		System.out.print("가격 : ");
		String prise = sc.next();
		
		sc.nextLine();
		
		System.out.print("원산지 : ");
		String PlaceOfOrigin = sc.next();
		
		if(menu.add (new Menu(name, prise, PlaceOfOrigin) ) ) {
			
			return "성공";
		} else {
			return "실패";
		}
		
	}
	
	public String fixmenu() {
		System.out.println("===== 메뉴 수정 =====");
		int index = sc.nextInt();
		
		if(menu.isEmpty() ) {
			
			return "입력하신 메뉴가 없습니다";
			
		} else if(index < 0 ) {
			
			return "음수는 입력할 수 없습니다";
			
		} else if(index >= menu.size() ) {
			
			return "범위를 넘어선 값을 입력할 수 없습니다";
		} else {
			System.out.println("수정할 메뉴를 선택하세요");
			menu.set(index, null);
		}
		
	}
	
	public String deletemenu() {
		System.out.println("===== 메뉴 삭제 =====");
		
		System.out.print("번호 입력 : ");
		int index = sc.nextInt();
		
		if(menu.isEmpty() ) {
			
			return "입력하신 메뉴가 없습니다";
			
		} else if(index < 0 ) {
			
			return "음수는 입력할 수 없습니다";
			
		} else if(index >= menu.size() ) {
			
			return "범위를 넘어선 값을 입력할 수 없습니다";
		} else {
			
			System.out.print("정말 삭제하시겠습니까? (예/아니요) : ");
			char ch = sc.next().charAt(0);
			if(ch == '예') {
				Menu temp = menu.remove(index);
				return temp.getName() + "가 삭제되었습니다";
			} else {
				return "취소";
			}
		
	} 
		
	}
	
	
}
