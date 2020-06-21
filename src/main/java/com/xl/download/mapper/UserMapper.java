package com.xl.download.mapper;

import com.xl.download.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user where name=#{name} and password=#{password}")
    public String loginuser(String name,String password);
}
