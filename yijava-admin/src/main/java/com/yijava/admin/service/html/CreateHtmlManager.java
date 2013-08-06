package com.yijava.admin.service.html;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class CreateHtmlManager {

	
	private String baseHtmlPath;
	
	private FreeMarkerConfigurer freemarkerConfigurer;
	
	
	
	public String getBaseHtmlPath() {
		return baseHtmlPath;
	}
	
	
	public void setBaseHtmlPath(String baseHtmlPath) {
		this.baseHtmlPath = baseHtmlPath;
	}

	public FreeMarkerConfigurer getFreemarkerConfigurer() {
		return freemarkerConfigurer;
	}

	public void setFreemarkerConfigurer(FreeMarkerConfigurer freemarkerConfigurer) {
		this.freemarkerConfigurer = freemarkerConfigurer;
	}
	
	


	public synchronized boolean processTemplate(String templateName, Map<?, ?> root,
			String  outFileName) {		
		boolean result = false;
		Template template;
		// 生成文件（这里是我们是生成html）
		try {
			Writer out = new OutputStreamWriter(new FileOutputStream(baseHtmlPath+ outFileName), "UTF-8");
			template = freemarkerConfigurer.getConfiguration().getTemplate(
					templateName, "utf-8");
			template.process(root, out);
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
