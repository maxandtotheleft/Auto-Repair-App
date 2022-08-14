package com.techelevator.controller;

import com.techelevator.dao.VehicleDao;
import com.techelevator.model.Vehicle;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

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

    @RequestMapping(path = "/vehicle/years", method = RequestMethod.GET)
    public String getVehicleYears() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://car-data.p.rapidapi.com/cars/years"))
                .header("X-RapidAPI-Key", "3ce156a0cbmsh3cdebac2f07584ap1f99dejsn462087aef6d1")
                .header("X-RapidAPI-Host", "car-data.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    @RequestMapping(path = "/vehicle/makes", method = RequestMethod.GET)
    public String getVehicleMakes() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://car-data.p.rapidapi.com/cars/makes"))
                .header("X-RapidAPI-Key", "3ce156a0cbmsh3cdebac2f07584ap1f99dejsn462087aef6d1")
                .header("X-RapidAPI-Host", "car-data.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    @RequestMapping(path = "/vehicle/models/{year}/{make}", method = RequestMethod.GET)
    public String getVehicleModels(@PathVariable String year, @PathVariable String make) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(UriComponentsBuilder.fromUriString("https://car-data.p.rapidapi.com/cars").queryParam("year", year).queryParam("make", make).build().toUri())
                .header("X-RapidAPI-Key", "3ce156a0cbmsh3cdebac2f07584ap1f99dejsn462087aef6d1")
                .header("X-RapidAPI-Host", "car-data.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

}
