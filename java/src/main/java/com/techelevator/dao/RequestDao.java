package com.techelevator.dao;

import com.techelevator.model.Customer;
import com.techelevator.model.Request;

import java.util.List;

public interface RequestDao {

    public Request getRequestById(int requestId);

    public List<Request> getAllRequests(int customerId);
    public int addRequest(Request request);

    public Customer getCustomerByUserId(int userId);

}
