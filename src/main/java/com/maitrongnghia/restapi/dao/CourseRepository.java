package com.maitrongnghia.restapi.dao;

import com.maitrongnghia.restapi.model.Course;
import com.maitrongnghia.restapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findCourseByName(String name);
    List<Course> findCourseById(int id);
    List<Course> findAll();
    List<Course> deleteByName(String name);
    List<Course> deleteCourseById(int id);
}
