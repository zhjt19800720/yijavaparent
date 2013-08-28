package dms.yijava.api.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yijava.orm.core.JsonPage;
import com.yijava.orm.core.PageRequest;
import com.yijava.orm.core.PropertyFilter;
import com.yijava.orm.core.PropertyFilters;
import com.yijava.web.vo.Result;

import dms.yijava.entity.Hospital;
import dms.yijava.service.base.HospitalService;

@Controller
@RequestMapping("/api/hospital")
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;
	
	@ResponseBody
	@RequestMapping("read")
	public Hospital read(@RequestParam(value = "id", required = false) String id) {
		Hospital hospital=hospitalService.getEntity(id);
		return hospital;
	}
	
	
	@ResponseBody
	@RequestMapping("readall")
	public List<Hospital> read() {
		return hospitalService.getAllEntity();
		
	}
	
	@ResponseBody
	@RequestMapping("save")
	public Result<String> save(@ModelAttribute("entity") Hospital entity) {
		hospitalService.saveEntity(entity);
		return new Result<String>("1", 1);
	}
	
	@ResponseBody
	@RequestMapping("delete")
	public Result<String> delete(@RequestParam(value = "id", required = false) String id) {
		hospitalService.deleteEntity(id);
		return new Result<String>("1", 1);
	}
	
	@ResponseBody
	@RequestMapping("update")
	public Result<String> update(@ModelAttribute("entity") Hospital entity) {
		hospitalService.updateEntity(entity);
		return new Result<String>("1", 1);
	}
/*
	@ResponseBody
	@RequestMapping("view")
	public JsonPage<Hospital> view(PageRequest pageRequest,
			HttpServletRequest request) {
		List<PropertyFilter> filters = PropertyFilters.build(request);
		return hospitalService.searchHospitalPage(pageRequest, filters);
	}
	@ResponseBody
	@RequestMapping("save")
	public Result<String> save(@ModelAttribute("entity") Hospital entity) {
		hospitalService.saveHospital(entity);
		return new Result<String>("1", 1);
	}
	@ResponseBody
	@RequestMapping("read")
	public Hospital read(@RequestParam(value = "id", required = false) String id) {
		Hospital hospital=hospitalService.getHospital(id);
		return hospital;
	}
	@ResponseBody
	@RequestMapping("delete")
	public Result<String> delete(@RequestParam("ids") List<String> ids) {
		hospitalService.deleteHospital(ids);
		return new Result<String>("1", 1);
	}*/
}
