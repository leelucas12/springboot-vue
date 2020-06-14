package com.example.elmentspringboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.elmentspringboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
