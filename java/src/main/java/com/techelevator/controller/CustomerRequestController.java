package com.techelevator.controller;

import com.techelevator.dao.RequestDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Request;
import com.techelevator.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RequestMapping("/customer/requests")
public class CustomerRequestController {

    private RequestDao requestDao;

    private UserDao userDao;

    public CustomerRequestController(RequestDao requestDao , UserDao userDao) {
        this.requestDao = requestDao;
        this.userDao = userDao;
    }

    /**
     * Returns the current logged-in user.
     * @param username The principal username,.
     * @return The current logged-in user.
     */
    public User getLoggedInUser(String username)
    {
        return this.userDao.findByUsername(username);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Request> getAllRequests(Principal principal) {

        User loggedInUser = getLoggedInUser(principal.getName());

        return requestDao.getAllRequests(loggedInUser.getId());
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<Request> getAllRequests() {

        return requestDao.getAllRequests();
    }

    @RequestMapping(path = "/{requestId}", method = RequestMethod.GET)
    public Request getRequestById(@PathVariable int requestId)
    {
        return requestDao.getRequestById(requestId);

    }

    @RequestMapping(method = RequestMethod.POST)
    public Request addRequest(@RequestBody Request request, Principal principal){

        User loggedInUser = getLoggedInUser(principal.getName());

        int id = requestDao.addRequest(loggedInUser.getId(), request);
        request.setRequestId(id);
        request.setCustomerId(loggedInUser.getId());

        return request;
    }
//
//    @RequestMapping(path = "/account/{userId}", method = RequestMethod.GET)
//    public User getCustomerByUserId(@PathVariable int userId){ return requestDao.getCustomerByUserId(userId); }
//
//    @RequestMapping(path = "/employeeAccount/{userId}", method = RequestMethod.GET)
//    public User getEmployeeByUserId(@PathVariable int userId){ return requestDao.getEmployeeByUserId(userId); }
}
