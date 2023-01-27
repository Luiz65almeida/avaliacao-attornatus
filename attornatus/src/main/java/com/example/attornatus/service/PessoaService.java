package com.example.attornatus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.attornatus.model.Pessoa;
import com.example.attornatus.repositories.Repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public Pessoa criarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa editarPessoa(Long id, Pessoa pesssoa) {
        Pessoa entity = pessoaRepository.getReferenceById(id);
        editarPessoa(entity, pesssoa);
        return pessoaRepository.save(entity);
    }

    private void editarPessoa(Pessoa entity, Pessoa pessoa) {
        entity.setNome(pessoa.getNome());
        entity.setDataNascimento(pessoa.getDataNascimento());
    }

    public Pessoa consultarPessoa(Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);

        return pessoa.get();
    }

    public List<Pessoa> listarPessoa() {
        return pessoaRepository.findAll();
    }

    public void findByisPrincipalAndPessoaId(Long id, Boolean isprincipal) {

    }

}
