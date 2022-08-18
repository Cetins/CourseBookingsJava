package com.courseBooking.repositories;

import com.courseBooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseNameIgnoreCase(String name);
    List<Customer> findByTownIgnoreCaseAndBookingsCourseNameIgnoreCase(String town, String name);
    List<Customer> findByAgeGreaterThanAndTownIgnoreCaseAndBookingsCourseNameIgnoreCase(Integer age, String town, String name);
}