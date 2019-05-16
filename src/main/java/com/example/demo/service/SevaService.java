package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.bean.SevaBean;
import com.example.demo.entity.SevaDataEntity;

@Service
public interface SevaService {

	public void sevaDetails(SevaBean sevaBean);
	
	public List<SevaDataEntity> getALLSevaData();

	public SevaDataEntity getSevaById(Integer id);
	
	public void updateSevaDetails(SevaBean sevaBean);
	
	public void deleteSeva(SevaDataEntity details);

}
