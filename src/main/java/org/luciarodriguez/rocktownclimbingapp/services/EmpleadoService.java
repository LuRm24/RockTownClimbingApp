package org.luciarodriguez.rocktownclimbingapp.services;

import org.luciarodriguez.rocktownclimbingapp.models.Empleado;
import org.luciarodriguez.rocktownclimbingapp.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {
    private final EmpleadoRepository repo;

    @Autowired
    public EmpleadoService(EmpleadoRepository repo) {
        this.repo = repo;
    }

    public Empleado findByNombreUsuario(String nombreUsuario) {
        return repo.findByNombreUsuario(nombreUsuario);
    }

    public List<Empleado> findAll() {
        return repo.findAll();
    }
    public Empleado save(Empleado a) {
        return repo.save(a);
    }
}
