package com.javaWeb.repository;

import java.util.*;

import com.javaWeb.repository.entity.BuildingEntity;


public interface BuildingRepository {
	List<BuildingEntity> findAll(String name, Long districtID);
}
