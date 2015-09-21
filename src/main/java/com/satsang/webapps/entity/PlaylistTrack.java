package com.satsang.webapps.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nixit on 9/19/15.
 */
@Entity
@Table(name = "Playlist_Track", schema = "", catalog = "satsang")
public class PlaylistTrack {

    private Integer idPlaylistTrack;

    private Integer idTrack;
    private Integer idPlaylist;

    @Id
    @Column(name = "id_playlist_track")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdPlaylistTrack() {
        return idPlaylistTrack;
    }

    public void setIdPlaylistTrack(Integer idPlaylistTrack) {
        this.idPlaylistTrack = idPlaylistTrack;
    }

    @Column(name = "idTrack")
    public Integer getIdTrack() {
        return idTrack;
    }

    public void setIdTrack(Integer idTrack) {
        this.idTrack = idTrack;
    }

    public Integer getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(Integer idPlaylist) {
        this.idPlaylist = idPlaylist;
    }


}
