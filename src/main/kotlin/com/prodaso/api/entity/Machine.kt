package com.prodaso.api.entity

import javax.persistence.*

@Entity
@Table(name = "machine")
class Machine(name: String, status: Int) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0
    var name: String = ""
    var status: Int? = null

    init {
        this.name = name
        this.status = status
    }

}