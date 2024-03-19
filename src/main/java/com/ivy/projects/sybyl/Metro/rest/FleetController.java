package com.ivy.projects.sybyl.Metro.rest;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ivy.projects.sybyl.Metro.model.Fleet;
import com.ivy.projects.sybyl.Metro.repository.FleetRepository;

@RestController
@RequestMapping(path="/fleet", produces="application/json")
@CrossOrigin(origins="*")
public class FleetController {

	private final FleetRepository fleetRepo;

	public FleetController(FleetRepository fleetRepo) {
		this.fleetRepo = fleetRepo;
	}

	@GetMapping
	public Iterable<Fleet> allFleet() {
		return fleetRepo.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Fleet> fleetById(@PathVariable("id") int id) {
		Optional<Fleet> optFleet = fleetRepo.findById(id);
		if(optFleet.isPresent()) {
			return new ResponseEntity<>(optFleet.get(), HttpStatus.OK);
		}

		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Fleet createProduct(@RequestBody Fleet fleet) {
		//Set object's timestamp field/s such as 'dateSaved' using `LocalDateTime.now()` as an example.

		Fleet savedFleet= fleetRepo.save(fleet); 
		return savedFleet;
	}

	@PutMapping(path="/{id}", consumes="application/json")
	public Fleet updateFleet(@PathVariable("id") int fleetId, @RequestBody Fleet fleet) {
		fleet.setFleetNo(fleetId);
		return fleetRepo.save(fleet);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteFleet(@PathVariable("id") int fleetId) {
		try {
			fleetRepo.deleteById(fleetId);
		} catch(EmptyResultDataAccessException e) {}
	}
}
