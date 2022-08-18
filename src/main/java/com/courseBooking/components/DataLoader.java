package com.courseBooking.components;

import com.courseBooking.Star;
import com.courseBooking.models.Booking;
import com.courseBooking.models.Course;
import com.courseBooking.models.Customer;
import com.courseBooking.repositories.BookingRepository;
import com.courseBooking.repositories.CourseRepository;
import com.courseBooking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {
        Course javascript = new Course("JavaScript", "Glasgow", Star.FOUR);
        courseRepository.save(javascript);

        Course python = new Course("Python", "Edinburgh", Star.THREE);
        courseRepository.save(python);

        Course react = new Course("React", "Edinburgh", Star.FIVE);
        courseRepository.save(react);

        Course java = new Course("Java", "Glasgow", Star.FIVE);
        courseRepository.save(java);

        Customer charlie = new Customer("Charlie", "Edinburgh", 35);
        customerRepository.save(charlie);

        Customer sushi = new Customer("Sushi", "Glasgow", 25);
        customerRepository.save(sushi);

        Customer husso = new Customer("Husso", "Glasgow", 40);
        customerRepository.save(husso);

        Booking booking1 = new Booking("25-07-22", java, sushi);
        Booking booking2 = new Booking("14-09-22", python, charlie);

    }
}
