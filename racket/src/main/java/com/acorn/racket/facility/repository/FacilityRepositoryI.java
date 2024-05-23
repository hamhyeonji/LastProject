package com.acorn.racket.facility.repository;

import java.util.List;

import com.acorn.racket.facility.domain.FacilityDTO;


public interface FacilityRepositoryI {
public int insert(List<FacilityDTO> facDto) throws Exception;
	
	public List<FacilityDTO> selectAll(int offset, int limit);
	
	//public List<FacDTO> selectAll();
	
	public FacilityDTO selectDesc(String facID);
}
