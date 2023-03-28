package dev.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.entity.Categoria;
import dev.entity.Marca;
import dev.repository.CategoriaRepository;
import dev.repository.MarcaRepository;


@Service
public class MarcaService {
    
    @Autowired
    private MarcaRepository marcaRepository;


    public List<Marca> listarTodos(){  

        return marcaRepository.findAll();
    }


    public Marca inserir(Marca objeto){

    objeto.setDataCriacao(new Date());
       Marca marcaNova =  marcaRepository.save(objeto);

       return marcaNova;
    }


    public Marca alterar(Marca objeto){
        objeto.setDataAtualizacao(new Date());
        return marcaRepository.saveAndFlush(objeto);
    }

    public void excluir(Long id){
        Marca marca = marcaRepository.findById(id).get();
        marcaRepository.delete(marca);
    }
}
