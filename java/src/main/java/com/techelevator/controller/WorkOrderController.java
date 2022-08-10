package com.techelevator.controller;

import com.techelevator.dao.WorkOrderDao;
import com.techelevator.model.WorkOrder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class WorkOrderController {

    private WorkOrderDao workOrderDao;

    public WorkOrderController(WorkOrderDao workOrderDao) {this.workOrderDao = workOrderDao; }

    @RequestMapping(path = "/workorders", method = RequestMethod.GET)
    public List<WorkOrder> getWorkOrders(){return this.workOrderDao.getWorkOrders();}

}
