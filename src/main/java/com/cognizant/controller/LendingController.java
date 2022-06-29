package com.cognizant.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.service.BookService;
import com.cognizant.service.LendingService;
import com.cognizant.service.UserService;
import com.cognizant.utils.LendingObject;
import com.cognizant.entity.Book;
import com.cognizant.entity.Lending;
import com.cognizant.entity.User;

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
