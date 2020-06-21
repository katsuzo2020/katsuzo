package com.xl.download.mapper;



import com.xl.download.bean.category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface CategoryMapper {
    @Select("select * from category")
    public List<category> getcategory();
}
