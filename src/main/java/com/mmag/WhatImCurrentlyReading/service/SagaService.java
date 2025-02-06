package com.mmag.WhatImCurrentlyReading.service;

import com.mmag.WhatImCurrentlyReading.entity.Saga;
import com.mmag.WhatImCurrentlyReading.repository.SagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SagaService {

    @Autowired
    SagaRepository sagaRepository;

    //region Get
    public List<Saga> getSagas() {
        return sagaRepository.findAll();
    }

    public List<Saga> getSagaByName(String name) {
        Saga saga = new Saga();
        saga.setName(name);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatcher::ignoreCase)
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Saga> sagaExample = Example.of(saga, matcher);
        return sagaRepository.findAll(sagaExample);

    }
    //endregion Get

    //region Post
    public void saveOrUpdateSaga(Saga saga) {
        sagaRepository.save(saga);
    }
    //endregion Post

    //region Delete
    public void deleteSagaById(Long id) {
        sagaRepository.deleteById(id);
    }
    //endregion Delete
}
