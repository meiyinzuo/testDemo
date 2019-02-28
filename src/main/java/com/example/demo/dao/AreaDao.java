package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Area;

@Mapper
public interface AreaDao {
	List<Area> queryArea();
	Area queryAreaById(int id);
	int insertArea(Area area);
	int updateArea(Area area);
	int deleteArea(int id);
}
