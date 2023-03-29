package dev.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.entity.Produto;
import dev.repository.ProdutoRepository;


@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;


    public List<Produto> listarTodos(){  

        return produtoRepository.findAll();
    }


    public Produto inserir(Produto objeto){

       Produto produtoNovo =  produtoRepository.save(objeto);
       return produtoNovo;
    }


    public Produto alterar(Produto objeto){
        objeto.setDataAtualizacao(new Date());
        return produtoRepository.saveAndFlush(objeto);
    }

    public void excluir(Long id){
        Produto produto = produtoRepository.findById(id).get();
        produtoRepository.delete(produto);
    }
}
