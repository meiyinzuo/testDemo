package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Area;

public interface AreaService {
	List<Area> queryArea();
	Area queryAreaById(int id);
	boolean insertArea(Area area);
	boolean updateArea(Area area);
	boolean deleteArea(int id);
}
