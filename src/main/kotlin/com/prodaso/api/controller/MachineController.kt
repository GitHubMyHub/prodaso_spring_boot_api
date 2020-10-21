package com.prodaso.api.controller

import com.prodaso.api.entity.Machine
import com.prodaso.api.repository.MachineRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
class MachineController {

    @Autowired
    val machineRepository: MachineRepository? = null

    @CrossOrigin
    @RequestMapping(
            method = [RequestMethod.POST],
            path = ["/addMachine"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun addMachine(@RequestBody body: Machine): Machine {

        machineRepository!!.save(body)

        return body
    }

    @CrossOrigin
    @RequestMapping(
            method = [RequestMethod.GET],
            path = ["/machines"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )

    fun getMachines(): List<Machine> {

        val machinesList: List<Machine> = machineRepository?.findAll() ?: emptyList()

        return machinesList
    }

    @CrossOrigin
    @RequestMapping(
            method = [RequestMethod.PUT],
            path = ["/machines/{id}"],
            produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateMachine(@PathVariable id: Int, @RequestBody body: Machine): Machine? {

        val machine: Machine? = machineRepository?.findById(id)?.get()
        machine?.name = body.name
        machine?.status = body.status

        machineRepository?.save(machine!!)

        return machine
    }

    @CrossOrigin
    @RequestMapping(
            method = [RequestMethod.DELETE],
            path = ["/machine/{id}"]
    )
    fun deleteMachine(@PathVariable id: Int) {

        machineRepository?.deleteById(id)

    }

}