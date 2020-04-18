package com.bee.content.backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChatMessageMessageRequestDTO {

    private String author;
    private String message;

    public ChatMessageMessageRequestDTO() {

    }

    public ChatMessageMessageRequestDTO(String author, String date, String message) {
        this.author = author;
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
