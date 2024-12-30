package com.javaWeb.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaWeb.model.BuildingDTO;
import com.javaWeb.repository.BuildingRepository;
import com.javaWeb.repository.entity.BuildingEntity;
import com.javaWeb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService{
	@Autowired
	private BuildingRepository buildingRepository;
	
	@Override
	public List<BuildingDTO> findAll(String name, Long districtID) {
		// TODO Auto-generated method stub
		List<BuildingEntity> buildingEntites = buildingRepository.findAll(name,districtID);
		List<BuildingDTO> buildings = new ArrayList<BuildingDTO>();
		for(BuildingEntity item : buildingEntites) {
			BuildingDTO building = new BuildingDTO();
			building.setName(item.getName());
			building.setStress(item.getStreet());
			building.setFloor(item.getNumberOfBasement());
			buildings.add(building);
		}
		return buildings;
	}
	
}
