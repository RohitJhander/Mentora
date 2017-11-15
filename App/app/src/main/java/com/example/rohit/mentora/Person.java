package com.example.rohit.mentora;

import java.io.Serializable;

/**
 * Created by Rohit on 18-12-2015.
 */
public class Person implements Serializable{
    public String id;
    public String name;
    public String email;
    public String phone;
    public String gender;
    public String city;
    public String country;
    public String fb;
    public String pic;
    public String education_id;
    public String school;
    public String coaching;
    public String college;
    public String branch;
    public String profession;
    public String board;
    public String mains;
    public String advance;
    public String pmt;
    public String percentage;
    public String other;

    // Constructor
    public Person() {
        super();
    }

    // Copy Constructor
    public Person(Person p) {
        this.id = p.id;
        this.name = p.name;
        this.phone = p.phone;
        this.email = p.email;
        this.gender = p.gender;
        this.city = p.city;
        this.country = p.country;
        this.fb = p.fb;
        this.pic = p.pic;
        this.education_id = p.education_id;
        this.school = p.school;
        this.coaching = p.coaching;
        this.college = p.college;
        this.branch = p.branch;
        this.profession = p.profession;
        this.board = p.board;
        this.mains = p.mains;
        this.advance = p.advance;
        this.pmt = p.pmt;
        this.percentage = p.percentage;
        this.other = p.other;
    }

    /*
    public static final Parcelable.Creator<Person> CREATOR = new Creator<Person>() {

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }

        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }
    };

    //Parcel Constructor
    public Person(Parcel in) {
        super();
        id = ((in.readString() == null)) ? StringUtils.EMPTY : in.readString();
        name = ((in.readString() == null)) ? StringUtils.EMPTY : in.readString();
        phone = ((in.readString() == null)) ? StringUtils.EMPTY : in.readString();
        email = ((in.readString() == null)) ? StringUtils.EMPTY : in.readString();
        gender = ((in.readString() == null)) ? StringUtils.EMPTY : in.readString();
        city = ((in.readString() == null)) ? StringUtils.EMPTY : in.readString();
        country = ((in.readString() == null)) ? StringUtils.EMPTY : in.readString();
        fb = ((in.readString() == null)) ? StringUtils.EMPTY : in.readString();
        pic = ((in.readString() == null)) ? StringUtils.EMPTY : in.readString();
        education_id = ((in.readString() == null)) ? StringUtils.EMPTY : in.readString();
        school = ((in.readString() == null)) ? StringUtils.EMPTY : in.readString();
        coaching = ((in.readString() == null)) ? StringUtils.EMPTY : in.readString();
        college = ((in.readString() == null)) ? StringUtils.EMPTY : in.readString();
        branch = ((in.readString() == null)) ? StringUtils.EMPTY : in.readString();
        profession = ((in.readString() == null)) ? StringUtils.EMPTY : in.readString();
        board = ((in.readString() == null)) ? StringUtils.EMPTY : in.readString();
        mains = ((in.readString() == null)) ? StringUtils.EMPTY : in.readString();
        advance = ((in.readString() == null)) ? StringUtils.EMPTY : in.readString();
        pmt = ((in.readString() == null)) ? StringUtils.EMPTY : in.readString();
        percentage = ((in.readString() == null)) ? StringUtils.EMPTY : in.readString();
        other = ((in.readString() == null)) ? StringUtils.EMPTY : in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id != null) {
            dest.writeString(id);
        } else {
            dest.writeString("");
        }

        if (name != null) {
            dest.writeString(name);
        } else {
            dest.writeString("");
        }

        if (email != null) {
            dest.writeString(email);
        } else {
            dest.writeString("");
        }

        if (phone != null) {
            dest.writeString(phone);
        } else {
            dest.writeString("");
        }

        if (gender != null) {
            dest.writeString(gender);
        } else {
            dest.writeString("");
        }

        if (gender != null) {
            dest.writeString(gender);
        } else {
            dest.writeString("");
        }

        if (city != null) {
            dest.writeString(city);
        } else {
            dest.writeString("");
        }

        if (country != null) {
            dest.writeString(country);
        } else {
            dest.writeString("");
        }

        if (coaching != null) {
            dest.writeString(coaching);
        } else {
            dest.writeString("");
        }

        if (branch != null) {
            dest.writeString(branch);
        } else {
            dest.writeString("");
        }

        if (percentage != null) {
            dest.writeString(percentage);
        } else {
            dest.writeString("");
        }

        if (pic != null) {
            dest.writeString(pic);
        } else {
            dest.writeString("");
        }

        if (pmt != null) {
            dest.writeString(pmt);
        } else {
            dest.writeString("");
        }

        if (board != null) {
            dest.writeString(board);
        } else {
            dest.writeString("");
        }

        if (mains != null) {
            dest.writeString(mains);
        } else {
            dest.writeString("");
        }

        if (other != null) {
            dest.writeString(other);
        } else {
            dest.writeString("");
        }

        if (advance != null) {
            dest.writeString(advance);
        } else {
            dest.writeString("");
        }

        if (education_id != null) {
            dest.writeString(education_id);
        } else {
            dest.writeString("");
        }

        if (fb != null) {
            dest.writeString(fb);
        } else {
            dest.writeString("");
        }

        if (school != null) {
            dest.writeString(school);
        } else {
            dest.writeString("");

        }
    }
    */
}

