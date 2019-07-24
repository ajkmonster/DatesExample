package com.example.demo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=3)
    private String title;


    @Temporal(TemporalType.DATE)
    private Date postedDate;

    private String formattedPostedDate;
    @NotNull
    private String description;

    public Task() {
    }

    public String getFormattedPostedDate() {
        return formattedPostedDate;
    }

    public void setFormattedPostedDate(String formattedPostedDate) {
        this.formattedPostedDate = formattedPostedDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
