package com.acorn.racket.community.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acorn.racket.community.controller.CommunityDetailDTO;

@Repository
public class CommunityRepository  implements CommunityRepositoryI {

	@Autowired
	SqlSession session;
	String ns ="com.acorn.boardMapper.";
	
	public List<CommunityDetailDTO> SelectAll(){
		
		List<CommunityDetailDTO> list = session.selectList(ns+"selectAll");
		
		return list;
	}
	
	
	
}
