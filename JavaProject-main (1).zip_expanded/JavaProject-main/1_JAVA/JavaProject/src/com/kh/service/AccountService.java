package com.kh.service;

import java.sql.Connection;
import com.kh.common.JDBCTemplate;
import com.kh.dao.AccountDao;
import com.kh.vo.Account;

public class AccountService {
	public int insertAccount(Account m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new AccountDao().insertAccount(conn,m);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int updateAccountPwd(Account m,String pwd) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new AccountDao().updateAccountPwd(conn,m,pwd);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int updateAccountNname(Account m,String nname) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new AccountDao().updateAccountNname(conn,m,nname);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int deleteAccount(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new AccountDao().deleteAccount(conn,userId);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public Account searchAccountById(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		Account m = new AccountDao().searchAccountById(conn,userId);
		JDBCTemplate.close(conn);
		return m;
	}
	
	public Account searchAccountByNname(String nname) {
		Connection conn = JDBCTemplate.getConnection();
		Account m = new AccountDao().searchAccountByNname(conn,nname);
		JDBCTemplate.close(conn);
		return m;
	}
	
	public Account searchAccountByUnum(int unum) {
		Connection conn = JDBCTemplate.getConnection();
		Account m = new AccountDao().searchAccountByUnum(conn,unum);
		JDBCTemplate.close(conn);
		return m;
	}
}
