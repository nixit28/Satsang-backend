package com.satsang.webapps.entity;

import javax.persistence.*;

/**
 * Created by nixit on 12/17/14.
 */
@Entity
@Table(name = "Granth", schema = "", catalog = "Satsang")
public class Granth {
    private Integer idGranth;
    private String name;

    @Id
    @Column(name = "id_granth")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdGranth() {
        return idGranth;
    }

    public void setIdGranth(Integer idGranth) {
        this.idGranth = idGranth;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Granth that = (Granth) o;

        if (idGranth != that.idGranth) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idGranth;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
