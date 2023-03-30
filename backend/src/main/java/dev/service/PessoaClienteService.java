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

    @Autowired
    private EmailService emailService;
    

    public Pessoa registrar(PessoaClienteRequestDTO pessoaClienteRequestDTO){
        Pessoa pessoa = new PessoaClienteRequestDTO().converter(pessoaClienteRequestDTO);
        pessoa.setDataCriacao(new Date());
        Pessoa pessoaNova =  pessoaClienteRepository.save(pessoa);
        permissaoPessoaService.vincularPessoaPermissaoCliente(pessoaNova);
  
        try {
            emailService.enviarEmail(pessoaNova.getEmail(), "Cadastra na LoJa ", "O registro"+
            "na loja foi realizado com sucesso. Em breve vc receberá sua Senha de acesso!");
            return pessoaNova;
        } catch (Exception e) {
            System.out.println("\n\n\nErro -> "+e.getMessage());
            return null;
        }
  
    }





}
