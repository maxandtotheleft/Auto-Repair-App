package com.techelevator.dao;

import com.techelevator.model.Request;
import com.techelevator.model.WorkOrder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcWorkOrderDao implements WorkOrderDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcWorkOrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<WorkOrder> getWorkOrders() {
        List<WorkOrder> result = new ArrayList<>();
        String sql = "SELECT work_order_id, employee_id, all_completed, time_completed FROM work_orders";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()) {
            WorkOrder workOrder = mapRowToWorkOrder(rowSet);
            result.add(workOrder);
        }
        return result;
    }

    private WorkOrder mapRowToWorkOrder(SqlRowSet rowSet) {
        WorkOrder workorder = new WorkOrder();
        workorder.setWorkOrderId(rowSet.getInt("work_order_id"));
        workorder.setEmployeeId(rowSet.getInt("employee_id"));
        workorder.setAllCompleted(rowSet.getBoolean("all_completed"));
        workorder.setTimeCompleted(rowSet.getTimestamp("time_completed").toLocalDateTime());
        return workorder;
    }


}
