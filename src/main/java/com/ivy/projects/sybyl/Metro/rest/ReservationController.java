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

import com.ivy.projects.sybyl.Metro.model.Reservation;
import com.ivy.projects.sybyl.Metro.repository.ReservationRepository;

@RestController
@RequestMapping(path="/reservation", produces="application/json")
@CrossOrigin(origins="*")
public class ReservationController {

	private final ReservationRepository reservationRepo;

	public ReservationController(ReservationRepository reservationRepo) {
		this.reservationRepo = reservationRepo;
	}

	@GetMapping
	public Iterable<Reservation> allReservation() {
		return reservationRepo.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Reservation> reservationById(@PathVariable("id") int id) {
		Optional<Reservation> optReservation = reservationRepo.findById(id);
		if(optReservation.isPresent()) {
			return new ResponseEntity<>(optReservation.get(), HttpStatus.OK);
		}

		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Reservation createProduct(@RequestBody Reservation reservation) {
		//Set object's timestamp field/s such as 'dateSaved' using `LocalDateTime.now()` as an example.

		Reservation savedReservation= reservationRepo.save(reservation); 
		return savedReservation;
	}

	@PutMapping(path="/{id}", consumes="application/json")
	public Reservation updateReservation(@PathVariable("id") int reservationId, @RequestBody Reservation reservation) {
		reservation.setResId(reservationId);
		return reservationRepo.save(reservation);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteReservation(@PathVariable("id") int reservationId) {
		try {
			reservationRepo.deleteById(reservationId);
		} catch(EmptyResultDataAccessException e) {}
	}
}
