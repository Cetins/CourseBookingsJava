package com.courseBooking.repositories;

import com.courseBooking.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByRating(Integer rating);
    List<Course> findByBookingsCustomerNameIgnoreCase(String name);
}
