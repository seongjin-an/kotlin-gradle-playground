package com.ansj.prac.repository

import com.ansj.prac.domain.TestEntity
import com.ansj.prac.dto.TestDto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TestRepository: JpaRepository<TestEntity, Int> {
}