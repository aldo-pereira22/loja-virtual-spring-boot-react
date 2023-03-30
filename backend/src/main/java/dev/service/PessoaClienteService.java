package dev.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.dto.PessoaClienteRequestDTO;
import dev.entity.Pessoa;
import dev.repository.PessoaClienteRepository;


@Service
public class PessoaClienteService {
    
    @Autowired
    private PessoaClienteRepository pessoaClienteRepository;

    @Autowired
    private PermissaoPessoaService permissaoPessoaService;

    public Pessoa registrar(PessoaClienteRequestDTO pessoaClienteRequestDTO){
        Pessoa pessoa = new PessoaClienteRequestDTO().converter(pessoaClienteRequestDTO);
        pessoa.setDataCriacao(new Date());
        Pessoa pessoaNova =  pessoaClienteRepository.save(pessoa);
        permissaoPessoaService.vincularPessoaPermissaoCliente(pessoaNova);
       return pessoaNova;
    }





}
