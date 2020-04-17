package com.bee.content.backend.database.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "visite_sito")
public class Visite {

    @Id
    private Long id;

    private String visita;

    private String merchant;

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public Visite() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVisita() {
        return visita;
    }

    public void setVisita(String visita) {
        this.visita = visita;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visite visite = (Visite) o;
        return Objects.equals(id, visite.id) &&
                Objects.equals(visita, visite.visita);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, visita);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Visite{");
        sb.append("id=").append(id);
        sb.append(", visita='").append(visita).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
