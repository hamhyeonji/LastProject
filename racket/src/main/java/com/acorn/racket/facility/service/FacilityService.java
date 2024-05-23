package com.acorn.racket.facility.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.acorn.racket.facility.domain.ApiExplorer;
import com.acorn.racket.facility.domain.FacilityDTO;
import com.acorn.racket.facility.repository.FacilityRepository;

public class FacilityService  implements FacilityServiceI {
	@Autowired
	ApiExplorer api;
	@Autowired
	FacilityRepository repository;
	
	//api 받아와서 json으로 가공 후 FacDTO타입으로 리스트 반환
	public ArrayList<FacilityDTO> getApiData() throws IOException{
		String result = api.getApiData();
		JSONObject rjson  = new JSONObject(result);
        JSONObject a = rjson.getJSONObject("ListPublicReservationSport");
        JSONArray items = a.getJSONArray("row");

        ArrayList<FacilityDTO> FacDTOList = new ArrayList<FacilityDTO>();
        for(int i=0; i <items.length(); i++){
            JSONObject itemJson =  items.getJSONObject(i);
            System.out.println( itemJson);
            FacilityDTO itemDto =  new FacilityDTO( itemJson);
            FacDTOList.add(itemDto);
        }
	
		return FacDTOList;
	}
	
	//api에서 받아온 데이터 db에 저장
	public int insert(ArrayList<FacilityDTO> list) throws Exception {
		return repository.insert(list);
	}
	
//	//시설 전체목록 불러오기
//	public List<FacDTO> selectAll(){
//		return repository.selectAll();
//	}
	
	public List<FacilityDTO> selectAll(int limit, int offset){
		return repository.selectAll(limit, offset);
	}
	
	//시설 상세보기
	public FacilityDTO selectDesc(String facID) {
		return repository.selectDesc(facID);
	}
}
