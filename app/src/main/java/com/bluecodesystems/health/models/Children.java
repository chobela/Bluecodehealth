package com.bluecodesystems.health.models;

import java.io.Serializable;

public class Children implements Serializable {

    public static final String TABLE_NAME = "children";

    public static final String COLUMN_ID = "id";
    public static final String MOTHER = "mother";
    public static final String CHILDNAME = "childname";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + MOTHER + " TEXT,"
                    + CHILDNAME + " TEXT"
                    + ")";

    public Children() {

    }

    public Children (int id, String mother, String childname) {
        this.id = id;
        this.mother = mother;
        this.childname = childname;
    }

    private int id;
    private String mother;
    private String childname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getChildname(String string) {
        return childname;
    }

    public void setChildname(String childname) {
        this.childname = childname;
    }
}
