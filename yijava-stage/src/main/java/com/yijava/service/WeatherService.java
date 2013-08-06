package com.yijava.service;

import org.springframework.stereotype.Service;

import com.yijava.common.util.WeatherReport;
import com.yijava.entity.WeatherInfo;

@Service
public class WeatherService {

	public WeatherInfo getWeatherInfoByCityName(String city)
	{
		String weatherInfoStr=WeatherReport.getWeather(city);
		String[] array=weatherInfoStr.split("#");
		
		WeatherInfo weatherInfo=new WeatherInfo();
		weatherInfo.setRegion(array[0]);
		weatherInfo.setCity(array[1]);
		weatherInfo.setCityid(array[2]);
		weatherInfo.setTemp(array[5]);
		weatherInfo.setWeather(array[6]);
		weatherInfo.setImg1(array[8]);
		weatherInfo.setImg2(array[9]);	
		
		return weatherInfo;		
	}
}
