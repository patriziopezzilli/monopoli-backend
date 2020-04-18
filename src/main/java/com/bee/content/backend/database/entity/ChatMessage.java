package com.bee.content.backend.database.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "chat_messages")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;

    private String from;
    private String to;
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

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
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
        sb.append(", from='").append(from).append('\'');
        sb.append(", to='").append(to).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append(", merchant='").append(merchant).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
