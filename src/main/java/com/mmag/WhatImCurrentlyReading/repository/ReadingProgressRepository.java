package com.mmag.WhatImCurrentlyReading.repository;

import com.mmag.WhatImCurrentlyReading.entity.ReadingProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingProgressRepository extends JpaRepository<ReadingProgress, Long> {
}
