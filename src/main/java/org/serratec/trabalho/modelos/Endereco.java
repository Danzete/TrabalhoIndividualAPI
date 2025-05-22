package org.serratec.trabalho.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity  // essa classe será uma tabela no banco de dados
public class Endereco {

    @Id  // chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // O banco vai gerar automaticamente o ID
    private Long id;

    @NotBlank(message = "Atributo obrigatório")  
    private String rua;

    @NotBlank(message = "Atributo obrigatório")  
    private String cidade;

    @NotBlank(message = "Atributo obrigatório")  
    @Size(min = 2, max = 2, message = "O estado deve ter 2 caracteres") // 2 caracteres
    private String estado;

    @NotBlank(message = "Atributo obrigatório")  
    private String cep;

    public Endereco() {
    }

    public Endereco(String rua, String cidade, String estado, String cep) {
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
    

  
    

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}