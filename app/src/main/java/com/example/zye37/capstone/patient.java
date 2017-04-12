package com.example.zye37.capstone;

/**
 * Created by zye37 on 4/11/17.
 */

public  class patient {
    private String name;
    private String dateOfBirth;
    private String programStart;
/*
Default constructor required for calls to DataSnapshot.getValue(User.class)
 */
    public patient() {
    }

    public patient(String n, String date, String program) {
        name = n;
        dateOfBirth = date;
        programStart = program;
    }
/*
Getting methods to return corresponding attributes
 */
    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String programStart() {
        return programStart;
    }
}
