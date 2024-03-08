/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 *
 * @author BIN
 */
public class Course {

    private int id;
    private String course_name;
    private int course_time;
    private Double course_price;
    private Teacher teacher;
    private String courseDescribe;
    private String course_img;
    private List<Section> sections;

    public Course(int id, String course_name, int course_time, Double course_price, Teacher teacher, String courseDescribe, String course_img, List<Section> sections) {
        this.id = id;
        this.course_name = course_name;
        this.course_time = course_time;
        this.course_price = course_price;
        this.teacher = teacher;
        this.courseDescribe = courseDescribe;
        this.course_img = course_img;
        this.sections = sections;
    }

    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getCourse_time() {
        return course_time;
    }

    public void setCourse_time(int course_time) {
        this.course_time = course_time;
    }

    public Double getCourse_price() {
        return course_price;
    }

    public void setCourse_price(Double course_price) {
        this.course_price = course_price;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getCourseDescribe() {
        return courseDescribe;
    }

    public void setCourseDescribe(String courseDescribe) {
        this.courseDescribe = courseDescribe;
    }

    public String getCourse_img() {
        return course_img;
    }

    public void setCourse_img(String course_img) {
        this.course_img = course_img;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

}
