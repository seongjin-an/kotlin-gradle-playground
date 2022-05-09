package com.ansj.prac.domain

import javax.persistence.*

@Entity
@Table(name = "TBL_TEST")
data class TestEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    var id: Int? = null,
    @Column(name = "TEXT")
    var text: String
)