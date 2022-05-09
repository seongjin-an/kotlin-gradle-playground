package com.ansj.prac.repository

import com.ansj.prac.domain.TestEntity
import com.ansj.prac.dto.TestDto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TestRepository: JpaRepository<TestEntity, Int> {
//    @Query("""
//        SELECT new com.ansj.prac.dto.TestDto(to_char(T.id), T.text)
//        FROM TestEntity T
//    """)
//    fun testProjection(): List<TestDto>
}