package dev.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.dto.PessoaClienteRequestDTO;
import dev.entity.Pessoa;
import dev.service.PessoaClienteService;


@RestController
@RequestMapping("/api/cliente")
public class PessoaClienteController {

    @Autowired
    private PessoaClienteService pessoaClienteService;



    @PostMapping("/")
    public Pessoa inserir( @RequestBody PessoaClienteRequestDTO pessoaClienteRequestDTO) {
    
        return pessoaClienteService.registrar(pessoaClienteRequestDTO);
    }

}
