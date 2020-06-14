package com.example.elmentspringboot.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date bri;
    private String sex;
    private  String address;


}
