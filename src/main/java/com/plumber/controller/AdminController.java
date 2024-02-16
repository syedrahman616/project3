package com.plumber.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.http.HttpResponse;
import com.plumber.dao.UserRepository;
import com.plumber.entity.Customer;
import com.plumber.entity.Plumber;
import com.plumber.entity.PlumberUser;
import com.plumber.exception.APIException;
import com.plumber.response.APIResponse;
import com.plumber.security.UserPrincipal;
import com.plumber.service.AdminService;
import com.plumber.utils.ResponseBuilder;

@RestController
public class AdminController {

	@Autowired
	UserRepository usrRepo;

	@Autowired
	AdminService repo;

	@GetMapping("/admin-plumber")
	public ResponseEntity<Object> plumberAdmin() throws APIException {
		UserPrincipal userprincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		Optional<PlumberUser> user = usrRepo.findById(userprincipal.getId());
		if (userprincipal.getId() > 0 && user.get().getUserRole().equalsIgnoreCase("Admin")) {
			List<Plumber> response = repo.plumberAdmin();
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Your Are Not Authorized Person.");
	}

	@GetMapping("/admin-customer")
	public ResponseEntity<Object> customerAdmin() throws APIException {
		UserPrincipal userprincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		Optional<PlumberUser> user = usrRepo.findById(userprincipal.getId());
		if (userprincipal.getId() > 0 && user.get().getUserRole().equalsIgnoreCase("Admin")) {
			List<Customer> response = repo.customerAdmin();
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Your Are Not Authorized Person.");
	}

}
