package dev.controller;

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

import dev.entity.Permissao;
import dev.service.PermissaoService;


@RestController
@RequestMapping("/api/permissao")
public class PermissaoController {
        
    @Autowired
    private PermissaoService permissaoService;

    @GetMapping("/")
    public List<Permissao> buscarTodos(){
       return permissaoService.buscarTodos();
    }

    @PostMapping("/")
    public Permissao inserir(@RequestBody Permissao objeto){
        return permissaoService.inserir(objeto);
    }

    @PutMapping("/")
    public Permissao alterar(@RequestBody Permissao objeto){
        return permissaoService.alterar(objeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        permissaoService.excluir(id);
        return ResponseEntity.ok().build();
    }

    // @Autowired
    // private PermissaoController permissaoController;

    // @GetMapping("/")
    // public List<Permissao> listarTodos() {

    //     return permissaoController.listarTodos();

    // }

    // @PostMapping("/")
    // public Permissao inserir( @RequestBody Permissao objeto) {
    //     return permissaoController.inserir(objeto);
    // }

    // @PutMapping("/")
    // public Permissao alterar(@RequestBody Permissao objeto) {

    //     return permissaoController.alterar(objeto);
    // }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> excluir(@PathVariable Long id) {
    //     permissaoController.excluir(id);
    //     return ResponseEntity.ok().build();
    // }
}
