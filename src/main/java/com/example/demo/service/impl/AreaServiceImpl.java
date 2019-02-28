package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.AreaDao;
import com.example.demo.entity.Area;
import com.example.demo.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService{
	
	@Autowired
	private AreaDao areaDao;
	
	@Override
	public List<Area> queryArea() {
		return areaDao.queryArea();
	}

	@Override
	public Area queryAreaById(int id) {
		int a = 1/0;
		return areaDao.queryAreaById(id);
	}

	@Override
	@Transactional
	public boolean insertArea(Area area) {
		if(area.getName() != null && !"".equals(area.getName())){
			area.setCreateDate(new Date());
			area.setLastEditTime(new Date());
			
			try {
				int num = areaDao.insertArea(area);
				if(num > 0){
					return true;
				}else {
					throw new RuntimeException("插入信息失败");
				}
			} catch (Exception e) {
				throw new RuntimeException("插入信息失败"+e.getMessage());
			}
		}else {
			throw new RuntimeException("区域信息不能为空");
		}
	}

	@Override
	public boolean updateArea(Area area) {
		if(area.getId() != null && 0==area.getId()){
			area.setCreateDate(new Date());
			area.setLastEditTime(new Date());
			
			try {
				int num = areaDao.updateArea(area);
				if(num > 0){
					return true;
				}else {
					throw new RuntimeException("插入信息失败");
				}
			} catch (Exception e) {
				throw new RuntimeException("插入信息失败"+e.getMessage());
			}
		}else {
			throw new RuntimeException("区域信息不能为空");
		}
	}

	@Override
	public boolean deleteArea(int id) {
		if(id > 0 ){
			
			try {
				int num = areaDao.deleteArea(id);
				if(num > 0){
					return true;
				}else {
					throw new RuntimeException("插入信息失败");
				}
			} catch (Exception e) {
				throw new RuntimeException("插入信息失败"+e.getMessage());
			}
		}else {
			throw new RuntimeException("区域信息不能为空");
		}
	}
	
}
