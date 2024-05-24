package com.acorn.racket.community.repository;



import java.util.List;


import org.springframework.stereotype.Repository;

import com.acorn.racket.community.controller.CommunityDetailDTO;


public interface CommunityRepositoryI {

	List<CommunityDetailDTO> SelectAll();
}
