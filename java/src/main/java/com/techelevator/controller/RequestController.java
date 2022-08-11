package com.techelevator.controller;

import com.techelevator.dao.RequestDao;
import com.techelevator.model.Customer;
import com.techelevator.model.Employee;
import com.techelevator.model.Request;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class RequestController {

    private RequestDao requestDao;

    public RequestController(RequestDao requestDao) {
        this.requestDao = requestDao;
    }

    @RequestMapping(path = "/requests/{requestId}", method = RequestMethod.GET)
    public Request getRequestById(@PathVariable int requestId){ return requestDao.getRequestById(requestId); }

    @RequestMapping(path = "/customerRequests/{customerId}", method = RequestMethod.GET)
    public List<Request> getAllRequests(@PathVariable int customerId){ return requestDao.getAllRequests(customerId); }

    @RequestMapping(path = "/requests/", method = RequestMethod.POST)
    public Request addRequest(@RequestBody Request request){
        int id = requestDao.addRequest(request);
        request.setRequestId(id);
        return request;
    }

    @RequestMapping(path = "/account/{userId}", method = RequestMethod.GET)
    public Customer getCustomerByUserId(@PathVariable int userId){ return requestDao.getCustomerByUserId(userId); }

    @RequestMapping(path = "/employeeAccount/{userId}", method = RequestMethod.GET)
    public Employee getEmployeeByUserId(@PathVariable int userId){ return requestDao.getEmployeeByUserId(userId); }
}
