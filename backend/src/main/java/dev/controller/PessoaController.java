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
import dev.entity.Pessoa;
import dev.service.CategoriaService;
import dev.service.PessoaService;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/")
    public List<Pessoa> listarTodos() {

        return pessoaService.listarTodos();

    }

    @PostMapping("/")
    public Pessoa inserir( @RequestBody Pessoa objeto) {
        objeto.setDataCriacao(new Date());
        return pessoaService.inserir(objeto);
    }

    @PutMapping("/")
    public Pessoa alterar(@RequestBody Pessoa objeto) {
        objeto.setDataAtualizacao(new Date());
        return pessoaService.alterar(objeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        pessoaService.excluir(id);
        return ResponseEntity.ok().build();
    }
}