package com.example.attornatus.controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.attornatus.model.Pessoa;
import com.example.attornatus.repositories.Repository.PessoaRepository;
import com.example.attornatus.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaContoller {

	@Autowired
	PessoaService pessoaService;

	@Autowired
	PessoaRepository pessoaRepository;

	@PostMapping
	public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa) {
		pessoa = pessoaService.criarPessoa(pessoa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(pessoa.getId()).toUri();
		return ResponseEntity.created(uri).body(pessoa);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Pessoa> editarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
		pessoa = pessoaService.editarPessoa(id, pessoa);
		return ResponseEntity.ok().body(pessoa);
	}

	@GetMapping
	public ResponseEntity<List<Pessoa>> listarPessoa() {
		List<Pessoa> list = pessoaService.listarPessoa();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Pessoa> consultarPessoa(@PathVariable Long id) {
		Pessoa obj = pessoaService.consultarPessoa(id);
		return ResponseEntity.ok().body(obj);
	}

}
