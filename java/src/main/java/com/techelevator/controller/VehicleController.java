package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.dao.VehicleDao;
import com.techelevator.model.User;
import com.techelevator.model.Vehicle;
import com.techelevator.security.SecurityUtils;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RequestMapping("vehicle")
public class VehicleController {

    private VehicleDao vehicleDao;

    private UserDao userDao;

    public VehicleController(VehicleDao vehicleDao, UserDao userDao) {
        this.vehicleDao = vehicleDao;
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
    public List<Vehicle> list(Principal principal) {

        User loggedInUser = getLoggedInUser(principal.getName());

        return vehicleDao.getVehicleByCustomerId(loggedInUser.getId());}

    @RequestMapping(method = RequestMethod.POST)
    public Vehicle create(@RequestBody Vehicle vehicle, Principal principal) {
        User loggedInUser = getLoggedInUser(principal.getName());

        int id = vehicleDao.addVehicle(loggedInUser.getId(), vehicle);
        vehicle.setVehicleId(id);
        return vehicle;
    }
}
