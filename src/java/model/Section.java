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
    private int session;
    private int c_id;
    private String session_name;

    public Section(int session, int c_id, String session_name) {
        this.session = session;
        this.c_id = c_id;
        this.session_name = session_name;
    }
    
    
    
    public Section() {
    }
    
    public Section(int session, String session_name) {
        this.session = session;
        this.session_name = session_name;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }

    public String getSession_name() {
        return session_name;
    }

    public void setSession_name(String session_name) {
        this.session_name = session_name;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }
    
    
}
