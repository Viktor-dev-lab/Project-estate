package com.javaWeb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaWeb.repository.BuildingRepository;
import com.javaWeb.repository.entity.BuildingEntity;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
	 // Thông tin kết nối cơ sở dữ liệu
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=EstateBasic; encrypt=false";
    private static final String USER = "myuser";
    private static final String PASS = "myuser";
	
	
	@Override
	public List<BuildingEntity> findAll(String name, Long districtID) {
		List<BuildingEntity> buildngs = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM Building b WHERE 1 = 1");
        if (name != null && !name.equals("")) {
        	sql.append("AND b.name like '%" + name + "%' ");
        }
        if (districtID != null) {
        	sql.append(" AND b.districtid = " + districtID + " ");
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql.toString())) {

            // Duyệt kết quả và thêm vào danh sách
        	while (rs.next()) {
        	    BuildingEntity building = new BuildingEntity();
        	    
        	    // Set giá trị cho các trường
        	    building.setName(rs.getString("Name")); // Tên tòa nhà
        	    building.setDistrictId(rs.getInt("DistrictId")); // ID quận
        	    building.setStreet(rs.getString("Street")); // Tên đường
        	    building.setWard(rs.getString("Ward")); // Phường
        	    building.setNumberOfBasement(rs.getInt("NumberOfBasement")); // Số tầng hầm
        	    building.setFloorArea(rs.getDouble("FloorArea")); // Diện tích sàn
        	    building.setRentPrice(rs.getDouble("RentPrice")); // Giá thuê

        	    // Thêm đối tượng vào danh sách
        	    buildngs.add(building);
        	}

            System.out.println("Connected to the database successfully!");
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Database connection failed: " + e.getMessage());
        }

        return buildngs; // Trả về danh sách các tòa nhà
	}
	
}
