package com.lagou.dao;

import com.lagou.domain.Course;
import com.lagou.domain.CourseLesson;
import com.lagou.domain.CourseSection;

import java.util.List;

public interface CourseContentMapper {
    /**
     * 根据课程id查询关联的章节信息及章节信息关联的课时信息
     * @return
     */
    public List<CourseSection> findSectionAndLessonByCourseId(Integer courseId);

    /**
     * 回显课程信息
     * @param courseId
     * @return
     */
    public Course findCourseById(Integer courseId);

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
     * 修改章节状态
     * @param courseSection
     */
    public void updateSectionStatus(CourseSection courseSection);

    /**
     * 新增课时信息
     * @param courseLesson
     */
    public void saveLesson(CourseLesson courseLesson);
}
