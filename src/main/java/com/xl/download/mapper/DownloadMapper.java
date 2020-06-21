package com.xl.download.mapper;

import com.xl.download.bean.download;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

//指定这是一个操作数据库的mapper
@Mapper
public interface DownloadMapper {
@Select("select * from download")
    public List<download> getdownload();
@Select("select * from download where cid=#{cid}")
public  List<download> getdownloadbyCid(int cid);
@Insert("insert into download (software_name,software_type,software_url,Specification,Cid,software_imge,date) values (#{software_name}, #{software_type}, #{software_url}, #{Specification}, #{Cid},#{software_imge},#{date})")
public int upload(String software_name, String software_type, String software_url, String Specification, int Cid, String software_imge, Date date);
@Delete("delete from download where id=#{id}")
public int deleteSofe(int id);
}
