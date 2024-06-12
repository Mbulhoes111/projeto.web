package com.example.demo.service;

import com.example.demo.model.Registro;
import com.example.demo.repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroService {

    @Autowired
    private RegistroRepository registroRepository;

    public Registro save(Registro registro) {
        return registroRepository.save(registro);
    }

    public Optional<Registro> findById(String id) {
        return registroRepository.findById(id);
    }

    public List<Registro> findAll() {
        return registroRepository.findAll();
    }

    public Registro update(String id, Registro registro) {
        return registroRepository.update(id, registro);
    }

    public boolean delete(String id) {
        return registroRepository.delete(id);
    }
}
