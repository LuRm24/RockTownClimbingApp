package org.luciarodriguez.rocktownclimbingapp.services;

import org.luciarodriguez.rocktownclimbingapp.models.Empleado;
import org.luciarodriguez.rocktownclimbingapp.repositories.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {
    private final EmpleadoRepository repo;
    public EmpleadoService(EmpleadoRepository repo) { this.repo = repo; }
    public List<Empleado> findAll() { return repo.findAll(); }
    public Empleado save(Empleado a) { return repo.save(a); }
}
