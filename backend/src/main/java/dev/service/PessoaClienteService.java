package dev.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
  
        // try {
        //     emailService.enviarEmail(pessoaNova.getEmail(), "Cadastra na LoJa: Teste Aldo ", "O registro "+
        //     "na loja foi realizado com sucesso. Em breve vc receberá sua Senha de acesso!");
        //     return pessoaNova;
        // } catch (Exception e) {
        //     System.out.println("\n\n\nErro -> "+e.getMessage());
        //     return null;
        // }

        Map<String, Object> propriedades = new HashMap<>();
        propriedades.put("nome", pessoaNova.getNome());
        propriedades.put("mensagem", "Email cadastrado na Loja Teste");
            emailService.enviarEmailTemplate(pessoaNova.getEmail(), "Cadastro na Loja TESTE",propriedades );
            return pessoaNova;
    } 





}
