package com.mahmudul.krishibandhuapi.posts;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String heading;
  private String tags;
  private String description;
  private LocalDateTime dateTime;

  public Post() {}

  public Post(String heading, String tags, String description, LocalDateTime dateTime) {
    this.heading = heading;
    this.tags = tags;
    this.description = description;
    this.dateTime = dateTime;
  }

  public String getHeading() {
    return heading;
  }

  public String getTags() {
    return tags;
  }

  public String getDescription() {
    return description;
  }

  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public void setHeading(String heading) {
    this.heading = heading;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }
}
