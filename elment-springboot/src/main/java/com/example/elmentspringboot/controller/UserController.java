package com.example.elmentspringboot.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.elmentspringboot.entity.User;
import com.example.elmentspringboot.mapper.UserMapper;
import com.example.elmentspringboot.vo.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserMapper userMapper;



    @GetMapping("/findAll")
    public List<User> findAll(){
        return userMapper.selectList(null);
    }

    @GetMapping("/findByPage")
    public Map<String,Object> findByPage( Integer pageNow,Integer pageSize){

        Map<String,Object> users=new HashMap<>();

        pageNow=pageNow==null?1:pageNow;
        pageSize=pageSize==null?4:pageSize;

        Page page = userMapper.selectPage(new Page(pageNow, pageSize), null);
        users.put("total",page.getTotal());
        users.put("users",page.getRecords());

        return users;
    }





    @Cacheable
    @GetMapping("/detele")
    public Result deteleById(Integer id){
        Result result = new Result();
        try{
            userMapper.deleteById(id);
            result.setStatus(true);
            result.setMsg("用户删除成功");
        }catch (Exception e){
            result.setMsg("系统繁忙，删除失败");
            result.setStatus(false);
        }
        return  result;
    }

    @PostMapping("/save")
    public Result addUser(@RequestBody User user){
        Result result = new Result();
        try{
            userMapper.insert(user);
            result.setStatus(true);
            result.setMsg("用户保存成功");
        }catch (Exception e){
            result.setMsg("系统繁忙，添加失败");
            result.setStatus(false);
        }
        return  result;
    }

    @PostMapping("/updata")
    public Result updataUser(@RequestBody User user){
        Result result = new Result();
        try{
            userMapper.updateById(user);
//            userMapper.update(user);
            result.setStatus(true);
            result.setMsg("用户修改成功成功");
        }catch (Exception e){
            result.setMsg("系统繁忙，修改失败");
            result.setStatus(false);
        }
        return  result;
    }
}
