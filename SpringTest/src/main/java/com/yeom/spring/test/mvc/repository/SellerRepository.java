package com.yeom.spring.test.mvc.repository;

import org.apache.ibatis.annotations.Mapper;

import com.yeom.spring.test.mvc.domain.Seller;

@Mapper
public interface SellerRepository {

	public Seller selectAddSeller();
	
}
