package com.cognizant.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.service.LendingService;
import com.cognizant.service.UserService;
import com.cognizant.utils.LendingObject;
import com.cognizant.utils.LendingStatus;
import com.cognizant.entity.Lending;
import com.cognizant.entity.User;

@RestController
@RequestMapping("/lendings")
public class LendingController {
    private final LendingService lendingService;
    private final UserService userService;

    @Autowired
    public LendingController(LendingService lendingService, UserService userService) {
        this.lendingService = lendingService;
        this.userService = userService;
    }

    @GetMapping("/")
    public List<Lending> getLendings() {
        return lendingService.getLendings();
    }

    @PostMapping("/")
    public Lending createLending(@RequestBody LendingObject lendingObject) throws Exception {
        Lending newLending = lendingService.createLending(lendingObject);
        return newLending;
    }

    @GetMapping("/{username}")
    public List<Lending> getLendingsOfUser(@PathVariable("username") String username) throws Exception {
        User existingUser = userService.getUser(username);
        if (existingUser == null)
            throw new Exception("User doesn't exist!");
        else {
            return lendingService.getLendingsOfUser(existingUser);
        }
    }

    @PatchMapping("/{lendingId}/accept")
    public Lending acceptLending(@PathVariable("lendingId") Long lendingId, @RequestHeader Map<String, String> header)
            throws Exception {
        String username = header.get("username");
        if (username == null)
            throw new Exception("Username not provided!");
        else {
            User existingUser = userService.getUser(username);
            System.out.println(existingUser.toString());
            if (existingUser == null || !existingUser.getRole().equals("admin"))
                throw new Exception("Access not authorized!");
            else {
                return lendingService.updateLendingStatus(lendingId, LendingStatus.ACCEPTED);
            }
        }
    }

    @PatchMapping("/{lendingId}/reject")
    public Lending rejectLending(@PathVariable("lendingId") Long lendingId, @RequestHeader Map<String, String> header)
            throws Exception {
        String username = header.get("username");
        if (username == null)
            throw new Exception("Username not provided!");
        else {
            User existingUser = userService.getUser(username);
            System.out.println(existingUser.toString());
            if (existingUser == null || !existingUser.getRole().equals("admin"))
                throw new Exception("Access not authorized!");
            else {
                return lendingService.updateLendingStatus(lendingId, LendingStatus.REJECTED);
            }
        }
    }
}
