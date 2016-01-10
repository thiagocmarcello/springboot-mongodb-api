package br.com.exemplo.service;

import br.com.exemplo.model.Pessoa;
import br.com.exemplo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by thiago on 10/01/16.
 */
@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa addPessoa(Pessoa pessoa) {
        return  pessoaRepository.addPessoa(pessoa);
    }

    public Pessoa findById(int id) {
        return pessoaRepository.findById(id);
    }

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }
}
