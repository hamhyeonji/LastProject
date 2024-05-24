package com.acorn.racket.community.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommunityDetailDTO {
	
	int post_id;
	String board_name;
	String user_id;
	
	
}
