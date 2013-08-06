package com.yijava.common.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WeatherReport {

	public static void main(String[] args)
	{
		System.out.println(getWeather("北京"));
	}
	
	private static String getSoapRequest(String city) {
		StringBuilder sb = new StringBuilder();
		/*通过输入的城市生成可供请求的xml文件*/
		sb
				.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>"
						+ "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
						+ "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" "
						+ "xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"
						+ "<soap:Body>    <getWeatherbyCityName xmlns=\"http://WebXml.com.cn/\">"
						+ "<theCityName>" + city
						+ "</theCityName>    </getWeatherbyCityName>"
						+ "</soap:Body></soap:Envelope>");
		return sb.toString();
	}
	private static InputStream getSoapInputStream(String city) throws Exception {
		try {
			String soap = getSoapRequest(city);//获取请求的xml
			if (soap == null) {
				return null;
			}
			/*获取天气预报的频道*/
			URL url = new URL(
					"http://www.webxml.com.cn/WebServices/WeatherWebService.asmx");
			/*创建连接对象*/
			URLConnection conn = url.openConnection();
			//连接时忽略文档缓存
			conn.setUseCaches(false);
			/*因为使用URL连接，所以下面两个设置为true*/
			conn.setDoInput(true);
			conn.setDoOutput(true);
			
			// 设置一般请求属性，请求的长度
			conn.setRequestProperty("Content-Length", Integer.toString(soap
					.length()));
			//请求的类型
			conn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
			//请求的协议
			conn.setRequestProperty("SOAPAction",
					"http://WebXml.com.cn/getWeatherbyCityName");
			//创建输出字节流
			OutputStream os = conn.getOutputStream();
			//把输出字节流转换为输出字符流
			OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");
			osw.write(soap);
			osw.flush();
			osw.close();
			//创建输入流，把输出流转换为输入流输出
			InputStream is = conn.getInputStream();
			return is;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getWeather(String city) {
		try {
			Document doc;
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputStream is = getSoapInputStream(city);//获取输入字节流
			doc = db.parse(is);//解析xml文件
			NodeList nl = doc.getElementsByTagName("string");
			StringBuffer sb = new StringBuffer();
			for (int count = 0; count < nl.getLength(); count++) {
				Node n = nl.item(count);
				if(n.getFirstChild().getNodeValue().equals("查询结果为空！")) {
					sb = new StringBuffer("#") ;
					break ;
				}
			sb.append(n.getFirstChild().getNodeValue() + "#");
			}
			is.close();
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
