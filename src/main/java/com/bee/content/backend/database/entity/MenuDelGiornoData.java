package com.bee.content.backend.database.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "menu_del_giorno_data")
public class MenuDelGiornoData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;

    private String valore;

    private String merchant;

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public MenuDelGiornoData() {
    }

    public MenuDelGiornoData(String valore, String prezzo, String categoria) {
        this.valore = valore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValore() {
        return valore;
    }

    public void setValore(String nome) {
        this.valore = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuDelGiornoData menu = (MenuDelGiornoData) o;
        return Objects.equals(id, menu.id) &&
                Objects.equals(valore, menu.valore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valore);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Menu{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(valore).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
