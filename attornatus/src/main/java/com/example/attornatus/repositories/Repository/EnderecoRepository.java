package com.example.attornatus.repositories.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.attornatus.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query(nativeQuery = true, value = "select * from tb_enderecos where is_principal = true and pessoa_id = (:id)")
    public Optional<Endereco> consultarEnderecoPrincipal(@PathVariable Long id);

    @Query(nativeQuery = true, value = "select * from tb_enderecos where  pessoa_id = (:id)")
    public List<Endereco> consultarEnderecosPessoas(@PathVariable Long id);

}
