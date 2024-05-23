package com.acorn.racket.facility.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.acorn.racket.facility.domain.FacilityDTO;

public interface FacilityServiceI {
	public ArrayList<FacilityDTO> getApiData() throws IOException;
	
	public int insert(ArrayList<FacilityDTO> list) throws Exception;
	
	public List<FacilityDTO> selectAll(int limit, int offset);
	
	public FacilityDTO selectDesc(String facID);
}
