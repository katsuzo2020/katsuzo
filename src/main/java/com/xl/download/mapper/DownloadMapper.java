package com.xl.download.mapper;

import com.xl.download.bean.download;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

//指定这是一个操作数据库的mapper
@Mapper
public interface DownloadMapper {
@Select("select * from download")
    public List<download> getdownload();
@Select("select * from download where cid=#{cid}")
public  List<download> getdownloadbyCid(int cid);
@Insert("insert into download (software_name,software_type,software_url,Specification,Cid,software_image,date) values (#{software_name}, #{software_type}, #{software_url}, #{Specification}, #{Cid},#{software_image},#{date})")
public int upload(String software_name, String software_type, String software_url, String Specification, int Cid, String software_image, Date date);
@Delete("delete from download where id=#{id}")
public int deleteSofe(int id);
//@Select("select * from download d,category where d.id=#{id}")

    @Update(" Update download set software_name=#{software_name},Specification=#{Specification},Cid=#{cid},software_image=#{software_image} where id=#{id}")
     int Updatesoft(download d);
//    @Select("select * from download d , category c where d.Cid=c.id")
    List<download> getdownloadAll();

    download getdownloadbyId(int id);




}
