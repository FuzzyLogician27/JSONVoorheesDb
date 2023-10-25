package com.sparta.jsonvoorhees.springapi.model.entities;

import com.sparta.jsonvoorhees.springapi.model.entities.embeddedObjects.Awards;
import com.sparta.jsonvoorhees.springapi.model.entities.embeddedObjects.Imdb;
import com.sparta.jsonvoorhees.springapi.model.entities.embeddedObjects.Tomatoes;
import com.sparta.jsonvoorhees.springapi.model.entities.embeddedObjects.TomatoesReview;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document("movies")
public class Movie {

  @Id
  private String id;
  private Awards awards;
  private String cast;
  private String countries;
  private String directors;
  private String fullplot;
  private String genres;
  private Imdb imdb;
  private String languages;
  private String lastupdated;
  @Field("num_mflix_comments")
  private long numMflixComments;
  private String plot;
  private String poster;
  private String rated;
  private java.util.Date released;
  private long runtime;
  private String title;
  private Tomatoes tomatoes;
  private String type;
  private String writers;
  private String year;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public Awards getAwards() {
    return awards;
  }

  public void setAwards(Awards awards) {
    this.awards = awards;
  }

  public Tomatoes getTomatoes() {
    return tomatoes;
  }

  public void setTomatoes(Tomatoes tomatoes) {
    this.tomatoes = tomatoes;
  }

  public String getCast() {
    return cast;
  }

  public void setCast(String cast) {
    this.cast = cast;
  }


  public String getCountries() {
    return countries;
  }

  public void setCountries(String countries) {
    this.countries = countries;
  }


  public String getDirectors() {
    return directors;
  }

  public void setDirectors(String directors) {
    this.directors = directors;
  }


  public String getFullplot() {
    return fullplot;
  }

  public void setFullplot(String fullplot) {
    this.fullplot = fullplot;
  }


  public String getGenres() {
    return genres;
  }

  public void setGenres(String genres) {
    this.genres = genres;
  }


  public Imdb getImdb() {
    return imdb;
  }

  public void setImdb(Imdb imdb) {
    this.imdb = imdb;
  }

  public String getLanguages() {
    return languages;
  }

  public void setLanguages(String languages) {
    this.languages = languages;
  }


  public String getLastupdated() {
    return lastupdated;
  }

  public void setLastupdated(String lastupdated) {
    this.lastupdated = lastupdated;
  }


  public long getNumMflixComments() {
    return numMflixComments;
  }

  public void setNumMflixComments(long numMflixComments) {
    this.numMflixComments = numMflixComments;
  }


  public String getPlot() {
    return plot;
  }

  public void setPlot(String plot) {
    this.plot = plot;
  }


  public String getPoster() {
    return poster;
  }

  public void setPoster(String poster) {
    this.poster = poster;
  }


  public String getRated() {
    return rated;
  }

  public void setRated(String rated) {
    this.rated = rated;
  }


  public java.util.Date getReleased() {
    return released;
  }

  public void setReleased(java.util.Date released) {
    this.released = released;
  }


  public long getRuntime() {
    return runtime;
  }

  public void setRuntime(long runtime) {
    this.runtime = runtime;
  }
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public String getWriters() {
    return writers;
  }

  public void setWriters(String writers) {
    this.writers = writers;
  }


  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }
}
