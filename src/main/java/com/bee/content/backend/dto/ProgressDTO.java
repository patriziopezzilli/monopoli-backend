package com.bee.content.backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProgressDTO {

    private String title;
    private Integer value;
    private Integer activeProgress;
    private String description;

    public ProgressDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getActiveProgress() {
        return activeProgress;
    }

    public void setActiveProgress(Integer activeProgress) {
        this.activeProgress = activeProgress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
