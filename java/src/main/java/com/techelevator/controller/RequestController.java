package com.techelevator.controller;

import com.techelevator.dao.RequestDao;
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
}
