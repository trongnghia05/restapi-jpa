package com.maitrongnghia.restapi.dao;

import com.maitrongnghia.restapi.model.Classroom;
import com.maitrongnghia.restapi.model.Course;
import com.maitrongnghia.restapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface ClassroomRepository extends JpaRepository<Classroom,Long> {
    List<Classroom> getClassroomByCourseIdAndKidIdAndTeacherId(long courseId,long kidId,long teacherId);
    @Query("from Classroom where (starttime - CURRENT_TIMESTAMP()) >'00-?1-00'")
    List<Classroom> getClassroomByCourseIdAndKidIdAndTeacherId(long courseId,long kidId,long teacherId);

}
