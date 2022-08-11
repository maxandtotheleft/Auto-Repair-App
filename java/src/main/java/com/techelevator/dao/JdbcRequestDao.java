package com.techelevator.dao;

import com.techelevator.model.Customer;
import com.techelevator.model.Employee;
import com.techelevator.model.Request;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcRequestDao implements RequestDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcRequestDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Request getRequestById(int requestId) {
        Request request = null;
        String sql = "SELECT request_id, customer_id, vehicle_id, description FROM requests WHERE request_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, requestId);
        if (results.next()) {
            request = mapRowToRequest(results);
        }
        return request;
    }

    @Override
    public List<Request> getAllRequests(int customerId) {
        List<Request> result = new ArrayList<>();
        String sql = "SELECT request_id, customer_id, vehicle_id, description FROM requests WHERE customer_id = ?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, customerId);
        while (rowSet.next()) {
            Request request = mapRowToRequest(rowSet);
            result.add(request);
        }
        return result;
    }

    @Override
    public int addRequest(Request request) {
        String sql = "INSERT INTO requests (customer_id, vehicle_id, description) VALUES (?, ?, ?) RETURNING request_id";
        int id = jdbcTemplate.queryForObject(sql, Integer.class, request.getCustomerId(), request.getVehicleId(), request.getDescription());
        return id;
    }

    @Override
    public Customer getCustomerByUserId(int userId) {
        Customer customer = new Customer();
        String sql = "SELECT customer_id, user_id FROM customers WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        if (results.next()) {
            customer.setCustomerId(results.getInt("customer_id"));
            customer.setUserId(results.getInt("user_id"));
        }
        return customer;
    }

    @Override
    public Employee getEmployeeByUserId(int userId) {
        Employee employee = new Employee();
        String sql = "SELECT employee_id, user_id FROM employees WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        if (results.next()) {
            employee.setEmployeeId(results.getInt("employee_id"));
            employee.setEmployeeId(results.getInt("user_id"));
        }
        return employee;
    }

    private Request mapRowToRequest(SqlRowSet rs) {
        Request request = new Request();
        request.setRequestId(rs.getInt("request_id"));
        request.setCustomerId(rs.getInt("customer_id"));
        request.setVehicleId(rs.getInt("vehicle_id"));
        request.setDescription(rs.getString("description"));
        return request;
    }


}
