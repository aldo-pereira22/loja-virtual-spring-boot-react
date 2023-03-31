package dev.service;



import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.entity.Permissao;
import dev.entity.PermissaoPessoa;
import dev.entity.Pessoa;
import dev.repository.PermissaoPessoaRepository;
import dev.repository.PermissaoRepository;


@Service
public class PermissaoPessoaService {
    
    @Autowired
    private PermissaoPessoaRepository permissaoPessoaRepository;

    @Autowired
    private PermissaoRepository permissaoRepository;

    

    public void vincularPessoaPermissaoCliente(Pessoa pessoa){

        List<Permissao> listaPermissao = permissaoRepository.findByNome("Cliente");    

        if(listaPermissao.size() > 0 ){ 
            PermissaoPessoa permissaoPessoa = new PermissaoPessoa();
            permissaoPessoa.setPessoa(pessoa);
            permissaoPessoa.setPermissao(listaPermissao.get(0));
            permissaoPessoa.setDataCriacao(new Date());
            permissaoPessoaRepository.saveAndFlush(permissaoPessoa);
        }
    
    }


}
