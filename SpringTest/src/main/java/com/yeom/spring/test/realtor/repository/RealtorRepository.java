package com.yeom.spring.test.realtor.repository;

import org.apache.ibatis.annotations.Mapper;

import com.yeom.spring.test.realtor.domain.Realtor;

@Mapper
public interface RealtorRepository {

	public int insertRealtor(Realtor realtor);
	
}
