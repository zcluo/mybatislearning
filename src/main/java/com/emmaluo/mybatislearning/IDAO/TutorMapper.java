package com.emmaluo.mybatislearning.IDAO;

import com.emmaluo.mybatislearning.model.Tutor;
import org.springframework.stereotype.Component;

/**
 * Created by zcluo on 2016/6/24.
 */
@Component
public interface TutorMapper {
    Tutor findTutorById(int tutorId);
}
