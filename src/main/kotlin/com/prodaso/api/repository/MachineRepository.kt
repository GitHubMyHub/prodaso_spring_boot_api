package com.prodaso.api.repository

import com.prodaso.api.entity.Machine
import org.springframework.data.jpa.repository.JpaRepository

interface MachineRepository : JpaRepository<Machine, Int> {
}