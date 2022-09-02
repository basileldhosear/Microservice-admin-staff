package com.meetup.staffservice.controller;

import com.meetup.staffservice.entity.Staff;
import com.meetup.staffservice.service.StaffService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StaffService staffService;

    private static final String BASE_URL
            = "http://localhost:8081/";

    private static final String STAFF_SERVICE = "staff";

    int count=1;

    @PostMapping("/add")
    public Staff saveStaff(@RequestBody Staff staff){

        return staffService.saveStaff(staff);
    }

    @GetMapping("/list")
    //@CircuitBreaker(name = STAFF_SERVICE, fallbackMethod = "staffFallback")
    @Retry(name = STAFF_SERVICE)
    public String ListStaff(){

        String url = BASE_URL + "admin";
        System.out.println("Retry method called " + count++ + " times at " + new Date());
        return restTemplate.getForObject(
                url,
                String.class
        );
    }

    public String staffFallback(Exception e){

        return "fallback method of staff service";
    }


    @GetMapping("/{id}")
    public Staff getStaff(@PathVariable int id){
        return staffService.getStaff(id);
    }


}
