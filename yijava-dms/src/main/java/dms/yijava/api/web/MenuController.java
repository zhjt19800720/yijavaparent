package dms.yijava.api.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class MenuController {

	
	@RequestMapping("/getmenu")
	@ResponseBody
	public Map<String,String> getMenu()
	{
		Map<String,String> map=new HashMap<String,String>();
		map.put("dd", "111");
		return map;
	}
}
