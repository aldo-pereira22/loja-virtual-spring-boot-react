package dev.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.entity.Categoria;
import dev.entity.Cidade;
import dev.repository.CategoriaRepository;
import dev.repository.CidadeRepository;


@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;


    public List<Categoria> listarTodos(){  

        return categoriaRepository.findAll();
    }


    public Categoria inserir(Categoria objeto){

       Categoria categoriaNova =  categoriaRepository.save(objeto);
       return categoriaNova;
    }


    public Categoria alterar(Categoria objeto){
        objeto.setDataAtualizacao(new Date());
        return categoriaRepository.saveAndFlush(objeto);
    }

    public void excluir(Long id){
        Categoria categoria = categoriaRepository.findById(id).get();
        categoriaRepository.delete(categoria);
    }
}
