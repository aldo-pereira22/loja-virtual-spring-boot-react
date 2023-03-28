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
import dev.entity.Produto;
import dev.service.CategoriaService;
import dev.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/")
    public List<Produto> listarTodos() {

        return produtoService.listarTodos();

    }

    @PostMapping("/")
    public Produto inserir( @RequestBody Produto objeto) {
        objeto.setDataCriacao(new Date());
        return produtoService.inserir(objeto);
    }

    @PutMapping("/")
    public Produto alterar(@RequestBody Produto objeto) {
        objeto.setDataAtualizacao(new Date());
        return produtoService.alterar(objeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        produtoService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
