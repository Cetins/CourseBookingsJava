package com.courseBooking.controllers;

import com.courseBooking.models.Customer;
import com.courseBooking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity getAllCustomersAndFilters(
            @RequestParam(required = false, name = "course") String course,
            @RequestParam(required = false, name = "town") String town,
            @RequestParam(required = false, name = "age") Integer age
    ) {
        if (age != null && town != null && course != null) {
            return new ResponseEntity(customerRepository.findByAgeGreaterThanAndTownIgnoreCaseAndBookingsCourseNameIgnoreCase(age, town, course), HttpStatus.OK);
        }

        if (town != null && course != null) {
            List<Customer> foundCustomers = customerRepository.findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(town, course);
            return new ResponseEntity(foundCustomers, HttpStatus.OK);
        }
        
        if (course != null) {
            return new ResponseEntity(customerRepository.findByBookingsCourseNameIgnoreCase(course), HttpStatus.OK);
        }

        return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable Long id) {
        return new ResponseEntity(customerRepository.findById(id), HttpStatus.OK);
    }
}
