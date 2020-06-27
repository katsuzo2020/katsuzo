package com.xl.download.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xl.download.bean.category;
import com.xl.download.bean.download;
import com.xl.download.mapper.CategoryMapper;
import com.xl.download.mapper.DownloadMapper;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class DownloadController {
    private String LIST = "list";
    private String DOWNLOAD = "download";
    private String UPDATELIST = "updatelist";

    @Autowired
    DownloadMapper downloadMapper;
    @Autowired
    CategoryMapper categoryMapper;

    @RequestMapping(value = "/download/{cid}")
    public String download(HttpServletRequest request, Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@PathVariable(name = "cid") int cid) {
        PageHelper.startPage(pageNum,15);
        List<download> ListDownload =null;
        if(cid==0){
            ListDownload = downloadMapper.getdownload();

        }else{
            ListDownload = downloadMapper.getdownloadbyCid(cid);
        }

        List<category> ListCategory = categoryMapper.getcategory();
        PageInfo<download> pageInfo=new PageInfo<download>(ListDownload);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("ListCategory", ListCategory);
        model.addAttribute("cid",cid);
        System.out.println("---------------------测试---------------成功--------------");
        return DOWNLOAD;
    }

    @RequestMapping(value = "/list/cid/{cid}")
//@ResponseBody
    public String getDownload(@PathVariable(name = "cid") int cid, Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum,15);
        List<download> ListDownload = downloadMapper.getdownloadbyCid(cid);
        //List<category>  ListCategory= categoryMapper.getcategory();
        // model.addAttribute("ListCategory",ListCategory);
        getcategorycommon(model);
        PageInfo<download> pageInfo=new PageInfo<download>(ListDownload);
        model.addAttribute("pageInfo", pageInfo);
//        model.addAttribute("ListDownload", ListDownload);
        return DOWNLOAD;
    }

    @RequestMapping(value = "/lists")
    public String lists(Model model) {
        System.out.println("进入后台列表。。。。");
        List<download> ListDownload = downloadMapper.getdownloadAll();
        //List<category>  ListCategory= categoryMapper.getcategory();
        for (download d : ListDownload) {
            System.out.println(d.getSoftware_image());
        }

        System.out.println("......。。。。" + ListDownload.toString());
        model.addAttribute("ListDownload", ListDownload);
        // model.addAttribute("ListCategory",ListCategory);
        return LIST;
    }

    public String downloadHtml(Model model) {
        List<category> ListCategory = categoryMapper.getcategory();
        model.addAttribute("ListCategory", ListCategory);
        return DOWNLOAD;
    }

    //刪除軟件
    @RequestMapping(value = "/delete/{id}")
    public String DeleteSofe(Map<String, Object> map, @PathVariable(name = "id") int id, download d) {
        downloadMapper.deleteSofe(id);
        return "redirect:/lists";
    }

    @RequestMapping(value = "/update/{id}")
    public String getUpdateSofe(@PathVariable(name = "id") int id, Model model) {
        List<category> ListCategory = categoryMapper.getcategory();
        model.addAttribute("ListCategory", ListCategory);
        download listDownload = downloadMapper.getdownloadbyId(id);
        model.addAttribute("listDownload", listDownload);
        return UPDATELIST;
    }

    //更改功能
    @RequestMapping(value = "/updatesoft")
    public String UpdateSofe(download d) {
        System.out.println("获取的数据" + d.toString());
        int reuse = downloadMapper.Updatesoft(d);
        if (reuse > 0) {
            return "redirect:/lists";
        } else {
            return "/err";
        }
    }

    public void getcategorycommon(Model model) {
        List<category> ListCategory = categoryMapper.getcategory();
        model.addAttribute("ListCategory", ListCategory);
    }
}
