package org.luciarodriguez.rocktownclimbingapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
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

    @OneToMany(mappedBy = "empleado")
    private List<Recordatorio> recordatorios = new ArrayList<>();

    public String getContrasenaHash() {
        return contrasenaHash;
    }
}
