package com.satsang.webapps.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nixit on 9/19/15.
 */
@Entity
@Table(name = "Playlist", schema = "", catalog = "satsang")
public class Playlist {

    private Integer idPlaylist;
    @NotEmpty
    private String playlistName;

    private List<Track> tracks;

    @Id
    @Column(name = "id_playlist")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(Integer idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    @Basic
    @Column(name = "playlistName")
    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Playlist_Track", joinColumns = { @JoinColumn(name = "id_playlist") },
            inverseJoinColumns = { @JoinColumn(name = "id_track") })
    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
}
