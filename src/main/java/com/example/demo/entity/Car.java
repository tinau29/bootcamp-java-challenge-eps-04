package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @Column(name = "brand")
    @JsonProperty("brand")
    private String branch;

    @Column(name = "series")
    @JsonProperty("series")
    private String series;

    @Column(name = "top_speed_kmph")
    @JsonProperty("top_speed_kmph")
    private Integer topSpeedKmph;

    @Column(name = "country")
    @JsonProperty("country")
    private String country;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Integer getTopSpeedKmph() {
        return topSpeedKmph;
    }

    public void setTopSpeedKmph(Integer topSpeedKmph) {
        this.topSpeedKmph = topSpeedKmph;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
