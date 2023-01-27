package com.example.attornatus.repositories.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.attornatus.model.Endereco;
import com.example.attornatus.model.Pessoa;

public interface PessoaRepository extends  JpaRepository <Pessoa, Long> {

    

    public Endereco save(Endereco endereco);

    


    
}
