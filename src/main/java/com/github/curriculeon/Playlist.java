package com.github.curriculeon;
//import com.google.common.primitives.Ints;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 1/10/2021.
 */
public class Playlist {
    private final List<String> songNameArrayList;
    private int currentIndex = 0;
    public Playlist(final String[] songNameArray) {
        final List<String> unmodifiableArrayList = Arrays.asList(songNameArray);
        final List<String> modifiableArrayList = new ArrayList<>(unmodifiableArrayList);
        this.songNameArrayList = modifiableArrayList;
        this.currentIndex = 0;
    }

    public Playlist(int currentIndex, String[] songNameArray) {
        this.currentIndex= currentIndex;
        this.songNameArrayList =songNameArray;
    }

    public String[] getSongNameArrayList() {
        return songNameArrayList;
    }

    public String getCurrentSelection() {
        return songNameArrayList[currentIndex];
    }
    public void setSongNameArrayList(String[] songs){
        this.songNameArrayList = songs;
    }

    public Playlist() {
    }

    public void goToPreviousSong() {
        System.out.println("inside prev song");
        if(this.currentIndex == 0){
            this.currentIndex =this.songNameArrayList.length-1;
        }else{
            this.currentIndex--;
        }

    }

    public void goToNextSong() {
        System.out.println("inside next song");
        if(this.currentIndex == this.songNameArrayList.length-1){
            System.out.println("inside next song");

            this.currentIndex=0;
        }else{
            this.currentIndex++;
        }
    }

    public Integer getMinimumNumberOfStepsBetween(Integer currentIndex, String desiredSong) {
        int index = Arrays.asList(songNameArrayList).indexOf(desiredSong);
        int forward = 0;
        int backward =0;
        this.currentIndex = currentIndex;
        if(this.currentIndex == index){
            return 0;
        }

        while(this.currentIndex != index){
            System.out.println(this.currentIndex);
            goToNextSong();
            System.out.println(this.currentIndex);
            forward++;
        }
        this.currentIndex = currentIndex;
        while(this.currentIndex != index){
            goToPreviousSong();
            backward++;
        }
        return forward < backward ? forward : backward;
    }

    public Integer getNumberOfStepsBetween(Integer currentIndex, String desiredSong, Runnable directionMutator) {
        return null;
    }

    public Integer getForwardNumberOfStepsBetween(Integer currentIndex, String desiredSong) {
        int index = Arrays.asList(songNameArrayList).indexOf(desiredSong);
        int forward = 0;
        this.currentIndex = currentIndex;
        while(this.currentIndex != index){
            goToNextSong();
            forward++;
        }

        return forward;
    }

    public Integer getBackwardNumberOfStepsBetween(Integer currentIndex, String desiredSong) {

        int index = Arrays.asList(songNameArrayList).indexOf(desiredSong);
        int backward = 0;
        this.currentIndex = currentIndex;
        while(this.currentIndex != index){
            goToPreviousSong();
            backward++;
        }
        return backward;
    }
}
