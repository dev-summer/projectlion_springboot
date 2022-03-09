package com.example.mission3.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="area")
public class AreaEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String state;
    private String city;
    private String district;
    private double latitude; //위도
    private double longitude; //경도

    public AreaEntity() {
    }

    public AreaEntity(Long id, String state, String city, String district, double latitude, double longitude) {
        this.id = id;
        this.state = state;
        this.city = city;
        this.district = district;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "AreaEntity{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
