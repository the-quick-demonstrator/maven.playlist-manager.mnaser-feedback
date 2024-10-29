package com.github.curriculeon.playlistmanager;

import com.github.curriculeon.Playlist;
import com.github.curriculeon.PlaylistManager;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DeleteSongTest {

    @Test
    public void testRemoveSongOnNonEmptyPlaylist() {
        // Given
        String[] songs = {"song1","song2","song3"};
        PlaylistManager manager = new PlaylistManager(songs);
        String songToRemove = "song2";
        // When
        manager.removeSong(songToRemove);
        // Then
        Playlist modifiedPlaylist = manager.getPlaylist();
        assertFalse(Arrays.asList(modifiedPlaylist.getSongNameArrayList()).contains(songToRemove));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveSongOnEmptyPlaylist() {
        // Given
        PlaylistManager manager = new PlaylistManager();
        String songToRemove = "song2";
        // When
        manager.removeSong(songToRemove);
    }

    @Test
    public void testRemoveNonExistentSong() {
        // Given
        String[] songs = {"song1", "song2", "song3"};
        PlaylistManager manager = new PlaylistManager(songs);
        String songToRemove = "song4";
        // When
        manager.removeSong(songToRemove);
        // Then
        Playlist modifiedPlaylist = manager.getPlaylist();
        assertTrue(Arrays.asList(modifiedPlaylist.getSongNameArrayList()).containsAll(Arrays.asList(songs)));
    }


    @Test
    public void testRemoveExistentSong() {
        // Given
        String[] expectedSongs = {"song1", "song2", "song3"};
        String[] allSongs = {"song1", "song2", "song3", "song4"};
        String songToRemove = "song4";
        PlaylistManager manager = new PlaylistManager(allSongs);
        assertTrue(Arrays.asList(manager.getPlaylist().getSongNameArrayList()).containsAll(Arrays.asList(allSongs)));

        // When
        manager.removeSong(songToRemove);


        // Then
        Playlist modifiedPlaylist = manager.getPlaylist();
        assertFalse(Arrays.asList(modifiedPlaylist.getSongNameArrayList()).contains(songToRemove));
    }
}
