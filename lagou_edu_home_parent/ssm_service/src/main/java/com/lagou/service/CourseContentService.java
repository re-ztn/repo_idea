package com.lagou.service;

import com.lagou.domain.Course;
import com.lagou.domain.CourseLesson;
import com.lagou.domain.CourseSection;

import java.util.List;

public interface CourseContentService {
    /**
     * 根据课程Id查询对应得课程信息（章节+课时）
     * @param courseId
     * @return
     */
    public List<CourseSection> findSectionAndLessonByCourseId(Integer courseId);

    /**
     * 回显课程信息
     * @param courseId
     * @return
     */
    public Course findCourseByCourseId(Integer courseId);

    /**
     * 保存章节信息
     * @param courseSection
     */
    public void saveSection(CourseSection courseSection);

    /**
     * 更新章节信息
     * @param courseSection
     */
    public void updateSection(CourseSection courseSection);

    /**
     * 更新章节状态
     * @param id
     * @param status
     */
    public void updateSectionStatus(Integer id, Integer status);

    /**
     * 新增课时信息
     * @param courseLesson
     */
    public void saveLesson(CourseLesson courseLesson);
}
