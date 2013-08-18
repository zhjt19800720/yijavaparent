package com.yijava.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.yijava.common.utils.CollectionUtils;
import com.yijava.entity.Category;
import com.yijava.entity.RadioNew;
import com.yijava.orm.core.PageRequest;
import com.yijava.orm.core.PropertyFilter;
import com.yijava.orm.core.PropertyFilters;
import com.yijava.service.CategoryService;
import com.yijava.service.RadioNewService;
import com.yijava.web.vo.News;

@Controller
public class RadioNewController {

	private String IMGSAVEPATH="radiocover"+File.separatorChar;
	private String RADIOSAVEPATH="radiofile"+File.separatorChar;
	
	@Autowired
	private RadioNewService radioNewService;
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("rnew-view")
	public String view(PageRequest pageRequest,HttpServletRequest request,Model model)
	{
		List<PropertyFilter> filters = PropertyFilters.build(request);
		model.addAttribute("page", radioNewService.searchRadioNewPage(pageRequest, filters));
		
		
		return "rnewview";
	}
	
	@RequestMapping(value="/rnew-save", method = RequestMethod.POST)
	public String savernew(News entity ,@RequestParam MultipartFile[] file, HttpServletRequest request) {
		
		RadioNew radioNew=new RadioNew();
		//radioNew.setTitle(entity.getTitle());
		//radioNew.setCategory_id(entity.getCategory_id());
		BeanUtils.copyProperties(entity,radioNew, new String[]{"file","radiofile","categorys"});
		
		String[] categoryids=entity.getCategorys();		
		Long[] ids = new Long[categoryids.length];		
	    for (int idx = 0; idx < categoryids.length; idx++) {
	    	ids[idx] = Long.parseLong(categoryids[idx]);
	     }		
		
		List<Category> categorys=categoryService.getCategorys(ids);		
		Set<Category> strSet = new HashSet<Category>(categorys); 		
		radioNew.setCategorys(strSet);
		
		
		//是否已经设置过音频文件吗，不用上传了
		
		boolean issetrf=false,issetri=false;
		
		if(!entity.getAudiofilename().equals("") )
		{
			issetrf=true;
		}
		
		if(!entity.getImgfilename().equals(""))
		{
			issetri=true;
		}
		
		if(null!=file && file.length>0)
		{
			 int i=0;
			 for(MultipartFile myfile : file){  
				 
				 if(null!=myfile && !myfile.isEmpty())
				 {
					 if(i==0)
					 {
						 //图片
						//得到新的文件名
						 String realFileName=createtFileName()+"."+getExtensionName(myfile.getOriginalFilename());	
						 String realFilePath=IMGSAVEPATH+realFileName.substring(0,10)+File.separatorChar;
						 processUpload(request,new Integer(1),myfile,realFileName);
						 radioNew.setImage_file(realFilePath+realFileName);;
					 }
					 
					 if(i==1)
					 {
						 //音频		
						//得到新的文件名
						 String realFileName=createtFileName()+"."+getExtensionName(myfile.getOriginalFilename());		
						 String realFilePath=RADIOSAVEPATH+realFileName.substring(0,10)+File.separatorChar;
						 processUpload(request,new Integer(2),myfile,realFileName);	
						 radioNew.setRadio_file(realFilePath+realFileName);
					 }
					 
				 }
				 i++;				 
			 }			
		}
		
		if(issetrf)
		{
			radioNew.setRadio_file(entity.getAudiofilename());
		}
		
		if(issetri)
		{
			radioNew.setImage_file(entity.getImgfilename());
		}
		
		
		if(radioNew.getCreate_date()==null)
		{
			radioNew.setCreate_date(new Date());
		}
		if(radioNew.getLast_date()==null)
		{
			radioNew.setLast_date(new Date());
		}
		
		
		radioNewService.insertRadioNew(radioNew);
		return "redirect:/rnew-view";
	}
	
	
	
	
	@RequestMapping("/rnew-add")
	public String add(Model model) {
		model.addAttribute("catelist", categoryService.getAllCategory());
		
		
		return "rnewadd";
	}
	
