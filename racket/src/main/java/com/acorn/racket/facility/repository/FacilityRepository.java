package com.acorn.racket.facility.repository;

import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acorn.racket.facility.domain.FacilityDTO;

@Repository
public class FacilityRepository  implements FacilityRepositoryI{
	@Autowired
	DataSource ds;
	@Autowired
    private SqlSession session;
    private static String namespace = "test.facMapper.";

    //api db저장
	@Override
	public int insert(List<FacilityDTO> facDto) throws Exception {
		return session.insert(namespace+"insert", facDto);
	}

	//시설 전체 목록 불러오기
	@Override
	public List<FacilityDTO> selectAll(int offset, int limit) {
		return session.selectList(namespace+"selectAll",  new HashMap<String, Object>() {{
	        put("limit", limit);
	        put("offset", offset);
	    }});
	}

	//시설 상세보기
	@Override
	public FacilityDTO selectDesc(String facID) {
		return session.selectOne(namespace+"selectDesc", facID);
	}

}
