package com.mmag.WhatImCurrentlyReading.controller;

import com.mmag.WhatImCurrentlyReading.entity.Saga;
import com.mmag.WhatImCurrentlyReading.service.SagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/saga")
public class SagaController {

    @Autowired
    SagaService sagaService;

    //region GET
    @RequestMapping
    public List<Saga> getSagas() {
        return sagaService.getSagas();
    }

    @RequestMapping(path = "/name/{authorName}")
    public List<Saga> getSagasByName(String name) {
        return sagaService.getSagaByName(name);
    }
    //endregion GET

    //region POST
    @PostMapping
    public void saveSaga(Saga saga) {
        sagaService.saveOrUpdateSaga(saga);
    }
    //endregion POST

    //region DELETE
    public void deleteSagaById(Long id) {
        sagaService.deleteSagaById(id);
    }
    //endregion DELETE
}
