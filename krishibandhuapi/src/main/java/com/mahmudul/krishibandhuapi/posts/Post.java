package com.mahmudul.krishibandhuapi.posts;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Post {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String heading;
  private String tags;
  private String description;

  @CreationTimestamp
  private LocalDateTime dateTime;

  public Post(String heading, String tags, String description) {
    this.heading = heading;
    this.tags = tags;
    this.description = description;
  }

}
