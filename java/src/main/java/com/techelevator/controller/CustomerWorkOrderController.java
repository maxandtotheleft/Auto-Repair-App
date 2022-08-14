package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.dao.WorkOrderDao;
import com.techelevator.model.Repair;
import com.techelevator.model.User;
import com.techelevator.model.WorkOrder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated() && hasRole('ROLE_USER')")
@RequestMapping(path = "/customer/workorders", method = RequestMethod.GET)
public class CustomerWorkOrderController {

    private WorkOrderDao workOrderDao;

    private UserDao userDao;

    public CustomerWorkOrderController(WorkOrderDao workOrderDao, UserDao userDao) {
        this.workOrderDao = workOrderDao;
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

    /**
     * Gets work orders for logged-in user.
     * @param principal The spring security principal.
     * @return The list of work orders for logged-in user.
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<WorkOrder> getCustomerWorkOrders(Principal principal)
    {
        User loggedInUser = getLoggedInUser(principal.getName());
        return this.workOrderDao.getWorkOrdersByUserId(loggedInUser.getId());
    }
}
