package com.kh.controller;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.kh.vo.Account;
import com.kh.vo.BuyProduct;
import com.kh.vo.Product;

public class Controller {
	private Account user=null;
	private int pnum=0;
	private int lastUnum=0;
	private List<Account> ac = new ArrayList<>();
	private List<Product> pd = new ArrayList<>();
	private List<BuyProduct> ba = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);
	
	public Controller() {
		try (ObjectInputStream ois =new ObjectInputStream(new FileInputStream("account1.txt"));){
			while(true) {
				try {
					ac.add((Account)ois.readObject());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}catch(EOFException e) {
			
		} catch (FileNotFoundException e) {
			File f1 = new File("account1.txt");
			try {
				f1.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i=0; i<ac.size(); i++) {
			if(ac.get(i).getUnum()>lastUnum) {
				lastUnum = ac.get(i).getUnum();
			}
		}
		lastUnum++;
		try (ObjectInputStream ois =new ObjectInputStream(new FileInputStream("product1.txt"));){
			while(true) {
				try {
					pd.add((Product)ois.readObject());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}catch(EOFException e) {
			
		} catch (FileNotFoundException e) {
			File f1 = new File("product1.txt");
			try {
				f1.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i=0; i<pd.size(); i++) {
			if(pd.get(i).getPnum()>pnum) {
				pnum = pd.get(i).getPnum();
			}
		}
		pnum++;
		try (ObjectInputStream ois =new ObjectInputStream(new FileInputStream("product2.txt"));){
			while(true) {
				try {
					ba.add((BuyProduct)ois.readObject());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}catch(EOFException e) {
			
		} catch (FileNotFoundException e) {
			File f1 = new File("product2.txt");
			try {
				f1.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getPnum() {
		return pnum;
	}
	
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	
	public Account getUser() {
		return user;
	}
	
	public List<Account> clac() {
		return ac;
	}
	
	public List<Product> clpd() {
		return pd;
	}
	
	public List<BuyProduct> clba() {
		return ba;
	}
	
	public void addClac(Account a) {
		this.ac.add(a);
	}
	
	public boolean checkId(String id) {
		for (int i = 0 ; i <ac.size(); i++) {
			if(ac.get(i).getId().equals(id)) {
				System.out.println("중복된 아이디입니다. 다시 입력하세요");
				return false;
			}
		}	
		return true;
	}
	
	public boolean checkPwd(String pwd,String npwd) {
		if(pwd.equals(npwd)) {
			return true;
		}else {
			System.out.println("비밀번호가 일치하지 않습니다. 다시 입력하세요.");
			return false;
		}
		
	}
	
	public boolean checkPwd(String pwd) {
		if(pwd.equals(user.getPwd())){
			return true;
		}
		return false;
	}
	
	public boolean checkNname(String nname) {
		for (int i = 0 ; i <ac.size(); i++) {
			if(ac.get(i).getNname().equals(nname)) {
				System.out.println("중복된 닉네임입니다. 다시 입력하세요.");
				return false;
			}
		}	
		return true;	
	}
	
	public void insertac(String id,String pwd,String nname) {
		ac.add(new Account(id,pwd,nname,lastUnum++));
		System.out.println("회원가입이 정성적으로 되었습니다.");
	}
	
	public int checkac() {
		int count =0;
		while(true) {
			System.out.print("아이디 : ");
			String id = sc.nextLine();
			System.out.print("비밀번호 : ");
			String pwd = sc.nextLine();
			if(ac.isEmpty()) {
				count++;
				System.out.print("일치하는 계정이 없습니다. ");
				if(count==5) {
					System.out.println();
					System.out.println("5회 이상 틀렸습니다. 초기화면으로 돌아갑니다.");
					return 5;
				}
				System.out.println("다시 입력해주세요");
				System.out.println("현재 "+count+"회 틀렸습니다. 5회 이상 틀릴시 초기 화면으로 돌아갑니다.");
			}
			for (int i = 0 ; i < ac.size(); i++) {
				if((ac.get(i).getId().equals(id))&&ac.get(i).getPwd().equals(pwd)) {
					System.out.println("로그인에 성공하였습니다.");
					user = ac.get(i);
					return 0;
				}else if(ac.get(i).getId().equals(id)) {
					count++;
					System.out.print("비밀번호가 일치하지 않습니다. ");
					if(count==5) {
						System.out.println();
						System.out.println("5회 이상 틀렸습니다. 초기화면으로 돌아갑니다.");
						return 5;
					}
					System.out.println("다시 입력해주세요");
					System.out.println("현재 "+count+"회 틀렸습니다. 5회 이상 틀릴시 초기 화면으로 돌아갑니다.");
					break;
				}
				if(i==ac.size()-1) {
					count++;
					System.out.print("일치하는 계정이 없습니다. ");
					if(count==5) {
						System.out.println();
						System.out.println("5회 이상 틀렸습니다. 초기화면으로 돌아갑니다.");
						return 5;
					}
					System.out.println("다시 입력해주세요");
					System.out.println("현재 "+count+"회 틀렸습니다. 5회 이상 틀릴시 초기 화면으로 돌아갑니다.");
				}
			}
			
		}	
	}
	
	public void showBoard(List pl,int s) {
		System.out.println("---------------------------------------");
		if(s==0&&pl.isEmpty()) {
			System.out.println("기록이 없습니다.");
			System.out.println("---------------------------------------");
			return;
		}else if(s==1&&pl.isEmpty()) {
			System.out.println("게시물이 없습니다.");
			System.out.println("---------------------------------------");
			return;
		}
		if (pl.get(0) instanceof BuyProduct) {
			for(int i = 0 ; i <pl.size(); i++) {
				String acuser = "";
				System.out.println("제품번호 : "+((BuyProduct)pl.get(i)).getPnum());
				System.out.println("작성자명 : "+((BuyProduct)pl.get(i)).getRename());
				for(int j = 0; j <ac.size(); j++) {
					if(ac.get(j).getUnum()==((BuyProduct)pl.get(i)).getBuyAccount()) {
						acuser = ac.get(j).getNname();
					}
				}
				System.out.println(((BuyProduct)pl.get(i)).toString()+" / 구매자 : "+acuser);
				System.out.println("---------------------------------------");
			}
		}else {
			for(int i = 0 ; i <pl.size(); i++) {
				System.out.println("제품번호 : "+((Product)pl.get(i)).getPnum());
				System.out.println("작성자명 : "+((Product)pl.get(i)).getRename());
				System.out.println(((Product)pl.get(i)).toString());
				System.out.println("---------------------------------------");
			}
		}
		
	}
	
	public int wdcheck() {
		while(true) {
			System.out.print("정말 탈퇴하시겠습니까(y/n) : ");
			String ch = sc.nextLine();
			if(ch.length()!=1) {
				System.out.println("잘못된입력입니다.");
				continue;
			}
			if (ch.charAt(0)=='n') {
				System.out.println("'내정보'로 돌아갑니다");
				return 0;
			}else if(ch.charAt(0)=='y') {
				for(int i = 0 ; i <pd.size(); i++) {
					if(pd.get(i).getRenum()==user.getUnum()) {
						System.out.println("등록된 제품이 있어 탈퇴가 불가능합니다.");
						System.out.println("'내정보'로 돌아갑니다");
						return 0;
					}
				}
				int count =0;
				while(true) {
					System.out.print("비밀번호 확인 : ");
					String pw = sc.nextLine();
					if(user.getPwd().equals(pw)) {
						for (int i = 0; i <ac.size(); i++) {
							ac.remove(user);
						}
						user=null;
						System.out.println("정상적으로 탈퇴되었습니다.");
						System.out.println("초기화면으로 돌아갑니다.");
						return 1;
					}else {
						count++;
						System.out.print("비밀번호가 일치하지 않습니다. ");
						if(count==5) {
							System.out.println();
							System.out.println("5회 이상 틀렸습니다. '내 정보'로 돌아갑니다.");
							return 0;
						}
						System.out.println("다시 입력해주세요");
						System.out.println("현재 "+count+"회 틀렸습니다. 5회 이상 틀릴시 초기 화면으로 돌아갑니다.");
						continue;
					}
				}
			}else {
				System.out.println("잘못된입력입니다.");
			}
		}
	}

	public void myinfo() {
		System.out.println("아이디 : "+user.getId());
		System.out.println("닉네임 : "+user.getNname());
		
	}
	
	public void changePwd(String pwd) {
		user.setPwd(pwd);
		System.out.println("비밀번호가 변경되었습니다.");
	}
	
	public void changeNname(String nname) {
		user.setNname(nname);
		System.out.println("닉네임이 변경되었습니다.");
	}
	
	public int buy(int pnum) {
		for(int i = 0; i <pd.size(); i++) {
			if(pd.get(i).getPnum()==pnum && pd.get(i).getRenum()!=user.getUnum()) {
				ba.add(new BuyProduct(pd.get(i),user.getUnum()));
				pd.remove(i);
				return 0;
			}else if(pd.get(i).getPnum()==pnum && pd.get(i).getRenum()==user.getUnum()) {
				return 1;
			}
		}
		return 2;
	}
	
	public void reg() {
		System.out.print("등록할 제품명 : ");
		String pname = sc.nextLine();
		int price;
		while (true) {
			System.out.print("희망 가격 : ");
			try {
				price = sc.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
			}finally {
				sc.nextLine();
			}
		}
		System.out.print("제품 설명 : ");
		String exp = sc.nextLine();
		boolean nego;
		while(true) {
			System.out.print("네고 가능 여부(y/n) : ");
			String ch = sc.nextLine();
			if(ch.length()!=1) {
				System.out.println("잘못된입력입니다.");
				continue;
			}
			if(ch.charAt(0)=='y') {
				nego = true;
				break;
			}else if(ch.charAt(0)=='n'){
				nego = false;
				break;
			}else {
				System.out.println("잘못된입력입니다.");
				continue;
			}
		}
		pd.add(new Product(pnum++,user.getNname(),pname,price,exp,nego,user.getUnum()));
	}
	
	public List<Product> srnum(int pnum) {//번호로 찾기
		List<Product> pl = new ArrayList<>();
		for (int i = 0 ; i <pd.size(); i++) {
			if(pnum==pd.get(i).getPnum()) {
				pl.add(pd.get(i));
			}
		}
		return pl;
	}
	
	public List<Product> srname(String rename) {//작성자로 찾기
		List<Product> pl = new ArrayList<>();
		for (int i = 0 ; i <pd.size(); i++) {
			if(rename.equals(pd.get(i).getRename())) {
				pl.add(pd.get(i));
			}
		}
		return pl;
	}
	
	public List<Product> srpname(String pname) {//제품명로 찾기
		List<Product> pl = new ArrayList<>();
		for (int i = 0 ; i <pd.size(); i++) {
			if(pname.equals(pd.get(i).getPname())) {
				pl.add(pd.get(i));
			}
		}
		return pl;
	}
	
	public List<Product> myBoard() {
		List<Product> pl = new ArrayList<>();
		for (int i = 0 ; i <pd.size(); i++) {
			if(user.getUnum()==pd.get(i).getRenum()) {
				pl.add(pd.get(i));
			}
		}
		return pl;
	}
	
	public boolean rmProduct(int pnum) {
		for (int i = 0 ; i<pd.size(); i++) {
			if(pd.get(i).getPnum()==pnum&&pd.get(i).getRenum()==user.getUnum()) {
				pd.remove(i);
				return true;
			}	
		}
		return false;
	}
	
	public boolean moProduct(int pnum) {
		for (int i = 0 ; i<pd.size(); i++) {
			if(pd.get(i).getPnum()==pnum&&pd.get(i).getRenum()==user.getUnum()) {
				System.out.print("수정할 제품명 : ");
				String pname = sc.nextLine();
				pd.get(i).setPname(pname);
				int price;
				while (true) {
					System.out.print("수정할 가격 : ");
					try {
						price = sc.nextInt();
						break;
					}catch(InputMismatchException e) {
						System.out.println("잘못된 입력입니다.");
					}finally {
						sc.nextLine();
					}
				}
				pd.get(i).setPrice(price);
				System.out.print("수정할 제품 설명 : ");
				String exp = sc.nextLine();
				pd.get(i).setExp(exp);
				boolean nego;
				while(true) {
					System.out.print("수정할 네고 가능 여부(y/n) : ");
					String ch = sc.nextLine();
					if(ch.length()!=1) {
						System.out.println("잘못된입력입니다.");
						continue;
					}
					if(ch.charAt(0)=='y') {
						nego = true;
						break;
					}else if(ch.charAt(0)=='n'){
						nego = false;
						break;
					}else {
						System.out.println("잘못된입력입니다.");
						continue;
					}
				}
				pd.get(i).setNego(nego);
				return true;
			}	
		}
		return false;
	}
	
	public List<BuyProduct> buyList() {
		List<BuyProduct> bp = new ArrayList<>();
		for (int i = 0 ; i <ba.size(); i++) {
			if(ba.get(i).getBuyAccount()==user.getUnum()) {
				bp.add(ba.get(i));
			}
		}
		return bp;
	}
	
	public List<BuyProduct> cellList() {
		List<BuyProduct> bp = new ArrayList<>();
		for (int i = 0 ; i <ba.size(); i++) {
			if(ba.get(i).getRenum()==user.getUnum()) {
				bp.add(ba.get(i));
			}
		}
		return bp;
	}
}
