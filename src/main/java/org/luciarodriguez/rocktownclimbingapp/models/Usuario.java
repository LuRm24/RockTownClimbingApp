package org.luciarodriguez.rocktownclimbingapp.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreUsuario;
    private String email;
    private String contrasenaHash;
}
