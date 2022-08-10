package com.techelevator.dao;

import com.techelevator.model.Vehicle;

public interface VehicleDao {

    Vehicle getVehicleByCustomerId(int customerId);
}
