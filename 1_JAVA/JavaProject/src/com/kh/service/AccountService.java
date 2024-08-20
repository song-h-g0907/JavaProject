package com.kh.service;

import java.sql.Connection;
import java.util.List;

import com.kh.common.JDBCTemplate;
import com.kh.dao.MemberDao;
import com.kh.vo.Account;

public class AccountService {
	public int insertMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().insertMember(conn,m);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public List<Member> selectMemberList(){
		Connection conn = JDBCTemplate.getConnection();
		List<Member> list = new MemberDao().selectMemberList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}
	
	public int updateMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().updateMember(conn,m);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int deleteMember(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().deleteMember(conn,userId);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public Member searchMemberById(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = new MemberDao().searchMemberById(conn,userId);
		JDBCTemplate.close(conn);
		return m;
	}
	
	public List<Member> searchMemberByName(String kw) {
		Connection conn = JDBCTemplate.getConnection();
		List<Member> m = new MemberDao().searchMemberByName(conn,kw);
		JDBCTemplate.close(conn);
		return m;
	}
}
