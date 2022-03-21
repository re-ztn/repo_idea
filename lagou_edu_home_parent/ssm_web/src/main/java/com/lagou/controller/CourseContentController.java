package com.lagou.controller;

import com.lagou.domain.Course;
import com.lagou.domain.CourseLesson;
import com.lagou.domain.CourseSection;
import com.lagou.domain.ResponseResult;
import com.lagou.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/courseContent")
public class CourseContentController {

    @Autowired
    private CourseContentService courseContentService;

    @RequestMapping("/findSectionAndLesson")
    public ResponseResult findSectionAndLessonByCourseId(Integer courseId) {
        List<CourseSection> sectionAndLessonByCourseId = courseContentService.findSectionAndLessonByCourseId(courseId);
        ResponseResult responseResult = new ResponseResult(true, 200, "章节及课时信息查询成功", sectionAndLessonByCourseId);
        return responseResult;
    }

    @RequestMapping("/findCourseByCourseId")
    public ResponseResult findCourseByCourseId(Integer courseId) {
        Course course = courseContentService.findCourseByCourseId(courseId);
        ResponseResult responseResult = new ResponseResult(true, 200, "查询课程信息成功", course);
        return responseResult;
    }

    /**
     * 新增&更新章节
     *
     * @param courseSection
     * @return
     */
    @RequestMapping("/saveOrUpdateSection")
    public ResponseResult saveOrUpdateSection(@RequestBody CourseSection courseSection) {
        ResponseResult responseResult = null;
        //新增章节
        if (courseSection.getId() == null) {
            courseContentService.saveSection(courseSection);
            responseResult = new ResponseResult(true, 200, "新增章节成功", null);
        } else {
        //    更新章节
            courseContentService.updateSection(courseSection);
            responseResult = new ResponseResult(true, 200, "修改章节成功", null);
        }

        return responseResult;
    }

    @RequestMapping("/updateSectionStatus")
    public ResponseResult updateSectionStatus(Integer id, Integer status) {
        courseContentService.updateSectionStatus(id,status);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("content",status);
        ResponseResult responseResult = new ResponseResult(true, 200, "修改章节状态成功", map);

        return responseResult;
    }

    @RequestMapping("/saveLesson")
    public ResponseResult saveLesson(@RequestBody CourseLesson courseLesson) {
        ResponseResult responseResult = null;
        //新增章节
        if (courseLesson.getId() == null) {
            courseContentService.saveLesson(courseLesson);
            responseResult = new ResponseResult(true, 200, "新增课时成功", null);
        }
        return responseResult;
    }
}
