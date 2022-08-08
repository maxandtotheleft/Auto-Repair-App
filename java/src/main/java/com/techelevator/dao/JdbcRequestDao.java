package com.techelevator.dao;

import com.techelevator.model.Request;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

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

    private Request mapRowToRequest(SqlRowSet rs) {
        Request request = new Request();
        request.setRequestId(rs.getInt("request_id"));
        request.setCustomerId(rs.getInt("customer_id"));
        request.setVehicleId(rs.getInt("vehicle_id"));
        request.setDescription(rs.getString("description"));
        return request;
    }

}
