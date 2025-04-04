package org.luciarodriguez.rocktownclimbingapp.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellidos;
    private String rol;
    private String dni;
    private String direccion;
    private String nombreUsuario;
    private String email;
    private String contrasenaHash;
    @OneToMany(mappedBy = "empleado")
    private List<Actividad> actividades = new ArrayList<>();
}
