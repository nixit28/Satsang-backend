package com.satsang.webapps.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nixit on 9/19/15.
 */

@Entity
@Table(name = "Track", schema = "", catalog = "satsang")
public class Track {

    private Integer idTrack;
    private String trackName;
    private String trackUrl;
    private List<Playlist> playlist;
    private List<Category> category;


    @Id
    @Column(name = "id_track")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdTrack() {
        return idTrack;
    }

    public void setIdTrack(Integer idTrack) {
        this.idTrack = idTrack;
    }

    @Basic
    @Column(name = "trackName", unique = true)
    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    @Basic
    @Column(name = "trackUrl", unique = true)
    public String getTrackUrl() {
        return trackUrl;
    }

    public void setTrackUrl(String trackUrl) {
        this.trackUrl = trackUrl;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Playlist_Track", joinColumns = { @JoinColumn(name = "id_track") },
            inverseJoinColumns = { @JoinColumn(name = "id_playlist") })
    public List<Playlist> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<Playlist> playlist) {
        this.playlist = playlist;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Track_Category", joinColumns = { @JoinColumn(name = "id_track") },
            inverseJoinColumns = { @JoinColumn(name = "id_category") })
    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

}
