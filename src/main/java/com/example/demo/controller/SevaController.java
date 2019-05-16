package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.SevaBean;
import com.example.demo.entity.SevaDataEntity;
import com.example.demo.service.SevaService;

@RestController
public class SevaController {

	@Autowired
	public SevaService sevaService;
	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/sevaDetails", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
	public void sevaDetails(@RequestBody SevaBean sevaBean, HttpServletRequest request) {
		
		System.out.println("SevaName" +sevaBean.getSevaName());
		System.out.println("Price" +sevaBean.getPrice());
		sevaService.sevaDetails(sevaBean);

	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/updateSevaDetails", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
	public void updateSevaDetails(@RequestBody SevaBean sevaBean, HttpServletRequest request) {
		System.out.println("SevaName" +sevaBean.getSevaName());
		System.out.println("Price" +sevaBean.getPrice());
		
		sevaService.updateSevaDetails(sevaBean);

	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/getAllSevaDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SevaDataEntity> getSevaDetails(HttpServletRequest request) {

		List<SevaDataEntity> details  = sevaService.getALLSevaData();
		return details;
		
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/getSevaDetails/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public SevaBean getSevaById(@PathVariable Integer id,HttpServletRequest request) {

		SevaDataEntity details  = sevaService.getSevaById(id);
		SevaBean bean = new SevaBean();
		bean.setId(details.getId());
		bean.setSevaName(details.getSevaName());
		bean.setPrice(details.getPrice());
		return bean;
 
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/deleteSeva/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteSeva(@PathVariable Integer id,HttpServletRequest request) {
		SevaDataEntity details  = sevaService.getSevaById(id);
		sevaService.deleteSeva(details);
	}

	
	
	
}
