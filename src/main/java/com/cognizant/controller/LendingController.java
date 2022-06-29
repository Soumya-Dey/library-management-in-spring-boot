package com.cognizant.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.service.LendingService;
import com.cognizant.utils.LendingObject;
import com.cognizant.entity.Lending;

@RestController
@RequestMapping("/lendings")
public class LendingController {
    private final LendingService lendingService;

    @Autowired
    public LendingController(LendingService lendingService) {
        this.lendingService = lendingService;
    }

    @GetMapping("/")
    public List<Lending> getLendings() {
        return lendingService.getLendings();
    }

    @PostMapping("/")
    public Lending createLending(@RequestBody LendingObject lendingObject) throws Exception {
        Lending newLending = lendingService.createLending(lendingObject);
        System.out.println(newLending.toString());
        return newLending;
    }
}
