package com.bluecodesystems.health.models;

import java.io.Serializable;

public class Mothers implements Serializable {

    public static final String TABLE_NAME = "mothers";

    public static final String COLUMN_ID = "id";
    public static final String UID = "uid";
    public static final String NAME = "name";
    public static final String AGE = "age";
    public static final String NRC = "nrc";
    public static final String WEIGHT = "weight";
    public static final String PRESSURE = "pressure";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + UID + " TEXT,"
                    + NAME + " TEXT,"
                    + AGE + " TEXT,"
                    + NRC + " TEXT,"
                    + WEIGHT + " TEXT,"
                    + PRESSURE + " TEXT"
                    + ")";

    public Mothers() {

    }

    public Mothers (int id, String uid, String name, String age, String nrc, String weight, String pressure) {
        this.id = id;
        this.uid = uid;
        this.name = name;
        this.age = age;
        this.nrc = nrc;
        this.weight = weight;
        this.pressure = pressure;
    }

    private int id;
    private String uid;
    private String name;
    private String age;
    private String nrc;
    private String weight;
    private String pressure;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }
}
