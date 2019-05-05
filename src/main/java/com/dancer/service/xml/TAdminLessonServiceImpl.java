package com.dancer.service.xml;

import com.dancer.dao.mapper.TAdminLessonMapper;
import com.dancer.entity.TAdminLesson;
import com.dancer.service.TAdminLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * service实现类
 * 董红广
 * 2019-04-24
 */
@Service
public class TAdminLessonServiceImpl implements TAdminLessonService {
    @Autowired
    private TAdminLessonMapper tAdminLessonMapper;
    @Override
    public int addAdminLesson(TAdminLesson adminLesson) {
        return tAdminLessonMapper.insert(adminLesson);
    }

    @Override
    public int deleteAdminLesson(int adminLessonId) {
        return tAdminLessonMapper.deleteByPrimaryKey(adminLessonId);
    }

    @Override
    public List<TAdminLesson> getAllAdminLesson() {
        return tAdminLessonMapper.selecAllAdminLesson();
    }

    @Override
    public List<TAdminLesson> getAdminLesson(Integer userId) {
        return tAdminLessonMapper.selectAdminLesson(userId);
    }
}
