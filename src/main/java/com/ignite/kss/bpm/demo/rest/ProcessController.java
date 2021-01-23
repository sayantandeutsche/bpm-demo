
package com.ignite.kss.bpm.demo.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ignite.kss.bpm.demo.dto.LeaveAppStartCaseParams;
import com.ignite.kss.bpm.demo.dto.OnboardingStartCaseParams;
import com.ignite.kss.bpm.demo.dto.WorkItem;
import com.ignite.kss.bpm.demo.service.ProcessService;

@RestController
@RequestMapping("/process-management")
public class ProcessController {
    private static Logger logger = LoggerFactory.getLogger(ProcessController.class);

    @Autowired
    private ProcessService processService;

    @PostMapping(path = "/startEmployeeOnboarding", consumes = "application/json")
    String startCaseEmployeeOnboarding(@RequestBody OnboardingStartCaseParams onboardingStartCaseParams) {
        return processService.startCaseEmployeeOnboarding(onboardingStartCaseParams.getHr(), onboardingStartCaseParams.getAdmin(), onboardingStartCaseParams.getResourceMgmt(),
                onboardingStartCaseParams.getExecutiveDir());
    }

    @PostMapping(path = "/startLeaveApplication", consumes = "application/json")
    String startCaseLeaveApplication(@RequestBody LeaveAppStartCaseParams leaveAppStartCaseParams) {
        return processService.startCaseLeaveApplication(leaveAppStartCaseParams.getEmployee(),leaveAppStartCaseParams.getManager());
    }

    @GetMapping("/tasklist/{user}")
    List<WorkItem> getAllTasksForUser(@PathVariable String user) {
        return processService.findWorkItemsForUser(user);
    }

    @GetMapping("/tasks/{taskId}/lock/{user}")
    boolean lockWorkItem(@PathVariable String taskId,@PathVariable String user) {
        return processService.lockWorkItem(taskId,user);
    }

    @GetMapping("/tasks/{taskId}/unlock")
    boolean lockWorkItem(@PathVariable String taskId) {
        return processService.unlockWorkItem(taskId);
    }

    @PostMapping("/tasks/update")
    boolean lockWorkItem(@RequestBody WorkItem workItem) {
        boolean result = false;
        try {
            result = processService.updateWorkItem(workItem);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping("/tasks/release")
    boolean releaseWorkItem(@RequestBody WorkItem workItem) {
        boolean result = false;
        try {
            result = processService.releaseWorkItem(workItem);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}

