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

import com.ivy.projects.sybyl.Metro.model.RouteData;
import com.ivy.projects.sybyl.Metro.repository.RouteDataRepository;

@RestController
@RequestMapping(path="/routedata", produces="application/json")
@CrossOrigin(origins="*")
public class RouteDataController {

	private final RouteDataRepository routedataRepo;

	public RouteDataController(RouteDataRepository routedataRepo) {
		this.routedataRepo = routedataRepo;
	}

	@GetMapping
	public Iterable<RouteData> allRouteData() {
		return routedataRepo.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<RouteData> routedataById(@PathVariable("id") int id) {
		Optional<RouteData> optRouteData = routedataRepo.findById(id);
		if(optRouteData.isPresent()) {
			return new ResponseEntity<>(optRouteData.get(), HttpStatus.OK);
		}

		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public RouteData createProduct(@RequestBody RouteData routedata) {
		//Set object's timestamp field/s such as 'dateSaved' using `LocalDateTime.now()` as an example.

		RouteData savedRouteData= routedataRepo.save(routedata); 
		return savedRouteData;
	}

	@PutMapping(path="/{id}", consumes="application/json")
	public RouteData updateRouteData(@PathVariable("id") int routedataId, @RequestBody RouteData routedata) {
		routedata.setRdId(routedataId);
		return routedataRepo.save(routedata);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteRouteData(@PathVariable("id") int routedataId) {
		try {
			routedataRepo.deleteById(routedataId);
		} catch(EmptyResultDataAccessException e) {}
	}
}
