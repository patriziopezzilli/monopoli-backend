package com.bee.content.backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Lob;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PromotionDTO {

    private Long id;
    private String name;
    private String content;
    private String extraInfo;
    private String format; //image, text
    private String type; //modal, popover, etc..
    private String merchant;

    public PromotionDTO() {
    }

    public PromotionDTO(Long id, String format, String name, String content, String extraInfo, String type, String merchant) {
        this.id = id;
        this.format = format;
        this.name = name;
        this.content = content;
        this.extraInfo = extraInfo;
        this.type = type;
        this.merchant = merchant;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
