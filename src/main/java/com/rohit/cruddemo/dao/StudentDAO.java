package com.rohit.cruddemo.dao;

import com.rohit.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

}
