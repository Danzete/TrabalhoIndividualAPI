package org.serratec.trabalho.controller;

import java.util.List;
import java.util.Optional;

import org.serratec.trabalho.modelos.Funcionario;
import org.serratec.trabalho.repository.FuncionarioRepository;
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

import jakarta.validation.Valid;

@RestController  
@RequestMapping("/funcionarios")  
public class FuncionarioController {

    @Autowired 
    private FuncionarioRepository funcionarioRepository;

    // GET 
    @GetMapping
    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();  
    }
	// GET por ID
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        
        if (funcionario.isPresent()) {
            return ResponseEntity.ok(funcionario.get());  // Retorna OK 
        } else {
            return ResponseEntity.notFound().build();  // Retorna 404 Not Found
        }
    }

    // POST 
    @PostMapping
    public ResponseEntity<Funcionario> criar(@Valid @RequestBody Funcionario funcionario) {
        Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioSalvo);  // Retorna 201 Created
    }

    // PUT 
    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @Valid @RequestBody Funcionario funcionarioAtualizado) {
        Optional<Funcionario> funcionarioExistente = funcionarioRepository.findById(id);
        
        if (funcionarioExistente.isPresent()) {
            Funcionario funcionario = funcionarioExistente.get();
            funcionario.setNome(funcionarioAtualizado.getNome());
            funcionario.setEndereco(funcionarioAtualizado.getEndereco());
            
            Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);
            return ResponseEntity.ok(funcionarioSalvo);  
        } else {
            return ResponseEntity.notFound().build();  
        }
    }

    // DELETE 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        
        if (funcionario.isPresent()) {
            funcionarioRepository.delete(funcionario.get());
            return ResponseEntity.noContent().build();  
        } else {
            return ResponseEntity.notFound().build();  
        }
    }
}