package org.serratec.trabalho.exception;

import java.time.LocalDateTime;

public class ErroResposta {
    private LocalDateTime timestamp;
    private String mensagem;
    private String detalhes;

    public ErroResposta(LocalDateTime timestamp, String mensagem, String detalhes) {
        this.timestamp = timestamp;
        this.mensagem = mensagem;
        this.detalhes = detalhes;
    }

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

 
}