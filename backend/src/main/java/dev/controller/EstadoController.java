package dev.controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.entity.Estado;
import dev.service.EstadoSerivce;

@RestController
@RequestMapping("/api/estado")
public class EstadoController {

    @Autowired
    private EstadoSerivce estadoSerivce;

    @GetMapping("/")
    @CrossOrigin("http://localhost:3001")
    public List<Estado> listarTodos() {

        return estadoSerivce.listarTodos();

    }

    @PostMapping("/")
    @CrossOrigin("http://localhost:3001")
    public Estado inserir( @RequestBody Estado estado) {
        return estadoSerivce.inserir(estado);
    }

    @PutMapping("/")
    @CrossOrigin("http://localhost:3001")
    public Estado alterar(@RequestBody Estado estado) {

        return estadoSerivce.alterar(estado);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin("http://localhost:3001")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        estadoSerivce.excluir(id);
        return ResponseEntity.ok().build();
    }
}
