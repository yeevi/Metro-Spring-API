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

import com.ivy.projects.sybyl.Metro.model.Status;
import com.ivy.projects.sybyl.Metro.repository.StatusRepository;

@RestController
@RequestMapping(path="/status", produces="application/json")
@CrossOrigin(origins="*")
public class StatusController {

	private final StatusRepository statusRepo;

	public StatusController(StatusRepository statusRepo) {
		this.statusRepo = statusRepo;
	}

	@GetMapping
	public Iterable<Status> allStatus() {
		return statusRepo.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Status> statusById(@PathVariable("id") int id) {
		Optional<Status> optStatus = statusRepo.findById(id);
		if(optStatus.isPresent()) {
			return new ResponseEntity<>(optStatus.get(), HttpStatus.OK);
		}

		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Status createProduct(@RequestBody Status status) {
		//Set object's timestamp field/s such as 'dateSaved' using `LocalDateTime.now()` as an example.

		Status savedStatus= statusRepo.save(status); 
		return savedStatus;
	}

	@PutMapping(path="/{id}", consumes="application/json")
	public Status updateStatus(@PathVariable("id") int statusId, @RequestBody Status status) {
		status.setStatusId(statusId);
		return statusRepo.save(status);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteStatus(@PathVariable("id") int statusId) {
		try {
			statusRepo.deleteById(statusId);
		} catch(EmptyResultDataAccessException e) {}
	}
}
