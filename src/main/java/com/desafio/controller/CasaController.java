package com.desafio.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.entidades.Casa;
import com.desafio.repository.CasaRepository;



@RestController
@RequestMapping("/casa")

public class CasaController {
	
	@Autowired
	private CasaRepository repo;	

	
	@GetMapping
	public ResponseEntity<Iterable<Casa>> listarItens() {
		Iterable<Casa> itens = repo.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(itens);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Casa> listarItemPorID(@PathVariable("id") Long id) {
		Optional <Casa> item = repo.findById(id);
		return item.isPresent()? ResponseEntity.ok(item.get()):ResponseEntity.notFound().build();
	
	}
	
	@PostMapping
	public ResponseEntity<Casa> salvarItem(@RequestBody Casa item) {
			Casa itemSalvo = repo.save(item);
		return ResponseEntity.status(HttpStatus.CREATED).body(itemSalvo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Casa> alterarItem(@PathVariable("id") Long id, @RequestBody Casa item) {
		Optional <Casa> buscarItem = repo.findById(id);
		if(buscarItem.isPresent()) {
			item.setId(id);
			repo.save(item);
			return ResponseEntity.ok(item);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Casa> deletar(@PathVariable("id") Long id) {
		Optional <Casa> buscarItem = repo.findById(id);
		if(buscarItem.isPresent()) {
			repo.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	
}
