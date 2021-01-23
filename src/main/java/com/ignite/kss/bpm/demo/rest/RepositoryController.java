package com.ignite.kss.bpm.demo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ignite.kss.bpm.demo.dto.ProcessDetail;
import com.ignite.kss.bpm.demo.service.ProcessRepositoryService;

@RestController
@RequestMapping("/process-engine")
public class RepositoryController {
    private static Logger logger = LoggerFactory.getLogger(RepositoryController.class);

    @Autowired
    private ProcessRepositoryService processRepositoryService;

    @GetMapping("/metadata/process-key/{processKey}")
    ProcessDetail getProcessDetailByKey(@PathVariable String processKey) {
        return processRepositoryService.getProcessDefinitionByKey(processKey);
    }

    @GetMapping("/suspend/process-key/{processKey}")
    Boolean suspendProcessByKey(@PathVariable String processKey) {
        return processRepositoryService.suspendProcessDefinitionByKey(processKey);
    }

    @GetMapping("/activate/process-key/{processKey}")
    Boolean activateProcessByKey(@PathVariable String processKey) {
        return processRepositoryService.activateProcessDefinitionByKey(processKey);
    }


}
