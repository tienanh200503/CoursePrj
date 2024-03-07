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

    public Section(int session_id, int c_id, String section_name, String section_video) {
        this.section_id = session_id;
        this.c_id = c_id;
        this.section_name = section_name;
        this.section_video = section_video;
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
    
    
    
}
