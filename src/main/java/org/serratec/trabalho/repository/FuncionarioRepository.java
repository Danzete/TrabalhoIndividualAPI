package org.serratec.trabalho.repository;

import org.serratec.trabalho.modelos.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    
}