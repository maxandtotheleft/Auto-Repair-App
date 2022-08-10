package com.techelevator.controller;

import com.techelevator.dao.VehicleDao;
import com.techelevator.model.Vehicle;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class VehicleController {
    private VehicleDao vehicleDao;

    public VehicleController(VehicleDao vehicleDao) {this.vehicleDao = vehicleDao;}

    @RequestMapping(path = "/vehicle/{customerId}", method = RequestMethod.GET)
    public List<Vehicle> getVehicleByCustomerId(@PathVariable int customerId) {return vehicleDao.getVehicleByCustomerId(customerId);}

}
