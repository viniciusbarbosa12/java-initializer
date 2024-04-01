package com.application.application.Params.Times;

public class TimesParams {
    private Long Id;
    private String timeAmPm;

    public TimesParams(String timeAmPm) {
        this.timeAmPm = timeAmPm;
    }

    public TimesParams() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTimeAmPm() {
        return timeAmPm;
    }

    public void setTimeAmPm(String timeAmPm) {
        this.timeAmPm = timeAmPm;
    }
}
