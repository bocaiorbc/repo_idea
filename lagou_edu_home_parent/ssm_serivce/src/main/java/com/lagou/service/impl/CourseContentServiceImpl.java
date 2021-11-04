package com.lagou.service.impl;

import com.lagou.dao.CourseContentMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseLesson;
import com.lagou.domain.CourseSection;
import com.lagou.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseContentServiceImpl implements CourseContentService {

    @Autowired
    private CourseContentMapper courseContentMapper;

    @Override
    public List<CourseSection> findSectionAndLessonByCourseId(Integer id) {

        List<CourseSection> list = courseContentMapper.findSectionAndLessonByCourseId(id);

        return list;
    }

    /*
     回显课程章节信息
     */
    @Override
    public Course findCourseByCourseId(int courseId) {
        Course course = courseContentMapper.findCourseByCourseId(courseId);

        return course;
    }

    /*
        新增章节信息
     */
    @Override
    public void saveSection(CourseSection courseSection) {

        //1.补全信息
        Date date = new Date();
        courseSection.setCreateTime(date);
        courseSection.setUpdateTime(date);

        //2.调用courseContentMapper
        courseContentMapper.saveSection(courseSection);
    }

    /*
        修改章节信息
     */
    @Override
    public void updateSection(CourseSection courseSection) {

        //1.补全信息
        courseSection.setUpdateTime(new Date());

        //2.调用courseContentMapper
        courseContentMapper.updateSection(courseSection);
    }

    /*
        修改课程状态
     */
    @Override
    public void updateSectionStatus(int id, int status) {

        //1.封装数据
        CourseSection courseSection = new CourseSection();

        courseSection.setId(id);
        courseSection.setStatus(status);

        //2.补全信息
        courseSection.setUpdateTime(new Date());

        //3.调用courseContentMapper
        courseContentMapper.updateSectionStatus(courseSection);
    }

    @Override
    public void saveLesson(CourseLesson courseLesson) {

        //1.补全信息
        Date date = new Date();
        courseLesson.setCreateTime(date);
        courseLesson.setUpdateTime(date);

        //2.调用courseContentMapper
        courseContentMapper.saveLesson(courseLesson);

    }
}
