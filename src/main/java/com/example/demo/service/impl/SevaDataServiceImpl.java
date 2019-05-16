package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.bean.SevaBean;
import com.example.demo.entity.EmployeeDataEntity;
import com.example.demo.entity.SevaDataEntity;
import com.example.demo.repository.SevaDataRepository;
import com.example.demo.service.SevaService;

@Component
public class SevaDataServiceImpl implements SevaService{

	@Autowired
	public SevaDataRepository sevaDataRepository;
	
	@Override
	public void sevaDetails(SevaBean sevaBean) {
		SevaDataEntity sevaDataEntity = new SevaDataEntity();
		sevaDataEntity.setSevaName(sevaBean.getSevaName());
		sevaDataEntity.setPrice(sevaBean.getPrice());
		sevaDataRepository.save(sevaDataEntity);
		
	}

	@Override
	public List<SevaDataEntity> getALLSevaData() {
		
		List<SevaDataEntity> entity = sevaDataRepository.findAll();
		return entity;
		
	}

	@Override
	public SevaDataEntity getSevaById(Integer id) {
		
		SevaDataEntity entity = sevaDataRepository.getOne(id);
		return entity;
	}

	@Override
	public void updateSevaDetails(SevaBean sevaBean) {
		
		SevaDataEntity sevaDataEntity = new SevaDataEntity();
		sevaDataEntity.setSevaName(sevaDataEntity.getSevaName());
		sevaDataEntity.setPrice(sevaDataEntity.getPrice());
		sevaDataRepository.save(sevaDataEntity);
		
	}

	@Override
	public void deleteSeva(SevaDataEntity details) {
		sevaDataRepository.delete(details);
	}
}
