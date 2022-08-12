package com.techelevator.controller;

import com.techelevator.dao.WorkOrderDao;
import com.techelevator.model.Repair;
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

    @RequestMapping(path = "/workorders/{userId}", method = RequestMethod.GET)
    public List<WorkOrder> getWorkOrdersByUser(@PathVariable int userId){return this.workOrderDao.getWorkOrdersByUserId(userId);}

    @RequestMapping(path = "/repairs/{workOrderId}", method = RequestMethod.GET)
    public List<Repair> getRepairsByWorkOrderId(@PathVariable int workOrderId){return this.workOrderDao.getRepairsByWorkOrderId(workOrderId); }

    @RequestMapping(path = "/workorders", method = RequestMethod.POST)
    public boolean create(@RequestBody WorkOrder workOrder) {
        return workOrderDao.createWorkOrder(workOrder);
    }

    @RequestMapping(path = "/repairs", method = RequestMethod.POST)
    public boolean createRepair(@RequestBody Repair repair) {
        return workOrderDao.createRepair(repair);
    }

}
