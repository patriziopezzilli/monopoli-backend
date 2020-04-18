package com.bee.content.backend.database.entity;

import javax.persistence.*;

@Entity
@Table(name = "chat_messages")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;

    private String author;
    private String recipient;
    private String message;
    private String merchant;

    public ChatMessage() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String from) {
        this.author = from;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String to) {
        this.recipient = to;
    }

    public String getMessage() {
        return message;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ChatMessage{");
        sb.append("id=").append(id);
        sb.append(", from='").append(author).append('\'');
        sb.append(", to='").append(recipient).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append(", merchant='").append(merchant).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
