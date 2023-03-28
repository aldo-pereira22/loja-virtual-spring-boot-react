package dev.controller;

import java.util.Date;
import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.entity.Categoria;
import dev.entity.Marca;
import dev.service.CategoriaService;
import dev.service.MarcaService;

@RestController
@RequestMapping("/api/marca")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping("/")
    public List<Marca> listarTodos() {

        return marcaService.listarTodos();

    }

    @PostMapping("/")
    public Marca inserir( @RequestBody Marca objeto) {
        objeto.setDataCriacao(new Date());
        return marcaService.inserir(objeto);
    }

    @PutMapping("/")
    public Marca alterar(@RequestBody Marca objeto) {
        objeto.setDataAtualizacao(new Date());
        return marcaService.alterar(objeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        marcaService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
