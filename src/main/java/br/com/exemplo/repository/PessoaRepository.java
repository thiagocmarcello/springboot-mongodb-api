package br.com.exemplo.repository;

import br.com.exemplo.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by thiago on 10/01/16.
 */
@Repository
public class PessoaRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Pessoa addPessoa(Pessoa pessoa) {
        mongoTemplate.save(pessoa);
        return  pessoa;
    }

    public Pessoa findById(int id) {
        Pessoa pessoa = mongoTemplate.findById(id, Pessoa.class);
        return pessoa;
    }

    public List<Pessoa> findAll() {
        List<Pessoa> pessoas = mongoTemplate.findAll(Pessoa.class);
        return pessoas;
    }
}