	@RequestMapping("/rnew-update")
	public String update(News entity, @RequestParam MultipartFile[] file, HttpServletRequest request) {		
		RadioNew radioNew=new RadioNew();
		BeanUtils.copyProperties(entity,radioNew, new String[]{"file","radiofile","categorys","audiofilename","imgfilename"});					
		RadioNew oldradioNew= radioNewService.getRadioNew(radioNew.getId());		
		
		String[] categoryids=entity.getCategorys();		
		Long[] ids = new Long[categoryids.length];		
	    for (int idx = 0; idx < categoryids.length; idx++) {
	    	ids[idx] = Long.parseLong(categoryids[idx]);
	     }		
		
		List<Category> categorys=categoryService.getCategorys(ids);		
		Set<Category> strSet = new HashSet<Category>(categorys); 		
		radioNew.setCategorys(strSet);
		
		//是否已经设置过音频文件吗，不用上传了
		
		boolean issetrf=false,issetri=false;
		
		if(!entity.getAudiofilename().equals("") )
		{
			issetrf=true;
		}
		
		if(!entity.getImgfilename().equals(""))
		{
			issetri=true;
		}
		
		if(null!=file && file.length>0)
		{
			 int i=0;
			 for(MultipartFile myfile : file){  
				 
				 if(null!=myfile && !myfile.isEmpty())
				 {
					 if(i==0)
					 {
						 //图片
						//得到新的文件名
						 String realFileName=createtFileName()+"."+getExtensionName(myfile.getOriginalFilename());	
						 String realFilePath=IMGSAVEPATH+realFileName.substring(0,10)+File.separatorChar;
						 processUpload(request,new Integer(1),myfile,realFileName);
						 radioNew.setImage_file(realFilePath+realFileName);;
					 }
					 
					 if(i==1)
					 {
						 //音频		
						//得到新的文件名
						 String realFileName=createtFileName()+"."+getExtensionName(myfile.getOriginalFilename());		
						 String realFilePath=RADIOSAVEPATH+realFileName.substring(0,10)+File.separatorChar;
						 processUpload(request,new Integer(2),myfile,realFileName);	
						 radioNew.setRadio_file(realFilePath+realFileName);
					 }
					 
				 }else
				 {
					 if(i==0)
					 {
						 radioNew.setImage_file(oldradioNew.getImage_file());;
						 
					 }
					 
					 if(i==1)
					 {
						 radioNew.setRadio_file(oldradioNew.getRadio_file());
					 }
					 
				 }
				 i++;				 
			 }			
		}
		
		if(issetrf)
		{
			radioNew.setRadio_file(entity.getAudiofilename());
		}
		
		if(issetri)
		{
			radioNew.setImage_file(entity.getImgfilename());
		}
		
		
		if(radioNew.getLast_date()==null)
		{
			radioNew.setLast_date(new Date());
		}
		
		radioNew.setCreate_date(oldradioNew.getCreate_date());
		//BeanUtils.copyProperties(category,entity, new String[]{"id,category,update_at"});
		radioNewService.updateRadioNew(oldradioNew,radioNew);
		return "redirect:/rnew-view";
	}
	
	@RequestMapping("/rnew-read")
	public String read(@RequestParam(value = "id", required = false)Integer id,Model model) {
		model.addAttribute("catelist", categoryService.getAllCategory());
		if (null!=id) {
			
			return "rnewread";
		} else {
			return "rnewadd";
		}
	}
	
	
	@RequestMapping("/rnew-del")
	public String delete(@RequestParam(value = "id", required = false)Long id,Model model) {
		
		List<Long> ids=new ArrayList<Long>();
		ids.add(id);
		
		radioNewService.deleteRadioNew(ids);
		return "redirect:/rnew-view";
	}
	
	
	@ModelAttribute("entity")
	public RadioNew bindingModel(@RequestParam(value = "id", required = false)Long id) {		
		RadioNew radioNew = new RadioNew();		
		if (null!=id) {			
			try {
				radioNew = radioNewService.getRadioNew(id);
				System.out.println(radioNew.getCategorys().size());
				//System.out.println(radioNew.getCategory().getCategory());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return radioNew;
	}
	
	public String getExtensionName(String filename) {   
        if ((filename != null) && (filename.length() > 0)) {   
            int dot = filename.lastIndexOf('.');   
            if ((dot >-1) && (dot < (filename.length() - 1))) {   
                return filename.substring(dot + 1);   
            }   
        }   
        return filename;   
    }   
	
	public synchronized String createtFileName() {
		java.util.Date dt = new java.util.Date(System.currentTimeMillis());
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String fileName= fmt.format(dt);		
		return fileName;
	}
	
	private boolean processUpload(HttpServletRequest request,Integer type,MultipartFile file,String realFileName)
	{		
		String ctxPath = request.getSession().getServletContext().getRealPath("/");
		String subPath = File.separatorChar+realFileName.substring(0,10);
		
		//开始处理文件上传
		if(type.intValue()==1){
			ctxPath +=IMGSAVEPATH;  
		}else
		{
			ctxPath +=RADIOSAVEPATH;  
		}
		ctxPath+=subPath;
		
		File dirPath = new File(ctxPath);  
        if (!dirPath.exists()) {  
           // dirPath.mkdir();
            dirPath.mkdirs();
        }
        //String realFileName = file.getOriginalFilename();  
        
        try {
			copyFile(file.getInputStream(),ctxPath +File.separatorChar+ realFileName);
		} catch (IOException e) {
			return false;
		}
        return true;
		
	}
	
	 private void copyFile(InputStream in,String fileName) throws IOException{  
         FileOutputStream fs = new FileOutputStream(fileName);  
           byte[] buffer = new byte[1024 * 1024];  
           int bytesum = 0;  
           int byteread = 0;  
           while ((byteread = in.read(buffer)) != -1) {  
               bytesum += byteread;  
               fs.write(buffer, 0, byteread);  
               fs.flush();  
           }  
           fs.close();  
           in.close();  
     }  
	
}
