package com.example.Sniperproject.Servicejdbc;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.Sniperproject.Pojojdbc.Pojojdbc;

@Service
public class Servicejdbc {
	@Autowired
	JdbcTemplate js;
	
//postmapping	
	public int insert(Pojojdbc e) {
		int id=e.getId();
		String name=e.getName();
		String sql="insert into sniper values(?,?)";
		int i=js.update(sql,id,name);
		if(i>0) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	//putmapping
	public int updateval(int id) {
		String sql="update sniper set name='killer' where id=?";
		int i=js.update(sql,id);
		if(i>0) {
			return 1;
		}
		else {
			return 0;
		}
	} 
	
	//deletemapping
	public int deleteval(int id) {
		String sql="delete from sniper where id=?";
		int i=js.update(sql,id);
		if(i>0) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	//getmapping
	public List<Object> getmap(String name){
		List<Object> l=new ArrayList<Object>();
		List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
		String sql="select * from sniper where name=?";
		data=js.queryForList(sql,name);
		for(Map<String,Object> listdata:data) {
			l.add(listdata);
		}
		return l;
	}
}
