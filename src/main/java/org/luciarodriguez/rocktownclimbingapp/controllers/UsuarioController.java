package org.luciarodriguez.rocktownclimbingapp.controllers;

import org.luciarodriguez.rocktownclimbingapp.models.Usuario;
import org.luciarodriguez.rocktownclimbingapp.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private final UsuarioService service;
    public UsuarioController(UsuarioService service) { this.service = service; }

    @GetMapping
    public List<Usuario> getAll() { return service.findAll(); }

    @PostMapping
    public Usuario save(@RequestBody Usuario usuario) {
        return service.save(usuario); }
}
