package com.yijava.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller

public class UploadFileController {

	@RequestMapping(value = "/uploadfile")
	public String create(@RequestParam MultipartFile file) {
		
		System.out.println(file.getOriginalFilename());
		
		
		return "tt";
	}
}
