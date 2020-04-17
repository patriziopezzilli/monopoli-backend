package com.bee.content.backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuDelGiornoSaveRequest {

    private List<PastoDTO> primi;
    private List<PastoDTO> secondi;
    private List<PastoDTO> pizze;

    public MenuDelGiornoSaveRequest() {
    }

    public List<PastoDTO> getPrimi() {
        return primi;
    }

    public void setPrimi(List<PastoDTO> primi) {
        this.primi = primi;
    }

    public List<PastoDTO> getSecondi() {
        return secondi;
    }

    public void setSecondi(List<PastoDTO> secondi) {
        this.secondi = secondi;
    }

    public List<PastoDTO> getPizze() {
        return pizze;
    }

    public void setPizze(List<PastoDTO> pizze) {
        this.pizze = pizze;
    }
}
