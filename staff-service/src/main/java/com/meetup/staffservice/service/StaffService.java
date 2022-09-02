package com.meetup.staffservice.service;

import com.meetup.staffservice.entity.Staff;
import com.meetup.staffservice.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;
    public Staff saveStaff(Staff staff){

        return staffRepository.save(staff);
    }


    public List<Staff> getStaff(int id) {

        return staffRepository.findById()
    }

    public List<MenuDto> getAllMenuLikeName(String menuName) {
        return menuRepository.findMenuByFoodName(menuName).stream()
                .map(MenuHelper::mapToDto)
                .collect(Collectors.toList());
    }
}
