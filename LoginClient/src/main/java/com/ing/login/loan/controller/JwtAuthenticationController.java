package com.ing.login.loan.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ing.login.loan.exception.AccessDenaiedException;
import com.ing.login.loan.model.AuthenticationRequest;
import com.ing.login.loan.model.AuthenticationResponse;
import com.ing.login.loan.model.Loan;
import com.ing.login.loan.service.MyUserDetailsService;
import com.ing.login.loan.util.JwtUtil;


@RestController
public class JwtAuthenticationController {
	
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;
	Logger logger=LoggerFactory.getLogger(this.getClass());
	

	@Autowired
	private MyUserDetailsService userDetailsService;

	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello ing";
	}
 
	
	//getting loanbyborrowername
	@GetMapping("/getLoanByBorrowerName/{bName}")
	public List<Loan> getByBorrowerName(@PathVariable String bName){
		logger.info("entry");
		logger.info("exit");
		return this.getByBorrowerName(bName);
	}
	
	//for getting all lones
	@GetMapping("/loans")
	public List<Loan> getAllLoans(){
		logger.info("entry");
	logger.info("exit");
	return this.getAllLoans();
	
	}
	
	//for updation
	@PutMapping("/admin/update")
	public Loan updateLoanSearch(@RequestBody Loan loan) {
		logger.info("update loan entry");
		if(this.checkAuthorization()) {
			logger.info("user controller exit");
			return this.updateLoanSearch(loan);
		}
		else {
			logger.error("AccesDeniedException");
			throw new AccessDenaiedException(null, null);
			
		}
	}
	
	
	private boolean checkAuthorization() {
		logger.info("user controller entry");
		boolean status=false;
		return status;
		
		
	}

 
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}


	
	}
