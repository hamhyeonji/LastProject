package com.acorn.racket.community.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.acorn.racket.community.service.CommunityService;


@Controller
public class CommunityController {

	@Autowired
	CommunityService service;
	
	
	@GetMapping("/boarddetail")
	public String writeview(Model model) {
		
		List<CommunityDetailDTO> list = service.detailview();
		System.out.println(list);
		model.addAttribute("post",list );
		return "CommunityDetail";
	}
}
