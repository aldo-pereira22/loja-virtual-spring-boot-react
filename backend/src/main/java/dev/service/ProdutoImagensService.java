package dev.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import dev.entity.Produto;
import dev.entity.ProdutoImagens;
import dev.repository.ProdutoImagensRepository;
import dev.repository.ProdutoRepository;


@Service
public class ProdutoImagensService {
    
    @Autowired
    private ProdutoImagensRepository produtoImagensRepository;
    @Autowired
    private ProdutoRepository produtoRepository;


    public List<ProdutoImagens> listarTodos(){  

        return produtoImagensRepository.findAll();
    }


    public ProdutoImagens inserir(Long idProduto, MultipartFile file){

        Produto produto = produtoRepository.findById(idProduto).get();
        ProdutoImagens objeto = new ProdutoImagens();

        System.out.println("FILEE" + file);

        try {

            if(!file.isEmpty()){
                byte[] bytes = file.getBytes();
                String  nomeImagem = String.valueOf(produto.getId() +file.getOriginalFilename());
                Path caminho = Paths
                .get("/home/aldo/projetos/imagens/"+nomeImagem);
                Files.write(caminho, bytes);
                objeto.setNome(nomeImagem);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        objeto.setProduto(produto);
        objeto.setDataCriacao(new Date());
        objeto  =  produtoImagensRepository.save(objeto);
       return objeto;
    }


    public ProdutoImagens alterar(ProdutoImagens objeto){
        objeto.setDataAtualizacao(new Date());
        return produtoImagensRepository.saveAndFlush(objeto);
    }

    public void excluir(Long id){
        ProdutoImagens produtoImagem = produtoImagensRepository.findById(id).get();
        produtoImagensRepository.delete(produtoImagem);
    }
}
