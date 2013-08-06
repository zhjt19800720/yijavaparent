package com.yijava.entity;

public class WeatherInfo {
	
	private String region;
	private String city; 
	private String cityid;	
	private String temp; 
	//private String temp2;	
	private String weather;
	private String img1;
	private String img2;
	
	
	
	public WeatherInfo() {
		super();
	}
	public WeatherInfo(String region,String city, String cityid, String temp, String weather,
			String img1, String img2) {
		super();
		this.region=region;
		this.city = city;
		this.cityid = cityid;
		this.temp = temp;
		this.weather = weather;
		this.img1 = img1;
		this.img2 = img2;
	}
	
	public String getRegion() {
		if(region.equals("直辖市"))
		{
			region=this.city;
		}
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCityid() {
		return cityid;
	}
	public void setCityid(String cityid) {
		this.cityid = cityid;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	
	
}
