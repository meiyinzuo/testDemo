package com.example.demo.dao;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Area;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
	@Autowired
	private AreaDao areaDao;
	
	@Test
	public void testQueryArea() {
		List<Area> list = areaDao.queryArea();
		assertEquals(2,list.size());
	}

	@Test
	@Ignore
	public void testQueryById() {
		Area area = areaDao.queryAreaById(1);
		assertEquals("2", area.getPriority().toString());
	}

	@Test
	@Ignore
	public void testInsertArea() {
		Area area = new Area();
		area.setName("西苑");
		area.setPriority(3);
		int num = areaDao.insertArea(area);
		assertEquals(1, num);
	}

	@Test
	@Ignore
	public void testUpdateArea() {
		Area area = new Area();
		area.setPriority(10);
		area.setId(3);
		areaDao.updateArea(area);
	}
	
	@Test
	@Ignore
	public void testDeleteArea() {
		int num = areaDao.deleteArea(2);
		assertEquals(1, num);
	}

}
