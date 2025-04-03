package org.luciarodriguez.rocktownclimbingapp.controllers;

import org.luciarodriguez.rocktownclimbingapp.models.Empleado;
import org.luciarodriguez.rocktownclimbingapp.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    @Autowired
    private final EmpleadoService service;
    public EmpleadoController(EmpleadoService service) { this.service = service; }

    @GetMapping
    public List<Empleado> getAll() { return service.findAll(); }

    @PostMapping
    public Empleado save(@RequestBody Empleado empleado) {
        return service.save(empleado); }
}
