package com.mmag.WhatImCurrentlyReading.repository;

import com.mmag.WhatImCurrentlyReading.entity.Saga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SagaRepository extends JpaRepository<Saga, Long> {
}
