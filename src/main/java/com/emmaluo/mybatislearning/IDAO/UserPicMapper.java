package com.emmaluo.mybatislearning.IDAO;

import com.emmaluo.mybatislearning.model.UserPic;
import org.springframework.stereotype.Component;

/**
 * Created by zcluo on 2016/6/25.
 */
@Component
public interface UserPicMapper {
    int insertUserPic(UserPic userPic);
    UserPic getUserPic(Integer id);

}
