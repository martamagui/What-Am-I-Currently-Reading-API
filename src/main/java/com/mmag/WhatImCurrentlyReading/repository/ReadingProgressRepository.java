package com.mmag.WhatImCurrentlyReading.repository;

import com.mmag.WhatImCurrentlyReading.entity.ReadingProgress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadingProgressRepository extends JpaRepository<ReadingProgress, Long> {
}
