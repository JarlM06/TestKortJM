package com.example.testkortjm;

import java.util.List;

public class Kortstokk {
    private Integer id;
    private List<Kort> kortstokk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Kort> getKortstokk() {
        return kortstokk;
    }

    public void setKortstokk(List<Kort> kortstokk) {
        this.kortstokk = kortstokk;
    }
}
