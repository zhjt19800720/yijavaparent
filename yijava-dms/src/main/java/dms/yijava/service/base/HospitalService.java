package dms.yijava.service.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dms.yijava.dao.HospitalDao;
import dms.yijava.entity.Hospital;

@Service
@Transactional
public class HospitalService {

	@Autowired
	private HospitalDao hospitalDao;

	public Hospital getEntity(String id) {
		return hospitalDao.get(id);
	}
	public List<Hospital> getAllEntity() {
		return hospitalDao.getAll();
	}
	public void saveEntity(Hospital entity) {
		hospitalDao.insert(entity);
	}
	
	public void deleteEntity(List<String> ids) {
		for(String id:ids)
			hospitalDao.removeById(id);
	}
	
	public void deleteEntity(String id) {
		hospitalDao.removeById(id);
	}
	public void updateEntity(Hospital entity) {
		hospitalDao.update( entity);
	}
	/*s
	public JsonPage<Hospital> searchHospitalPage(PageRequest request,
			List<PropertyFilter> filters) {
		return hospitalDao.findPageForJson(request, filters);
	}
	
	
	*//**
	 * 获取医院实体
	 * 
	 * @param id
	 *//*
	public Hospital getHospital(String id) {
		return hospitalDao.get(id);
	}
	
	
	public void saveHospital(Hospital entity) {
		hospitalDao.save(entity);
	}
	
	
	public void deleteHospital(List<String> ids) {
		hospitalDao.deleteAll(ids);
	}*/
}
