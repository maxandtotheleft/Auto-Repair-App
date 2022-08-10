package com.techelevator.dao;

import com.techelevator.model.Request;
import com.techelevator.model.Vehicle;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcVehicleDao implements VehicleDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcVehicleDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Vehicle getVehicleByCustomerId(int customerId) {
        Vehicle vehicle = null;
        String sql = "SELECT vehicle_id, customer_id, make, model, year, color FROM vehicles WHERE customer_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, customerId);
        if (results.next()) {
            vehicle = mapRowToVehicle(results);
        }
        return vehicle;    }

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
