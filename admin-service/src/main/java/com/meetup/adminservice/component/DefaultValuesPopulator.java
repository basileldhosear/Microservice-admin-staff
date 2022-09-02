package com.meetup.adminservice.component;


import com.meetup.adminservice.entity.Admin;
import com.meetup.adminservice.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DefaultValuesPopulator {

    @Autowired
    private final AdminRepository adminRepository;


    @EventListener(ApplicationReadyEvent.class)
    public void afterStartup() {

        adminRepository.save(new Admin(1,"basil","basil"));


    }
}
