package org.luciarodriguez.rocktownclimbingapp.repositories;

import org.luciarodriguez.rocktownclimbingapp.models.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    Empleado findByNombreUsuario(String nombreUsuario);

}
