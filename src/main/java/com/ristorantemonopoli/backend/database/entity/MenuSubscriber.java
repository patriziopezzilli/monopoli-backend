package com.ristorantemonopoli.backend.database.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "menu_subscriber")
public class MenuSubscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;

    private String email;

    public MenuSubscriber() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String visita) {
        this.email = visita;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuSubscriber visite = (MenuSubscriber) o;
        return Objects.equals(id, visite.id) &&
                Objects.equals(email, visite.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Visite{");
        sb.append("id=").append(id);
        sb.append(", visita='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
