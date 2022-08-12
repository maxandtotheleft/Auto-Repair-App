package com.techelevator.controller;

import com.techelevator.dao.VehicleDao;
import com.techelevator.model.Vehicle;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
@CrossOrigin
public class VehicleController {
    private VehicleDao vehicleDao;

    public VehicleController(VehicleDao vehicleDao) {this.vehicleDao = vehicleDao;}

    @RequestMapping(path = "/vehicle/{customerId}", method = RequestMethod.GET)
    public List<Vehicle> getVehicleByCustomerId(@PathVariable int customerId) {return vehicleDao.getVehicleByCustomerId(customerId);}
}
