package com.sparta.jsonvoorhees.springapi.model.entities.embeddedObjects;

public class Awards {
    private long nominations;
    private String text;
    private long wins;

    public long getNominations() {
        return nominations;
    }

    public void setNominations(long nominations) {
        this.nominations = nominations;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getWins() {
        return wins;
    }

    public void setWins(long wins) {
        this.wins = wins;
    }

    @Override
    public String toString() {
        return "Awards{" +
                "nominations=" + nominations +
                ", text='" + text + '\'' +
                ", wins=" + wins +
                '}';
    }
}
