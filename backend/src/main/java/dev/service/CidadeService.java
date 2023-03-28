package dev.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.entity.Cidade;

import dev.repository.CidadeRepository;


@Service
public class CidadeService {
    
    @Autowired
    private CidadeRepository cidadeRepository;


    public List<Cidade> listarTodos(){  

        return cidadeRepository.findAll();
    }


    public Cidade inserir(Cidade cidade){

       Cidade cidadeNova =  cidadeRepository.save(cidade);
       return cidadeNova;
    }


    public Cidade alterar(Cidade cidade){
        cidade.setDataAtualizacao(new Date());
        return cidadeRepository.saveAndFlush(cidade);
    }

    public void excluir(Long id){
        Cidade estado = cidadeRepository.findById(id).get();
        cidadeRepository.delete(estado);
    }
}
