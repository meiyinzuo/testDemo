package com.example.demo.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Area;
import com.example.demo.service.AreaService;

@RestController
@RequestMapping("/superadmin")
public class AreaController {
	
	@Autowired
	private AreaService areaService;
	
	@RequestMapping(value = "/listarea", method = RequestMethod.GET)
	private Map<String, Object> listArea(){
		Map< String, Object> map = new HashMap<String, Object>();
		List<Area> list = areaService.queryArea();
		map.put("areaList", list);
		return map;
	}
	
	@RequestMapping(value = "/getareabyid", method = RequestMethod.GET)
	private Map<String, Object> getAreaById(int id){
		Map< String, Object> map = new HashMap<String, Object>();
		Area area = areaService.queryAreaById(id);
		map.put("area", area);
		return map;
	}
	
	@RequestMapping(value = "/insertarea", method = RequestMethod.POST)
	private Map<String, Object> addArea(@RequestBody Area area){
		Map< String, Object> map = new HashMap<String, Object>();
		map.put("success", areaService.insertArea(area));
		return map;
	}
	
	@RequestMapping(value = "/modifyarea", method = RequestMethod.POST)
	private Map<String, Object> modifyArea(@RequestBody Area area){
		Map< String, Object> map = new HashMap<String, Object>();
		map.put("success", areaService.updateArea(area));
		return map;
	}
	
	@RequestMapping(value = "/removearea", method = RequestMethod.GET)
	private Map<String, Object> removeArea(Integer id){
		Map< String, Object> map = new HashMap<String, Object>();
		map.put("success", areaService.deleteArea(id));
		return map;
	}
}
