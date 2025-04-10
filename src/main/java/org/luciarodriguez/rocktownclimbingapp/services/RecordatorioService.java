package org.luciarodriguez.rocktownclimbingapp.services;

import org.luciarodriguez.rocktownclimbingapp.models.Recordatorio;
import org.luciarodriguez.rocktownclimbingapp.repositories.RecordatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordatorioService {
    private final RecordatorioRepository repo;

    @Autowired
    public RecordatorioService(RecordatorioRepository repo) {
        this.repo = repo;
    }

    public List<Recordatorio> findAll() {
        return repo.findAll();
    }
    public Recordatorio save(Recordatorio a) {
        return repo.save(a);
    }
}
