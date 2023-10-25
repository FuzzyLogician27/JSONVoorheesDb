package com.sparta.jsonvoorhees.springapi.model.entities.embeddedObjects;

public class Imdb {
    private long id;
    private String rating;
    private String votes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getVotes() {
        return votes;
    }

    public void setVotes(String votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "Imdb{" +
                "id=" + id +
                ", rating=" + rating +
                ", votes=" + votes +
                '}';
    }
}
