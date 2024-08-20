package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.vo.Member;

//DAO(Data Access Object) : db에 직접적으로 접근해서 사용자의 요청에 맞는 sql문 실행 후 결과 반환(JDBC)
public class MemberDao {
	/**
	 * 
	 * @param Member m : 사용자가 입력한 값들이 담겨있는 member객체
	 * @return : insert문 실행 후 처리된 행 수
	 */
	public int insertMember(Connection conn,Member m) {
		//insert문 => 처리된 행수(int) => 트랜잭션
		
		//필요한 변수 먼저 셋팅
		int result = 0; //처리도니 결과를 받아줄 변수
		//Statement stmt = null; //완성된 sql문 전달해서 곧바로 실행 후 결과를 받는 객체
		PreparedStatement pstmt = null; // 미완성 sql문을 통해서 객체생성 후 객체의 메소드를 이용해 완성가능
		//미완성 SQL문
		String sql = "INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL, ?,?,?,?,?,?,?,?,?,SYSDATE)";
//		String sql = "INSERT INTO MEMBER VALUES("
//				+ "SEQ_USERNO.NEXTVAL,"
//				+ "'"+m.getUserId()+"',"
//				+ "'"+m.getUserPwd()+"',"
//				+ "'"+m.getUserName()+"',"
//				+ "'"+m.getGender()+"',"
//				+ m.getAge()+","
//				+ "'"+m.getEmail()+"',"
//				+ "'"+m.getPhone()+"',"
//				+ "'"+m.getAddress()+"',"
//				+ "'"+m.getHobby()+"',"
//				+ "SYSDATE)";
		
		System.out.println("sql : "+sql);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());
			//4,5) sql로 전달하면서 실행 후 값 받아오기
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public ArrayList<Member> selectMemberList(Connection conn) {
		//select문(여러행 조회) -> ResultSet객체 -> ArrayList<Member>에 담기
		
		//필요한 변수들 세팅
		ArrayList<Member> list = new ArrayList<>(); // 비어있는상태
		
		Statement stmt = null;
		ResultSet rset = null; //select문 실행시 조회된 결과값들이 최초로 담기는 공간
		
		//실행할 sql
		String sql = "SELECT * FROM MEMBER";
		
		try {
			
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				Member m = new Member();
				m.setUserNo(rset.getInt("USER_NO"));
				m.setUserId(rset.getString("USER_ID"));
				m.setUserPwd(rset.getString("USER_PWD"));
				m.setUserName(rset.getString("USER_NAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getDate("ENROLL_DATE"));
				//현재 참조하고있는 행에 대한 모든 컬럼에 데이터들을 한 Member객체에 담기
				
				list.add(m);
			}
			
			//반복문이 끝난 시점
			//조회된 데이터가 없다면 list -> 비어있을 것이다.
			//조회된 데이터가 있다면 전부 list에 담겨있을 것이다.
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return list;
	}
	
	public int updateMember(Connection conn, Member m) {
		//update문 -> 처리된 행 수(int)
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		/*
		 * update member
		 * set user_pwd = 'xxxx',email = 'xxxx',phone = 'xxxxxx',address = 'xxxxx'
		 * where user_id = 'xxxx'
		 */
		String sql = "UPDATE MEMBER "
					 +"SET USER_PWD = ?,"
					 +"EMAIL = ?,"
					 +"PHONE = ?,"
					 +"ADDRESS = ?"
					 +"WHERE USER_ID = ?";
		//1) JDBC Driver등록
		try {
			//3) Statement객체 생성 -> PreparedStatement
			//미완성 sql문을 전달(필요한 요소중 일부가 ?로 채워져있음
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserPwd());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getUserId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	public int deleteMember(Connection conn, String userId) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "DELETE MEMBER WHERE USER_ID = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public Member searchMemberById(Connection conn,String userId) {
		//select문(여러행 조회) -> ResultSet객체 -> ArrayList<Member>에 담기
		
		//필요한 변수들 세팅
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null; //select문 실행시 조회된 결과값들이 최초로 담기는 공간
		
		//실행할 sql
		String sql = "SELECT * FROM MEMBER WHERE USER_ID = ?";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				m = new Member();
				m.setUserNo(rset.getInt("USER_NO"));
				m.setUserId(rset.getString("USER_ID"));
				m.setUserPwd(rset.getString("USER_PWD"));
				m.setUserName(rset.getString("USER_NAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getDate("ENROLL_DATE"));
			}
			//현재 참조하고있는 행에 대한 모든 컬럼에 데이터들을 한 Member객체에 담기
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}
	public ArrayList<Member> searchMemberByName(Connection conn,String kw) {
		//select문(여러행 조회) -> ResultSet객체 -> ArrayList<Member>에 담기
		
		//필요한 변수들 세팅
		PreparedStatement pstmt = null;
		ResultSet rset = null; //select문 실행시 조회된 결과값들이 최초로 담기는 공간
		ArrayList<Member> list = new ArrayList<>();
		//실행할 sql
		String sql = "SELECT * FROM MEMBER WHERE USER_NAME LIKE '%'||?||'%'";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kw);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Member m = new Member();
				m.setUserNo(rset.getInt("USER_NO"));
				m.setUserId(rset.getString("USER_ID"));
				m.setUserPwd(rset.getString("USER_PWD"));
				m.setUserName(rset.getString("USER_NAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getDate("ENROLL_DATE"));
				list.add(m);
			}
			//현재 참조하고있는 행에 대한 모든 컬럼에 데이터들을 한 Member객체에 담기
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
}
