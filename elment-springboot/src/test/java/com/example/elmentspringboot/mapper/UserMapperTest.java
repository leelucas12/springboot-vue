package com.example.elmentspringboot.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.elmentspringboot.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class UserMapperTest {


    @Autowired
    UserMapper userMapper;
    @Test
    void  testfind(){
            List<User> users = userMapper.selectList(null);
            users.forEach(System.out::println);
    }
    @Test
    void testAdd(){
        User user=new User();
        user.setName("宁输赢");
        user.setAddress("清远市");
        user.setSex("女");
        user.setBri(new Date());
        userMapper.insert(user);
    }

    @Test
    void testDelete(){
        int i = userMapper.deleteById(8);
        System.out.println(i);
    }

    @Test
    void updata(){
        User user=new User();
        user.setId(6);
        user.setName("何静怡");
        user.setAddress("福建");
        user.setSex("女");
        user.setBri(new Date());

        userMapper.updateById(user);
    }


    @Test
    public  void findPage(){
        IPage page=new Page(1,2);
        IPage page1 = userMapper.selectPage(page, null);
        System.out.println(page1.getTotal());
        List records = page1.getRecords();
      records.forEach(System.out::println);
    }
}