package com.ignite.kss.bpm.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ignite.kss.bpm.demo.dto.ManagedGroup;
import com.ignite.kss.bpm.demo.dto.ManagedUser;
import com.ignite.kss.bpm.demo.service.IdentityManagementService;

@RestController
@RequestMapping("/identity-management")
public class IdentityManagementController {

    @Autowired
    private IdentityManagementService identityManagementService;


    @PostMapping(path = "/createGroup", consumes = "application/json")
    String startCase(@RequestBody ManagedGroup managedGroup) {
        return identityManagementService.createGroup(managedGroup);
    }

    @PostMapping(path = "/createUser", consumes = "application/json")
    String startCase(@RequestBody ManagedUser managedUser) {
        return identityManagementService.createUser(managedUser);
    }

    @GetMapping("/users/groupId/{groupId}")
    List<ManagedUser> listUsersForGroup(@PathVariable String groupId) {
        return identityManagementService.getMembersOfGroup(groupId);
    }

}
