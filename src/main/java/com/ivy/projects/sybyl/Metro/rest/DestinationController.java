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

import com.ivy.projects.sybyl.Metro.model.Destination;
import com.ivy.projects.sybyl.Metro.repository.DestinationRepository;

@RestController
@RequestMapping(path="/destination", produces="application/json")
@CrossOrigin(origins="*")
public class DestinationController {

	private final DestinationRepository destinationRepo;

	public DestinationController(DestinationRepository destinationRepo) {
		this.destinationRepo = destinationRepo;
	}

	@GetMapping
	public Iterable<Destination> allDestination() {
		return destinationRepo.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Destination> destinationById(@PathVariable("id") int id) {
		Optional<Destination> optDestination = destinationRepo.findById(id);
		if(optDestination.isPresent()) {
			return new ResponseEntity<>(optDestination.get(), HttpStatus.OK);
		}

		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Destination createProduct(@RequestBody Destination destination) {
		//Set object's timestamp field/s such as 'dateSaved' using `LocalDateTime.now()` as an example.

		Destination savedDestination= destinationRepo.save(destination); 
		return savedDestination;
	}

	@PutMapping(path="/{id}", consumes="application/json")
	public Destination updateDestination(@PathVariable("id") int destinationId, @RequestBody Destination destination) {
		destination.setDId(destinationId);
		return destinationRepo.save(destination);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteDestination(@PathVariable("id") int destinationId) {
		try {
			destinationRepo.deleteById(destinationId);
		} catch(EmptyResultDataAccessException e) {}
	}
}
