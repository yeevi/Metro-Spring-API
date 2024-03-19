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

import com.ivy.projects.sybyl.Metro.model.Route;
import com.ivy.projects.sybyl.Metro.repository.RouteRepository;

@RestController
@RequestMapping(path="/route", produces="application/json")
@CrossOrigin(origins="*")
public class RouteController {

	private final RouteRepository routeRepo;

	public RouteController(RouteRepository routeRepo) {
		this.routeRepo = routeRepo;
	}

	@GetMapping
	public Iterable<Route> allRoute() {
		return routeRepo.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Route> routeById(@PathVariable("id") int id) {
		Optional<Route> optRoute = routeRepo.findById(id);
		if(optRoute.isPresent()) {
			return new ResponseEntity<>(optRoute.get(), HttpStatus.OK);
		}

		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Route createProduct(@RequestBody Route route) {
		//Set object's timestamp field/s such as 'dateSaved' using `LocalDateTime.now()` as an example.

		Route savedRoute= routeRepo.save(route); 
		return savedRoute;
	}

	@PutMapping(path="/{id}", consumes="application/json")
	public Route updateRoute(@PathVariable("id") int routeId, @RequestBody Route route) {
		route.setRId(routeId);
		return routeRepo.save(route);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteRoute(@PathVariable("id") int routeId) {
		try {
			routeRepo.deleteById(routeId);
		} catch(EmptyResultDataAccessException e) {}
	}
}
