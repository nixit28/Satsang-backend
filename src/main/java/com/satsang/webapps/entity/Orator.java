package com.satsang.webapps.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by nixit on 12/17/14.
 */
@Entity
@Table(name = "Orator", schema = "", catalog = "Satsang")
public class Orator implements Serializable {
    private Integer idOrator;
    @NotEmpty(message = "Name of the orator can not be empty")
    private String name;
    private String imageUrl;
    private String nickName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orator")
    public Integer getIdOrator() {
        return idOrator;
    }

    public void setIdOrator(Integer idOrator) {
        this.idOrator = idOrator;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Basic
    @Column(name = "nick_name")
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orator that = (Orator) o;

        if (idOrator != that.idOrator) return false;
        if (imageUrl != null ? !imageUrl.equals(that.imageUrl) : that.imageUrl != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (nickName != null ? !nickName.equals(that.nickName) : that.nickName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOrator != null ? idOrator : 34;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        return result;
    }
}
