package com.gmail.malikchettih.springcloud.angular.bikes.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gmail.malikchettih.springcloud.angular.bikes.models.Bike;
import com.gmail.malikchettih.springcloud.angular.bikes.repositories.BikeRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api/v1/bikes")
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of Bikes.")
public class BikeController {
	
	@Autowired
	private BikeRepository bikeRepository;
	
	@GetMapping
	@ApiOperation("Returns list of all Bikes in the system.")
	public List<Bike> list(){
		return bikeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Returns a specific bike by their identifier. 404 if does not exist.",
    notes = "Also returns a link to retrieve all bikes with rel - all-bikes")
	public Bike get(@ApiParam("Id of the bike to be obtained. Cannot be empty.") @PathVariable("id") long id) {
		return bikeRepository.getOne(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation("Creates a new bike.")
	public void create(@ApiParam("Bike information for a new bike to be created.") @RequestBody Bike bike) {
		bikeRepository.save(bike);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation("Deletes a bike from the system. 404 if the person's identifier is not found.")
	public void delete(@ApiParam("Id of the bike to be deleted. Cannot be empty.")@PathVariable long id) {
		bikeRepository.deleteById(id);;
	}
}
