package dev.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.dto.PessoaClienteRequestDTO;
import dev.entity.Pessoa;
import dev.repository.PessoaClienteRepository;
import dev.repository.PessoaRepository;


@Service
public class PessoaGerenciamentoService {
    
    @Autowired
    private PessoaRepository pessoaRepository;


    @Autowired
    private EmailService emailService;
    

    public String solicitarCodigo(String email){

        Pessoa pessoa = pessoaRepository.findByEmail(email);
        pessoa.setCodigoRecuperacaoSenha(getCodigoRecuperacaoSenha(pessoa.getId()));
        pessoa.setDataEnvioCodigo(new Date());
        pessoaRepository.saveAndFlush(pessoa);

       emailService.enviarEmail(pessoa.getEmail(), "Código de recuperação de senha;",
       "Olá, seu código para recuperação de senha é: "+ pessoa.getCodigoRecuperacaoSenha());
        return "Código enviado!";
  
    } 


    private String getCodigoRecuperacaoSenha(Long id){
        DateFormat format = new SimpleDateFormat("ddMMaayyyyHHmmssmm");
        return format.format(new Date())+id;
    }





}
