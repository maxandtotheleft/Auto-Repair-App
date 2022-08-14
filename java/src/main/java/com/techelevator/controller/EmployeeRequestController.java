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
@PreAuthorize("isAuthenticated() && hasRole('ROLE_EMPLOYEE')")
@RequestMapping("/employee/requests")
public class EmployeeRequestController {

    private RequestDao requestDao;

    private UserDao userDao;

    public EmployeeRequestController(RequestDao requestDao , UserDao userDao) {
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
    public List<Request> getAllRequests() {

        return requestDao.getAllRequests();
    }
}
