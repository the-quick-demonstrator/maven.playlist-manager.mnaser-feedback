package com.github.curriculeon;


//import com.sun.tools.javac.platform.PlatformUtils;

//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlaylistManager {
    private Playlist playlist = new Playlist();
    public PlaylistManager(String[] songs) {
        playlist = new Playlist(songs);
        this.songs = new ArrayList<>(Arrays.asList(songs));
    }

    public PlaylistManager(List<String> songs) {
      playlist = new Playlist(songs.toArray(new String[0]));

    }

    public PlaylistManager() {

    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        if(playlist == null){
            throw new IllegalArgumentException();
        }
        this.playlist = playlist;
    }

    private void setPlaylist(String[] toArray) {
        this.playlist = new Playlist(toArray);
    }

    public void addSong(String songToAdd) {

        int songLength = this.playlist.getSongNameArrayList().length;
        if(songLength == 0){
            this.playlist.setSongNameArrayList(new String[]{songToAdd});
        }else{
            String[]updatedSongs = new String[songLength];
            for(int i=0; i< updatedSongs.length; i++){
                updatedSongs[i] = this.playlist.getSongNameArrayList()[i];
                System.out.println(this.playlist.getSongNameArrayList()[i]);
            }
            updatedSongs[updatedSongs.length-1] = songToAdd;
            this.playlist.setSongNameArrayList(updatedSongs);
        }


    }

    public void removeSong(String songToRemove) {
        if(this.playlist.getSongNameArrayList().length ==0 ){
            throw new IllegalArgumentException();
        }
        List<String>songs = new ArrayList<>(Arrays.asList(this.playlist.getSongNameArrayList()));
        songs.remove(songToRemove);
        this.playlist.setSongNameArrayList(songs.toArray(new String[0]));
    }

    public void printAll() {
    }
}
