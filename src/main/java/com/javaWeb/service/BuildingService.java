package com.javaWeb.service;

import java.util.List;

import com.javaWeb.model.BuildingDTO;

public interface BuildingService {
	List<BuildingDTO> findAll(String name, Long districtID);
}
