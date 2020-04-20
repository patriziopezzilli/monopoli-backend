package com.bee.content.backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChangeRequestDTO {

    private String type; // could be template, plan
    private String previous;
    private String next;
    private Boolean completed;
    private String merchant;

    public ChangeRequestDTO() {

    }

    public ChangeRequestDTO(String type, String previous, String next, Boolean completed, String merchant) {
        this.type = type;
        this.previous = previous;
        this.next = next;
        this.completed = completed;
        this.merchant = merchant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }
}
