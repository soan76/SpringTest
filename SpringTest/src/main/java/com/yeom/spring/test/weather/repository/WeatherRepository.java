package com.yeom.spring.test.weather.repository;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yeom.spring.test.weather.domain.Weather;

@Mapper
public interface WeatherRepository {
	
	public List<Weather> selectWeatherHistory();
	
	public int insertWeather(
			@Param("date") LocalDate date
			, @Param("weather") String weather
			, @Param("temperatuers") double temperatuers
			, @Param("precipitation") double precipitation
			, @Param("micreDust") String microDust
			, @Param("windSpeed") double windSpeed);
	
}
