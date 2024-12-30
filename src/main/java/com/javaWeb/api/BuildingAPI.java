package com.javaWeb.api;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.javaWeb.Exception.FeldRequiredException;
import com.javaWeb.model.BuildingDTO;
import com.javaWeb.service.BuildingService;

import java.util.*;

@RestController
public class BuildingAPI {
	@Autowired
	private BuildingService customerService;
	
    // API lấy danh sách khách hàng theo tên
    @GetMapping(value = "/api/building")
    public List<BuildingDTO> getCustomer(@RequestParam(name="name", required = false) String name,
    									 @RequestParam(name="districtID", required = false) Long district)
    {
    	List<BuildingDTO> customers = customerService.findAll(name, district);
    	return customers;
    }

    // Phương thức validate dữ liệu nhập vào
    public void valiDate(BuildingDTO buildingDTO) {
        if (buildingDTO.getName() == null || buildingDTO.getName().trim().isEmpty()) {
            throw new FeldRequiredException("Name is null or empty");
        }
        if (buildingDTO.getFloor() == null) {
            throw new FeldRequiredException("Floor is null");
        }
        if (buildingDTO.getStress() == null || buildingDTO.getStress().trim().isEmpty()) {
            throw new FeldRequiredException("Stress is null or empty");
        }
    }
}
