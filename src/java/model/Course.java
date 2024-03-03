/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *

 * @author BIN
 */
public class Course {
    private String course_name;
    private String course_time;
    private String course_price;
    private Teacher teacher;
    List<Section> sections;

    public Course() {
    }

    public Course(String course_name, String course_time, String course_price, Teacher teacher, List<Section> sections) {
        this.course_name = course_name;
        this.course_time = course_time;
        this.course_price = course_price;
        this.teacher = teacher;
        this.sections = sections;
    }
    
    public Course( String course_name, String course_time, String course_price, Teacher teacher) {
        this.course_name = course_name;
        this.course_time = course_time;
        this.course_price = course_price;
        this.teacher = teacher;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_time() {
        return course_time;
    }

    public void setCourse_time(String course_time) {
        this.course_time = course_time;
    }

    public String getCourse_price() {
        return course_price;
    }

    public void setCourse_price(String course_price) {
        this.course_price = course_price;
    }

    public Teacher getTeacher_id() {
        return teacher;
    }

    public void setTeacher_id(Teacher teacher_id) {
        this.teacher = teacher_id;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
    
    
    
    

}
