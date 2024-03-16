/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author BIN
 */
public class Section {
    private int section_id;
    private int c_id;
    private String section_name;
    private String section_video;
    private String section;
    private boolean status;

    public Section(int session_id, int c_id, String section_name, String section_video) {
        this.section_id = session_id;
        this.c_id = c_id;
        this.section_name = section_name;
        this.section_video = section_video;
    }

    public Section(int section_id, int c_id, String section_name, String section_video, String section, boolean status) {
        this.section_id = section_id;
        this.c_id = c_id;
        this.section_name = section_name;
        this.section_video = section_video;
        this.section = section;
        this.status = status;
    }
    
    public Section(String section_name, String section) {
        this.section_name = section_name;
        this.section = section;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
    public Section() {
    }

    public int getSection_id() {
        return section_id;
    }

    public void setSection_id(int session_id) {
        this.section_id = session_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public String getSection_video() {
        return section_video;
    }

    public void setSection_video(String section_video) {
        this.section_video = section_video;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "Section{" + "section_id=" + section_id + ", c_id=" + c_id + ", section_name=" + section_name + ", section_video=" + section_video + ", section=" + section + '}';
    }
    
    
    
}
