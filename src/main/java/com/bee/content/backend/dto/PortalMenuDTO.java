package com.bee.content.backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PortalMenuDTO implements Serializable {

    private String title;
    private String link;
    private String icon;
    private List<PortalMenuDTO> children;

    public PortalMenuDTO(String title, String link, String icon) {
        this.title = title;
        this.link = link;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<PortalMenuDTO> getChildren() {
        return children;
    }

    public void setChildren(List<PortalMenuDTO> children) {
        this.children = children;
    }
}
