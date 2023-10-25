package com.sparta.jsonvoorhees.springapi.model.entities.embeddedObjects;

import java.util.Date;

public class Tomatoes {
    private TomatoesReview critic;
    private java.util.Date dvd;
    private String fresh;
    private java.util.Date lastUpdated;
    private String production;
    private String rotten;
    private TomatoesReview viewer;
    private String website;


    public TomatoesReview getCritic() {
        return critic;
    }

    public void setCritic(TomatoesReview critic) {
        this.critic = critic;
    }

    public Date getDvd() {
        return dvd;
    }

    public void setDvd(Date dvd) {
        this.dvd = dvd;
    }

    public String getFresh() {
        return fresh;
    }

    public void setFresh(String fresh) {
        this.fresh = fresh;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getRotten() {
        return rotten;
    }

    public void setRotten(String rotten) {
        this.rotten = rotten;
    }

    public TomatoesReview getViewer() {
        return viewer;
    }

    public void setViewer(TomatoesReview viewer) {
        this.viewer = viewer;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "Tomatoes{" +
                "critic=" + critic +
                ", dvd=" + dvd +
                ", fresh=" + fresh +
                ", lastUpdated=" + lastUpdated +
                ", production='" + production + '\'' +
                ", rotten=" + rotten +
                ", viewer=" + viewer +
                ", website='" + website + '\'' +
                '}';
    }
}
