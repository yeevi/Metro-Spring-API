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

import com.ivy.projects.sybyl.Metro.model.Passenger;
import com.ivy.projects.sybyl.Metro.repository.PassengerRepository;

@RestController
@RequestMapping(path="/passenger", produces="application/json")
@CrossOrigin(origins="*")
public class PassengerController {

	private final PassengerRepository passengerRepo;

	public PassengerController(PassengerRepository passengerRepo) {
		this.passengerRepo = passengerRepo;
	}

	@GetMapping
	public Iterable<Passenger> allPassenger() {
		return passengerRepo.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Passenger> passengerById(@PathVariable("id") int id) {
		Optional<Passenger> optPassenger = passengerRepo.findById(id);
		if(optPassenger.isPresent()) {
			return new ResponseEntity<>(optPassenger.get(), HttpStatus.OK);
		}

		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Passenger createProduct(@RequestBody Passenger passenger) {
		//Set object's timestamp field/s such as 'dateSaved' using `LocalDateTime.now()` as an example.

		Passenger savedPassenger= passengerRepo.save(passenger); 
		return savedPassenger;
	}

	@PutMapping(path="/{id}", consumes="application/json")
	public Passenger updatePassenger(@PathVariable("id") int passengerId, @RequestBody Passenger passenger) {
		passenger.setPId(passengerId);
		return passengerRepo.save(passenger);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePassenger(@PathVariable("id") int passengerId) {
		try {
			passengerRepo.deleteById(passengerId);
		} catch(EmptyResultDataAccessException e) {}
	}
}
