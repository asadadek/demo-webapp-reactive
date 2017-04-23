package org.asadadek.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by abhay on 22-04-2017.
 */
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    private Integer id;

    @Column(length = 300)
    @JsonProperty
    private String title;

    @Column
    @JsonProperty
    private LocalDateTime createdDate;

    public Post() {
    }

    public Post(String title){
        this.title = title;
        createdDate = LocalDateTime.now();
    }
}
