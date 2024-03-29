package com.bee.content.backend.database.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "menu_del_giorno")
public class MenuDelGiorno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;

    private String nome;

    private String prezzo;

    private String categoria;

    private String merchant;

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public MenuDelGiorno() {
    }

    public MenuDelGiorno(String nome, String prezzo, String categoria, String merchant) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.categoria = categoria;
        this.merchant = merchant;
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

    public String getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(String prezzo) {
        this.prezzo = prezzo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuDelGiorno menu = (MenuDelGiorno) o;
        return Objects.equals(id, menu.id) &&
                Objects.equals(nome, menu.nome) &&
                Objects.equals(prezzo, menu.prezzo) &&
                Objects.equals(categoria, menu.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, prezzo, categoria);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Menu{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", prezzo='").append(prezzo).append('\'');
        sb.append(", categoria='").append(categoria).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
