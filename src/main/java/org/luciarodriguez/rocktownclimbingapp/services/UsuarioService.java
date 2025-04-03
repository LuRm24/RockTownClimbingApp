package org.luciarodriguez.rocktownclimbingapp.services;

import org.luciarodriguez.rocktownclimbingapp.models.Usuario;
import org.luciarodriguez.rocktownclimbingapp.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;
    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo; }
    public List<Usuario> findAll() {
        return repo.findAll(); }
    public Optional<Usuario> findById(Long id) {
        return repo.findById(id); }
    public Usuario save(Usuario u) {
        return repo.save(u); }
}
