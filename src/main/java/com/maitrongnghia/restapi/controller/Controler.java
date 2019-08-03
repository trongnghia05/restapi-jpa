package com.maitrongnghia.restapi.controller;

import com.maitrongnghia.restapi.dao.ClassroomRepository;
import com.maitrongnghia.restapi.dao.CourseRepository;
import com.maitrongnghia.restapi.dao.UserRepository;
import com.maitrongnghia.restapi.model.Classroom;
import com.maitrongnghia.restapi.model.Course;
import com.maitrongnghia.restapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class Controler {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClassroomRepository classRepository;

    @Autowired
    private CourseRepository courseRepository;

    //manager user
    @RequestMapping(path="/get/getalluser",method = RequestMethod.GET)
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    @RequestMapping(path="/get/getuserbyrole",method = RequestMethod.GET)
    public List<User> getUserByRole(@RequestParam String role){
        return userRepository.findUserByRole(Integer.parseInt(role));
    }

    @RequestMapping(path="add/adduser",method = RequestMethod.GET)
    public String addUser(@RequestParam  String name,@RequestParam String role){
        userRepository.save(new User(name,Integer.parseInt(role)));
        return "insert sucsses";
    }

    @RequestMapping(path="update/updateuser",method = RequestMethod.GET)
    public String updateUser(@RequestParam String id,@RequestParam String newname){
        userRepository.save(new User(Integer.parseInt(id),newname));
        return "update sucsses";
    }

    @RequestMapping(path="/delete/deleteuser",method = RequestMethod.GET)
    @Transactional
    public String deleteUser(@RequestParam String id){
        userRepository.deleteUserById(Integer.parseInt(id));
        return "delete sucsses";
    }

    // manager course
    @RequestMapping(path="/get/getcoursebyid",method = RequestMethod.GET)
    public List<Course> getCourseById(@RequestParam String id){
        return courseRepository.findCourseById(Integer.parseInt(id));
    }

    // manager course
    @RequestMapping(path="/get/getcoursebyname",method = RequestMethod.GET)
    public List<Course> getCourseByName(@RequestParam String name){
        return courseRepository.findCourseByName(name);
    }

    @RequestMapping(path="/get/getallcourse",method = RequestMethod.GET)
    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }

    @RequestMapping(path="/delete/deletebyname",method = RequestMethod.GET)
    @Transactional
    public String deleteCourseByName(@RequestParam String name){
        courseRepository.deleteByName(name);
        return "delete sucsses";
    }

    @RequestMapping(path="/delete/deletebyid",method = RequestMethod.GET)
    @Transactional
    public String deleteCourseById(@RequestParam String id){
        courseRepository.deleteCourseById(Integer.parseInt(id));
        return "delete sucsses";
    }

    @RequestMapping(path="add/addcourse",method = RequestMethod.GET)
    public String addCourse(@RequestParam  String name,@RequestParam String decreption){
        courseRepository.save(new Course(name,decreption));
        return "insert sucsses";
    }

    @RequestMapping(path = "/get/getlistclassromm", method = RequestMethod.GET)
    public List<Classroom> getListClassroom() {
        return classRepository.getClassroomByCourseIdAndKidIdAndTeacherId(1, 2, 1);
    }

}
