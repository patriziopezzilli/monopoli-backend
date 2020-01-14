package com.ristorantemonopoli.backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VisitorsDTO {

    private Integer count;

    public VisitorsDTO(Integer count) {
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitorsDTO that = (VisitorsDTO) o;
        return Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("VisitorsDTO{");
        sb.append("count=").append(count);
        sb.append('}');
        return sb.toString();
    }
}
