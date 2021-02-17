package com.challenge.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.demo.dto.SiteDTO;
import com.challenge.demo.usecase.SiteUsecase;

@RestController
@RequestMapping("/sites")
public class SiteController {


	@Autowired
	SiteUsecase siteUsecase;
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public  ResponseEntity<SiteDTO>  createSite(@RequestBody SiteDTO createSite)  {
		
		try {
			return new ResponseEntity<SiteDTO>(siteUsecase.createSite(createSite), HttpStatus.CREATED);
		}  catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping()
	public ResponseEntity<List<SiteDTO>> getSites() {
		try {
			return new ResponseEntity<>(siteUsecase.getSites(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<SiteDTO> updateSite(@RequestBody SiteDTO updatedSite, @PathVariable(value = "id") Long siteId) {
		try {
			return new ResponseEntity<>(siteUsecase.updateSite(updatedSite, siteId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<SiteDTO> deleteSite(@PathVariable(value = "id") Long siteId) {
		try {
			return new ResponseEntity<>(siteUsecase.deleteSite(siteId), HttpStatus.OK);
		}  catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<SiteDTO> getSiteById(@PathVariable(value = "id") Long siteId) {
		try {
			return new ResponseEntity<>(siteUsecase.getSiteById(siteId), HttpStatus.OK);
		}  catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}


}
