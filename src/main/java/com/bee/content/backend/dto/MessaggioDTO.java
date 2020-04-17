package com.bee.content.backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessaggioDTO {

    private Long id;

    private String nome;

    private String mail;

    private String messaggio;

    private Integer risposto;

    public MessaggioDTO(Long id, String nome, String mail, String messaggio, Integer risposto) {
        this.id = id;
        this.nome = nome;
        this.mail = mail;
        this.messaggio = messaggio;
        this.risposto = risposto;
    }

    public MessaggioDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }

    public Integer getRisposto() {
        return risposto;
    }

    public void setRisposto(Integer risposto) {
        this.risposto = risposto;
    }
}
