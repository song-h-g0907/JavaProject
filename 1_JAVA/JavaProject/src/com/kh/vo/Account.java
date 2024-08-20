package com.kh.vo;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Serializable{
	private int unum;
	private String id;
	private String pwd;
	private String nname;
	@Override
	public String toString() {
		return "Account [id=" + id + ", pwd=" + pwd + ", nname=" + nname + ", unum=" + unum + "]";
	}
	public int getUnum() {
		return unum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNname() {
		return nname;
	}
	public void setNname(String nname) {
		this.nname = nname;
	}
	public Account() {
		super();
	}
	public Account(String id, String pwd, String nname,int unum) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.nname = nname;
		this.unum = unum;
	}
	@Override
	public int hashCode() {
		String str =this.id + this.nname + this.pwd + this.unum; 
		return Objects.hash(str);
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Account) {
			Account ac = (Account)obj;
			if(this.id.equals(ac.getId())&&this.nname.equals(ac.getNname())&&this.pwd.equals(ac.getPwd())&&this.unum==ac.getUnum()) {
				return true;
			}
		}
		return false;
	}
	
	
}
