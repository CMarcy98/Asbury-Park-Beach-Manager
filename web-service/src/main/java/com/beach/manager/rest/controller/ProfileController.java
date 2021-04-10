package com.beach.manager.rest.controller;

import com.beach.manager.service.profile.ProfileService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping("/profile")
    public int getProfile() {
        return profileService.getProfile();
    }

}