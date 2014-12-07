package com.company;

import java.io.Serializable;
/**
 * Created by Szymon on 2014-12-07.
 */
public class Acount implements Serializable{
    private String surname = null;
    private String firstname = null;

    public Acount (String surname, String firstname) {
        this.surname = surname;
        this.firstname = firstname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getSurname() {
        return this.surname;
    }
}
