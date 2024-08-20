package com.kh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.common.JDBCTemplate;
import com.kh.vo.Account;

//DAO(Data Access Object) : db에 직접적으로 접근해서 사용자의 요청에 맞는 sql문 실행 후 결과 반환(JDBC)
public class AccountDao {
	/**
	 * 
	 * @param Account m : 사용자가 입력한 값들이 담겨있는 Account객체
	 * @return : insert문 실행 후 처리된 행 수
	 */
	public int insertAccount(Connection conn,Account m) {
		
		int result = 0; //처리도니 결과를 받아줄 변수
		PreparedStatement pstmt = null; // 미완성 sql문을 통해서 객체생성 후 객체의 메소드를 이용해 완성가능
		String sql = "INSERT INTO Account VALUES(SEQ_USERNO.NEXTVAL, ?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getNname());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("형식에 맞지않는 정보입니다.");
//			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int updateAccountPwd(Connection conn, Account m,String pwd) {
		//update문 -> 처리된 행 수(int)
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		/*
		 * update Account
		 * set user_pwd = 'xxxx',email = 'xxxx',phone = 'xxxxxx',address = 'xxxxx'
		 * where user_id = 'xxxx'
		 */
		String sql = "UPDATE Account "
					 +"SET USER_PWD = ? "
					 +"WHERE USER_ID = ?";
		//1) JDBC Driver등록
		try {
			//3) Statement객체 생성 -> PreparedStatement
			//미완성 sql문을 전달(필요한 요소중 일부가 ?로 채워져있음
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pwd);
			pstmt.setString(2, m.getId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("형식에 맞지않는 정보입니다.");
//			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int updateAccountNname(Connection conn, Account m,String nname) {
		//update문 -> 처리된 행 수(int)
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		/*
		 * update Account
		 * set user_pwd = 'xxxx',email = 'xxxx',phone = 'xxxxxx',address = 'xxxxx'
		 * where user_id = 'xxxx'
		 */
		String sql = "UPDATE Account "
					 +"SET USER_NNAME = ? "
					 +"WHERE USER_ID = ?";
		//1) JDBC Driver등록
		try {
			//3) Statement객체 생성 -> PreparedStatement
			//미완성 sql문을 전달(필요한 요소중 일부가 ?로 채워져있음
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nname);
			pstmt.setString(2, m.getId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("형식에 맞지않는 정보입니다.");
//			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int deleteAccount(Connection conn, String userId) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "DELETE Account WHERE USER_ID = ?";
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
	
	public Account searchAccountById(Connection conn,String userId) {
		Account m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null; //select문 실행시 조회된 결과값들이 최초로 담기는 공간
		String sql = "SELECT * FROM Account WHERE USER_ID = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				m = new Account();
				m.setUnum(rset.getInt("USER_NO"));
				m.setId(rset.getString("USER_ID"));
				m.setPwd(rset.getString("USER_PWD"));
				m.setNname(rset.getString("USER_NNAME"));
			}
			//현재 참조하고있는 행에 대한 모든 컬럼에 데이터들을 한 Account객체에 담기	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}
	
	public Account searchAccountByUnum(Connection conn,int unum) {
		Account m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null; //select문 실행시 조회된 결과값들이 최초로 담기는 공간
		String sql = "SELECT * FROM Account WHERE USER_NO = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, unum);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				m = new Account();
				m.setUnum(rset.getInt("USER_NO"));
				m.setId(rset.getString("USER_ID"));
				m.setPwd(rset.getString("USER_PWD"));
				m.setNname(rset.getString("USER_NNAME"));
			}
			//현재 참조하고있는 행에 대한 모든 컬럼에 데이터들을 한 Account객체에 담기	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}
	public Account searchAccountByNname(Connection conn,String nname) {
		Account m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null; //select문 실행시 조회된 결과값들이 최초로 담기는 공간
		String sql = "SELECT * FROM Account WHERE USER_NNAME = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nname);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				m = new Account();
				m.setUnum(rset.getInt("USER_NO"));
				m.setId(rset.getString("USER_ID"));
				m.setPwd(rset.getString("USER_PWD"));
				m.setNname(rset.getString("USER_NNAME"));
			}
			//현재 참조하고있는 행에 대한 모든 컬럼에 데이터들을 한 Account객체에 담기	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}
}
