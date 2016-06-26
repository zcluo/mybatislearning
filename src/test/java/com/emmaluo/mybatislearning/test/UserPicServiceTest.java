package com.emmaluo.mybatislearning.test;

import com.emmaluo.mybatislearning.model.UserPic;
import com.emmaluo.mybatislearning.service.CourseService;
import com.emmaluo.mybatislearning.service.UserPicService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

/**
 * Created by zcluo on 2016/6/25.
 */
public class UserPicServiceTest {
    private static UserPicService userPicService;
    @Before
    public void setUp() throws Exception {

        userPicService = new UserPicService();

    }

    @After
    public void tearDown() throws Exception {

        userPicService = null;
    }
    @Test
    public void insertUserPic() throws Exception {
        UserPic userPic = new UserPic();
        userPic.setName("Losy");
        userPic.setBio("put some lengthy string into bio");
        byte[] pic = null;
        try {
            File file = new File("F:\\Losy.jpg");
            InputStream is = new FileInputStream(file);
            pic = new byte[is.available()];
            is.read(pic);
            is.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();;
        }
        catch (IOException e){
            e.printStackTrace();
        }
        userPic.setPic(pic);
        int rowInserted = userPicService.insertUserPic(userPic);
        Assert.assertEquals(1,rowInserted);

    }

    @Test
    public void getUserPic() throws Exception {
        UserPic userPic = userPicService.getUserPic(2);
        Assert.assertNotNull(userPic);
        byte[] pic = userPic.getPic();
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("F:\\Losy1.jpg");
            fileOutputStream.write(pic);
            fileOutputStream.close();

        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(userPic);

    }

}