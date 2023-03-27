package dev.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.entity.Estado;
import dev.repository.EstadoRepository;

@Service
public class EstadoSerivce {
    
    @Autowired
    private EstadoRepository estadoRepository;


    public List<Estado> listarTodos(){  

        return estadoRepository.findAll();
    }


    public Estado inserir(Estado estado){
        estado.setDataCriacao(new Date());
       Estado estadodNovo =  estadoRepository.save(estado);
       return estadodNovo;
    }


    public Estado alterar(Estado estado){
        estado.setDataAtualizacao(new Date());
        return estadoRepository.saveAndFlush(estado);
    }

    public void excluir(Long id){
        Estado estado = estadoRepository.findById(id).get();
        estadoRepository.delete(estado);
    }
}
