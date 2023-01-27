package com.example.attornatus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.attornatus.model.Endereco;
import com.example.attornatus.repositories.Repository.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    public Endereco criarEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Iterable<Endereco> listarEndereco() {
        return enderecoRepository.findAll();

    }

}
