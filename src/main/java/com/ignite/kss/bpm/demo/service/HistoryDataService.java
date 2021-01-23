package com.ignite.kss.bpm.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.flowable.engine.HistoryService;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.history.HistoricProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ignite.kss.bpm.demo.dto.ProcessInstanceHistoryData;
import com.ignite.kss.bpm.demo.mapping.MapperUtil;

@Service
public class HistoryDataService {

    @Autowired
    private ProcessEngine processEngine;

    @Autowired
    private MapperUtil mapperUtil;

    public List<ProcessInstanceHistoryData> getCompletedCaseDetails(){
        HistoryService historyService = processEngine.getHistoryService();
        final List<HistoricProcessInstance> historicProcessInstances = historyService.createHistoricProcessInstanceQuery().finished().orderByProcessDefinitionId().asc()
                .includeProcessVariables().list();
        return  historicProcessInstances.stream()
                .map(historicProcessInstance -> mapperUtil.getProcessInstanceHistoryDataFromHistoryInstance(historicProcessInstance))
                .collect(Collectors.toList());


    }


}
