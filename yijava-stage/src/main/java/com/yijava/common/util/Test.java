package com.yijava.common.util;

import com.yijava.entity.WeatherInfo;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getWeatherInfoByCityName("邯郸"));
	}
	
	public static WeatherInfo getWeatherInfoByCityName(String city)
	{
		String weatherInfoStr=WeatherReport.getWeather(city);
		String[] array=weatherInfoStr.split("#");
		
		WeatherInfo weatherInfo=new WeatherInfo();
		weatherInfo.setCity(array[1]);
		weatherInfo.setCityid(array[2]);
		weatherInfo.setTemp(array[5]);
		weatherInfo.setWeather(array[6]);
		weatherInfo.setImg1(array[8]);
		weatherInfo.setImg2(array[9]);	
		
		return weatherInfo;		
	}

}
