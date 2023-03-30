package dev.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import dev.entity.Permissao;
import dev.repository.PermissaoRepository;


@Service
public class PermissaoService {
    
    @Autowired
    private PermissaoRepository permissaoRepository;


    public List<Permissao> buscarTodos(){  

        return permissaoRepository.findAll();
    }


    public Permissao inserir(Permissao objeto){
        objeto.setDataCriacao(new Date());
       Permissao permissaoNova =  permissaoRepository.save(objeto);
       return permissaoNova;
    }


    public Permissao alterar(Permissao objeto){
        objeto.setDataAtualizacao(new Date());
        return permissaoRepository.saveAndFlush(objeto);
    }

    public void excluir(Long id){
        Permissao permissao = permissaoRepository.findById(id).get();
        permissaoRepository.delete(permissao);
    }
}
