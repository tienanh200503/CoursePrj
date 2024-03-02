/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Desktop
 */
public class Course {
    private String title;
    private String time;
     private long  NumberOfLession;
     private String[] videos;
    public Course() {
    }

    public Course(String title, String time, long NumberOfLession, String[] videos) {
        this.title = title;
        this.time = time;
        this.NumberOfLession = NumberOfLession;
        this.videos = videos;
    }
    
    public Course(String title, String time, long NumberOfLession) {
        this.title = title;
        this.time = time;
        this.NumberOfLession = NumberOfLession;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public long getNumberOfLession() {
        return NumberOfLession;
    }

    public void setNumberOfLession(long NumberOfLession) {
        this.NumberOfLession = NumberOfLession;
    }

    public String[] getVideos() {
        return videos;
    }

    public void setVideos(String[] videos) {
        this.videos = videos;
    }
     
     
}
