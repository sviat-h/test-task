package com.programmerstasken.analytical_tool.entity;

import java.time.LocalDate;

public class TimeLine extends Request {

    private LocalDate date;
    private int time;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeLine)) return false;
        if (!super.equals(o)) return false;

        TimeLine timeLine = (TimeLine) o;

        if (getTime() != timeLine.getTime()) return false;
        return getDate() != null ? getDate().equals(timeLine.getDate()) : timeLine.getDate() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + getTime();
        return result;
    }
}
