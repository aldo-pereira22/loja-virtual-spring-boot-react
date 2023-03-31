package dev.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import dev.entity.Pessoa;

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
        System.out.println("Ccodigo de validação: " +pessoa.getCodigoRecuperacaoSenha());

       emailService.enviarEmail(pessoa.getEmail(), "Código de recuperação de senha;",
       "Olá, seu código para recuperação de senha é: "+ pessoa.getCodigoRecuperacaoSenha());
        return "Código enviado!: "+pessoa.getCodigoRecuperacaoSenha();
  
    }  


    public String alterarSenha(Pessoa pessoa){
        Pessoa pessoaBanco = pessoaRepository.findByEmailAndCodigoRecuperacaoSenha(pessoa.getEmail(),pessoa.getCodigoRecuperacaoSenha());

        Date dataAtual = new Date();
        // Date ddd = pessoaBanco.getDataEnvioCodigo();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nDATA: "+pessoaBanco.getDataEnvioCodigo());
        Long diferenca = dataAtual.getTime() - pessoaBanco.getDataEnvioCodigo().getTime();
        // Date diferenca = new Date(new Date().getTime() - pessoaBanco.getDataEnvioCodigo().getTime());

   
        if( (diferenca / 1000) < 900 ){

            pessoaBanco.setSenha(pessoa.getSenha());
            pessoaBanco.setCodigoRecuperacaoSenha(null);
            pessoaRepository.saveAndFlush(pessoaBanco);
            return "Senha alterada com sucesso!";
        }else {
            return "Tempo expirado!";
        }

    }
    private String getCodigoRecuperacaoSenha(Long id){
        DateFormat format = new SimpleDateFormat("ddMMaayyyyHHmmssmm");
        return format.format(new Date())+id;
    }





}
