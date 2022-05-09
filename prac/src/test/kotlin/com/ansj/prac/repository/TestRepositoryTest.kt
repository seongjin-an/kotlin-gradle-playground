package com.ansj.prac.repository

import com.ansj.prac.domain.TestEntity
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TestRepositoryTest {
    @Autowired
    private lateinit var testRepository: TestRepository

//    @Test
//    fun test(){
//        val result = testRepository.testProjection()
//        result.forEach { println(it) }
//    }
    @Test
    fun createTest(){
        val test = TestEntity(id = null, text = "ansj")
        val result = testRepository.save(test)
        println(result)
    }
}