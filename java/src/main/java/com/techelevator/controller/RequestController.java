package com.techelevator.controller;

import com.techelevator.dao.RequestDao;
import com.techelevator.model.Request;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    private RequestDao requestDao;

    public RequestController(RequestDao requestDao) {
        this.requestDao = requestDao;
    }

    @RequestMapping(path = "/requests/{requestId}", method = RequestMethod.GET)
    public Request getRequestById(@PathVariable int requestId){ return requestDao.getRequestById(requestId); }
}
