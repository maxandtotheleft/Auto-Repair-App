package com.techelevator.dao;

import com.techelevator.model.Request;
import com.techelevator.model.Vehicle;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcVehicleDao implements VehicleDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcVehicleDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Vehicle> getVehicleByCustomerId(int customerId) {
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle vehicle = null;
        String sql = "SELECT vehicle_id, customer_id, make, model, year, color FROM vehicles WHERE customer_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, customerId);
        while (results.next()) {
            vehicle = mapRowToVehicle(results);
            vehicles.add(vehicle);
        }
        return vehicles;    }

    private Vehicle mapRowToVehicle(SqlRowSet results) {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(results.getInt("vehicle_id"));
        vehicle.setCustomerId(results.getInt("customer_id"));
        vehicle.setMake(results.getString("make"));
        vehicle.setModel(results.getString("model"));
        vehicle.setYear(results.getInt("year"));
        vehicle.setColor(results.getString("color"));
        return vehicle;
    }
}
