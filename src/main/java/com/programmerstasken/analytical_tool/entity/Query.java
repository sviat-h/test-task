package com.programmerstasken.analytical_tool.entity;

import java.time.LocalDate;

public class Query extends Request {

    private LocalDate dateFrom;
    private LocalDate dateTo;

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Query)) return false;
        if (!super.equals(o)) return false;

        Query query = (Query) o;

        if (getDateFrom() != null ? !getDateFrom().equals(query.getDateFrom()) : query.getDateFrom() != null)
            return false;
        return getDateTo() != null ? getDateTo().equals(query.getDateTo()) : query.getDateTo() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getDateFrom() != null ? getDateFrom().hashCode() : 0);
        result = 31 * result + (getDateTo() != null ? getDateTo().hashCode() : 0);
        return result;
    }
}
