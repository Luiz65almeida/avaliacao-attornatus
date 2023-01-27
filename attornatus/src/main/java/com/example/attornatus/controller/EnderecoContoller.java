package com.example.attornatus.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.attornatus.model.Endereco;
import com.example.attornatus.repositories.Repository.EnderecoRepository;
import com.example.attornatus.service.EnderecoService;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoContoller {

	@Autowired
	EnderecoService enderecoService;

	@Autowired
	EnderecoRepository enderecoRepository;

	@PostMapping()
	public ResponseEntity<Endereco> insert(@RequestBody Endereco endereco){
		endereco = enderecoService.criarEndereco(endereco);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(endereco.getId()).toUri();
		return ResponseEntity.created(uri).body(endereco);
	}

	@GetMapping(value = "/principal/{id}")
	public ResponseEntity<Optional<Endereco>> informarEderecoPrincipal(@PathVariable Long id) {
		Optional<Endereco> endereco = enderecoRepository.consultarEnderecoPrincipal(id);
		return ResponseEntity.ok().body(endereco);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<List<Endereco>> consultarEnderecosPessoas(@PathVariable Long id) {
		List<Endereco> obj = enderecoRepository.consultarEnderecosPessoas(id);
		return ResponseEntity.ok().body(obj);
	}

}