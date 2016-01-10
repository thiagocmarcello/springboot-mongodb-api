package br.com.exemplo.controller;

import br.com.exemplo.model.Pessoa;
import br.com.exemplo.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by thiago on 10/01/16.
 */
@Controller
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @RequestMapping("pessoa")
    @ResponseBody
    public String home() {
        return "Hello World!";
    }

    @RequestMapping(value="/pessoa/add", method= RequestMethod.POST)
    public @ResponseBody Pessoa addPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.addPessoa(pessoa);
    }

    @RequestMapping("/pessoa/findById/{pessoaId}")
    public @ResponseBody Pessoa findPersonById(@PathVariable("pessoaId") int pessoaId) {
        return pessoaService.findById(pessoaId);
    }

    @RequestMapping("/pessoa/all")
    public @ResponseBody List findAll() {
        return pessoaService.findAll();
    }
}
