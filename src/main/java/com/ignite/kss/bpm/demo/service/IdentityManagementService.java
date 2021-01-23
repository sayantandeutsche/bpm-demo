package com.ignite.kss.bpm.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.flowable.engine.IdentityService;
import org.flowable.engine.ProcessEngine;
import org.flowable.idm.api.Group;
import org.flowable.idm.api.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ignite.kss.bpm.demo.dto.ManagedGroup;
import com.ignite.kss.bpm.demo.dto.ManagedUser;
import com.ignite.kss.bpm.demo.mapping.MapperUtil;

@Service
public class IdentityManagementService {

    @Autowired
    private ProcessEngine processEngine;

    @Autowired
    private MapperUtil mapperUtil;


    public String createUser(ManagedUser managedUser){
        IdentityService identityService = processEngine.getIdentityService();
        User user = identityService.newUser(managedUser.getUserName());
        user.setEmail(managedUser.getEmail());
        user.setFirstName(managedUser.getFirstName());
        user.setLastName(managedUser.getLastName());
        identityService.saveUser(user);
        identityService.createMembership(managedUser.getUserName(),managedUser.getGroupName());
        return user.getId();

    }

    public String createGroup(ManagedGroup managedGroup){

        IdentityService identityService = processEngine.getIdentityService();
        Group group = identityService.newGroup(managedGroup.getGroupName());
        identityService.saveGroup(group);
        return group.getId();

    }

    public List<ManagedUser> getMembersOfGroup(String groupName){
        IdentityService identityService = processEngine.getIdentityService();
        return  identityService.createUserQuery().memberOfGroup(groupName).list().stream().map(u->mapperUtil.getManagedUserFromUserInfo(u)).collect(Collectors.toList());
    }



}
