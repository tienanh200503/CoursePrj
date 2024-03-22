/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author BIN
 */
public class Order implements Serializable{
    private int id;
    private int uid;
    private int cid;
    private String order_date;

    public Order() {
    }

    public Order(int id, int uid, int cid, String order_date) {
        this.id = id;
        this.uid = uid;
        this.cid = cid;
        this.order_date = order_date;
    }

    public Order(int uid, int cid, String order_date) {
        this.uid = uid;
        this.cid = cid;
        this.order_date = order_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }
    
    
}
