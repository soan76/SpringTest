package com.yeom.spring.test.mvc.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yeom.spring.test.mvc.domain.Seller;

@Mapper
public interface SellerRepository {

	// 닉네임, 온도, 프로필 이미지 경로 전달 받고 한 행을 insert 하는 기능
	public int insertSeller(
			@Param("nickname") String nickname
			, @Param("temperature")double temperature
			, @Param("profileImage")String profileImage);
	
	public Seller selectLastSeller();
	
	public Seller selectSeller(@Param("id")int id);
	
}
