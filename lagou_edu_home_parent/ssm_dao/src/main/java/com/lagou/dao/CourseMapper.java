package com.lagou.dao;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.Teacher;

import java.util.List;

public interface CourseMapper {
    public List<Course> findCourseByCondition(CourseVO courseVO);
    /*
    * 多条件查询课程列表信息
    */
    void findCourseByCondition();
    /*
        新增课程信息
     */
    public void saveCourse(Course course);

    /*
        新增讲师信息
     */
    public void saveTeacher(Teacher teacher);

    /**
     * 回显课程信息（根据ID查询）
     * @param id
     * @return
     */
    public CourseVO findCourseById(Integer id);

    /**
     * 更新课程信息
     * @param course
     */
    public void updateCourse(Course course);

    /**
     * 更新讲师信息
     * @param teacher
     */
    public void updateTeacher(Teacher teacher);

    /**
     * 更新课程状态
     * @param course
     */
    public void updateCourseStatus(Course course);
}
