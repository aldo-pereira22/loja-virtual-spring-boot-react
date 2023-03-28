package dev.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import dev.entity.Pessoa;
import dev.repository.PessoaRepository;


@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoaRepository;


    public List<Pessoa> listarTodos(){  

        return pessoaRepository.findAll();
    }


    public Pessoa inserir(Pessoa objeto){

        Pessoa pessoaNova =  pessoaRepository.save(objeto);
       return pessoaNova;
    }


    public Pessoa alterar(Pessoa objeto){
        objeto.setDataAtualizacao(new Date());
        return pessoaRepository.saveAndFlush(objeto);
    }

    public void excluir(Long id){
        Pessoa pessoa = pessoaRepository.findById(id).get();
        pessoaRepository.delete(pessoa);
    }
}
