package com.danmarkmodmadspild.webapp.service;


import com.danmarkmodmadspild.webapp.model.AboutText;
import com.danmarkmodmadspild.webapp.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {
    @Autowired
    HomeRepository homeRepository;

    public AboutText getAboutText() {

        return homeRepository.getAboutText();


    }

}
