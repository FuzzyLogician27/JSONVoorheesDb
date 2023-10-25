package com.sparta.jsonvoorhees.springapi.model.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("embedded_movies")
public class EmbeddedMovie {

  @Id
  private String id;
  private long awards_Nominations;
  private String awards_Text;
  private long awards_Wins;
  private String cast;
  private String countries;
  private String directors;
  private String fullplot;
  private String genres;
  private String imdb;
  private long imdb_Id;
  private double imdb_Rating;
  private long imdb_Votes;
  private String languages;
  private String lastupdated;
  private long numMflixComments;
  private String plot;
  private String plotEmbedding;
  private String rated;
  private java.util.Date released;
  private long runtime;
  private String title;
  private String tomatoes;
  private String tomatoes_Critic;
  private long tomatoes_Critic_Meter;
  private long tomatoes_Critic_NumReviews;
  private double tomatoes_Critic_Rating;
  private java.util.Date tomatoes_Dvd;
  private long tomatoes_Fresh;
  private java.util.Date tomatoes_LastUpdated;
  private String tomatoes_Production;
  private long tomatoes_Rotten;
  private String tomatoes_Viewer;
  private long tomatoes_Viewer_Meter;
  private long tomatoes_Viewer_NumReviews;
  private double tomatoes_Viewer_Rating;
  private String type;
  private String writers;
  private long year;
  private String awards;
  private String poster;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public long getAwards_Nominations() {
    return awards_Nominations;
  }

  public void setAwards_Nominations(long awards_Nominations) {
    this.awards_Nominations = awards_Nominations;
  }


  public String getAwards_Text() {
    return awards_Text;
  }

  public void setAwards_Text(String awards_Text) {
    this.awards_Text = awards_Text;
  }


  public long getAwards_Wins() {
    return awards_Wins;
  }

  public void setAwards_Wins(long awards_Wins) {
    this.awards_Wins = awards_Wins;
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


  public String getImdb() {
    return imdb;
  }

  public void setImdb(String imdb) {
    this.imdb = imdb;
  }


  public long getImdb_Id() {
    return imdb_Id;
  }

  public void setImdb_Id(long imdb_Id) {
    this.imdb_Id = imdb_Id;
  }


  public double getImdb_Rating() {
    return imdb_Rating;
  }

  public void setImdb_Rating(double imdb_Rating) {
    this.imdb_Rating = imdb_Rating;
  }


  public long getImdb_Votes() {
    return imdb_Votes;
  }

  public void setImdb_Votes(long imdb_Votes) {
    this.imdb_Votes = imdb_Votes;
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


  public String getPlotEmbedding() {
    return plotEmbedding;
  }

  public void setPlotEmbedding(String plotEmbedding) {
    this.plotEmbedding = plotEmbedding;
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


  public String getTomatoes() {
    return tomatoes;
  }

  public void setTomatoes(String tomatoes) {
    this.tomatoes = tomatoes;
  }


  public String getTomatoes_Critic() {
    return tomatoes_Critic;
  }

  public void setTomatoes_Critic(String tomatoes_Critic) {
    this.tomatoes_Critic = tomatoes_Critic;
  }


  public long getTomatoes_Critic_Meter() {
    return tomatoes_Critic_Meter;
  }

  public void setTomatoes_Critic_Meter(long tomatoes_Critic_Meter) {
    this.tomatoes_Critic_Meter = tomatoes_Critic_Meter;
  }


  public long getTomatoes_Critic_NumReviews() {
    return tomatoes_Critic_NumReviews;
  }

  public void setTomatoes_Critic_NumReviews(long tomatoes_Critic_NumReviews) {
    this.tomatoes_Critic_NumReviews = tomatoes_Critic_NumReviews;
  }


  public double getTomatoes_Critic_Rating() {
    return tomatoes_Critic_Rating;
  }

  public void setTomatoes_Critic_Rating(double tomatoes_Critic_Rating) {
    this.tomatoes_Critic_Rating = tomatoes_Critic_Rating;
  }


  public java.util.Date getTomatoes_Dvd() {
    return tomatoes_Dvd;
  }

  public void setTomatoes_Dvd(java.util.Date tomatoes_Dvd) {
    this.tomatoes_Dvd = tomatoes_Dvd;
  }


  public long getTomatoes_Fresh() {
    return tomatoes_Fresh;
  }

  public void setTomatoes_Fresh(long tomatoes_Fresh) {
    this.tomatoes_Fresh = tomatoes_Fresh;
  }


  public java.util.Date getTomatoes_LastUpdated() {
    return tomatoes_LastUpdated;
  }

  public void setTomatoes_LastUpdated(java.util.Date tomatoes_LastUpdated) {
    this.tomatoes_LastUpdated = tomatoes_LastUpdated;
  }


  public String getTomatoes_Production() {
    return tomatoes_Production;
  }

  public void setTomatoes_Production(String tomatoes_Production) {
    this.tomatoes_Production = tomatoes_Production;
  }


  public long getTomatoes_Rotten() {
    return tomatoes_Rotten;
  }

  public void setTomatoes_Rotten(long tomatoes_Rotten) {
    this.tomatoes_Rotten = tomatoes_Rotten;
  }


  public String getTomatoes_Viewer() {
    return tomatoes_Viewer;
  }

  public void setTomatoes_Viewer(String tomatoes_Viewer) {
    this.tomatoes_Viewer = tomatoes_Viewer;
  }


  public long getTomatoes_Viewer_Meter() {
    return tomatoes_Viewer_Meter;
  }

  public void setTomatoes_Viewer_Meter(long tomatoes_Viewer_Meter) {
    this.tomatoes_Viewer_Meter = tomatoes_Viewer_Meter;
  }


  public long getTomatoes_Viewer_NumReviews() {
    return tomatoes_Viewer_NumReviews;
  }

  public void setTomatoes_Viewer_NumReviews(long tomatoes_Viewer_NumReviews) {
    this.tomatoes_Viewer_NumReviews = tomatoes_Viewer_NumReviews;
  }


  public double getTomatoes_Viewer_Rating() {
    return tomatoes_Viewer_Rating;
  }

  public void setTomatoes_Viewer_Rating(double tomatoes_Viewer_Rating) {
    this.tomatoes_Viewer_Rating = tomatoes_Viewer_Rating;
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


  public long getYear() {
    return year;
  }

  public void setYear(long year) {
    this.year = year;
  }


  public String getAwards() {
    return awards;
  }

  public void setAwards(String awards) {
    this.awards = awards;
  }


  public String getPoster() {
    return poster;
  }

  public void setPoster(String poster) {
    this.poster = poster;
  }

}
