package com.acorn.racket.facility.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acorn.racket.facility.domain.FacilityDTO;
import com.acorn.racket.facility.service.FacilityService;


public class FacilityController {
	@Autowired
	FacilityService service;
	
	//api db에 저장
	@RequestMapping("/insert")
	public void insertAPI( ) {	
		System.out.println("실행");
		try {
			ArrayList<FacilityDTO> list = service.getApiData();
			int rows = service.insert(list);
			System.out.println("들어간 레코드 수 : "+rows);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
 	//시설 전체 목록 불러오기
   @RequestMapping("/facilityList2")
 	public void selectAll(Model model) {
 	 
 	}
	
   
    @ResponseBody
	@RequestMapping("/facilityListData")	 
	public List<FacilityDTO> selectAll( int limit, int offset){		 
		System.out.println( "limit = "+limit +  ", offset = "  + offset);
		return service.selectAll(limit, offset);
	}
	
	//시설 상세보기
	@RequestMapping(value = "/facility/{facID}", method = RequestMethod.GET)
	public String selectAll(Model model, @PathVariable String facID) {
		FacilityDTO facility = service.selectDesc(facID);
		model.addAttribute("facility", facility);
		return "facDesc";
	}
}
