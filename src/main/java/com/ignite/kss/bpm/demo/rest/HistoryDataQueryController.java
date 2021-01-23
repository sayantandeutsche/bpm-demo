package com.ignite.kss.bpm.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ignite.kss.bpm.demo.dto.ProcessInstanceHistoryData;
import com.ignite.kss.bpm.demo.service.HistoryDataService;

@RestController
@RequestMapping("/history-search")
public class HistoryDataQueryController {

    @Autowired
    private HistoryDataService historyDataService;

    @GetMapping("/completedProcesses")
    public List<ProcessInstanceHistoryData> getHistoricalProcessData(){
        return historyDataService.getCompletedCaseDetails();
    }

}
