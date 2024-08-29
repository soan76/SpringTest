package com.yeom.spring.test.weather.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeom.spring.test.weather.domain.Weather;
import com.yeom.spring.test.weather.repository.WeatherRepository;

@Service
public class WeatherService {

	@Autowired
	private WeatherRepository weatherRepository;
	
	public List<Weather> getWeatherHistory() {
		
		List<Weather> weatherhistory = weatherRepository.selectWeatherHistory();
		
		return weatherhistory;
	}
	
	public int addWeather(
			LocalDate date
			, String weather
			, double temperatures
			, double precipitation
			, String microDust
			, double windSpeed) {
		
		int count = weatherRepository.insertWeather(date, weather, temperatures, precipitation, microDust, windSpeed);
		return count;
	}
	
}
