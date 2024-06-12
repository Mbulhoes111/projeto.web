package com.example.demo.controller;

import com.example.demo.model.Registro;
import com.example.demo.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/registros")
public class RegistroController {

    @Autowired
    private RegistroService registroService;

    @PostMapping
    public ResponseEntity<Registro> create(@RequestBody Registro registro) {
        return ResponseEntity.ok(registroService.save(registro));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Registro> getById(@PathVariable String id) {
        Optional<Registro> registro = registroService.findById(id);
        return registro.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Registro>> getAll() {
        return ResponseEntity.ok(registroService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Registro> update(@PathVariable String id, @RequestBody Registro registro) {
        Registro updatedRegistro = registroService.update(id, registro);
        return updatedRegistro != null ? ResponseEntity.ok(updatedRegistro) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return registroService.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
