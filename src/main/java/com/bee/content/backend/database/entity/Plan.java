package com.bee.content.backend.database.entity;

import javax.persistence.*;

@Entity
@Table(name = "plan")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;

    private String name;

    private String code;

    private String price_month;

    private Integer price_year;

    public Plan() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPrice_month() {
        return price_month;
    }

    public void setPrice_month(String price_month) {
        this.price_month = price_month;
    }

    public Integer getPrice_year() {
        return price_year;
    }

    public void setPrice_year(Integer price_year) {
        this.price_year = price_year;
    }
}
