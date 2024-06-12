package com.example.demo.repository;

import com.example.demo.model.Registro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RegistroRepository {
    private final List<Registro> registros = new ArrayList<>();
    private int currentId = 1;

    public Registro save(Registro registro) {
        registro.setId(String.valueOf(currentId++));
        registros.add(registro);
        return registro;
    }

    public Optional<Registro> findById(String id) {
        return registros.stream().filter(r -> r.getId().equals(id)).findFirst();
    }

    public List<Registro> findAll() {
        return new ArrayList<>(registros);
    }

    public Registro update(String id, Registro registro) {
        Optional<Registro> existingRegistro = findById(id);
        if (existingRegistro.isPresent()) {
            Registro r = existingRegistro.get();
            r.setEspecie(registro.getEspecie());
            r.setDataPlantio(registro.getDataPlantio());
            return r;
        }
        return null;
    }

    public boolean delete(String id) {
        return registros.removeIf(r -> r.getId().equals(id));
    }
}
