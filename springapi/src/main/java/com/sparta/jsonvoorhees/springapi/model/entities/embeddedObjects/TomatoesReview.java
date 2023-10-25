package com.sparta.jsonvoorhees.springapi.model.entities.embeddedObjects;

public class TomatoesReview {
    private String meter;
    private String numReviews;
    private String rating;

    public String getMeter() {
        return meter;
    }

    public void setMeter(String meter) {
        this.meter = meter;
    }

    public String getNumReviews() {
        return numReviews;
    }

    public void setNumReviews(String numReviews) {
        this.numReviews = numReviews;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "TomatoesReview{" +
                "meter=" + meter +
                ", numReviews=" + numReviews +
                ", rating=" + rating +
                '}';
    }
}
