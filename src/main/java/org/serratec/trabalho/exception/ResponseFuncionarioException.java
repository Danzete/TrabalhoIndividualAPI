package org.serratec.trabalho.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ResponseFuncionarioException {
    private Integer status;
    private String titulo;
    private LocalDateTime dateTime;
    private List<String> errors;

    public ResponseFuncionarioException(Integer status, String titulo, LocalDateTime dateTime, List<String> errors) {
        this.status = status;
        this.titulo = titulo;
        this.dateTime = dateTime;
        this.errors = errors;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}