package com.cognizant.orm_learn.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_id")
    private int id;

    @Column(name = "st_code")
    private String code;

    @Temporal(TemporalType.DATE)
    @Column(name = "st_date")
    private Date date;

    @Column(name = "st_open")
    private double open;

    @Column(name = "st_close")
    private double close;

    @Column(name = "st_volume")
    private long volume;

    public Stock() {
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public double getOpen() { return open; }
    public void setOpen(double open) { this.open = open; }

    public double getClose() { return close; }
    public void setClose(double close) { this.close = close; }

    public long getVolume() { return volume; }
    public void setVolume(long volume) { this.volume = volume; }

    @Override
    public String toString() {
        return "Stock [id=" + id + ", code=" + code + ", date=" + date
                + ", open=" + open + ", close=" + close + ", volume=" + volume + "]";
    }
}