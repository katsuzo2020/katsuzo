package com.xl.download.controller;


import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.sun.xml.internal.ws.util.xml.CDATA;
import com.xl.common.Utils.FileUtils;
import com.xl.common.Utils.Time;
import com.xl.download.bean.category;
import com.xl.download.bean.download;
import com.xl.download.mapper.CategoryMapper;
import com.xl.download.mapper.DownloadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.awt.shell.ShellFolder;

import javax.imageio.ImageIO;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

@Controller
public class UploadController {
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    DownloadMapper downloadMapper;

    @RequestMapping(value = "/upload")
    public String upload(Model model, HttpServletRequest request) {
        List<category> Listcategory = categoryMapper.getcategory();
        model.addAttribute("Listcategory", Listcategory);
        System.out.println("---------------------进入上传---------------成功--发给对方是个----今后会");
        return "uploadfile";
    }

    @ResponseBody()
    @RequestMapping(value = "/download/upload")
    public JSONObject uploads(@RequestParam("uploadfile") MultipartFile file, download d, HttpServletRequest request) throws JSONException {
        String contentType = file.getContentType();
        System.out.println(contentType);
        String fileName = file.getOriginalFilename();
        String filePath = "D://迅雷下载/";

        JSONObject jo = new JSONObject();//实例化json数据

        if (file.isEmpty()) {
            jo.put("status", 0);
            jo.put("fileName", "");
        }
        try {
            FileUtils.uploadFile(file.getBytes(), filePath, fileName);
            FileUtils.toIcon(filePath, fileName);
            int ruser = downloadMapper.upload(fileName.substring(0, fileName.lastIndexOf(".")), contentType, "/" + fileName, d.getSpecification(), d.getCid(), "/ico/" + fileName.substring(0, fileName.lastIndexOf(".")) + ".ico", Time.getSystemTime());
            System.out.println(ruser);
            jo.put("status", 1);
            jo.put("fileName", fileName);
            // jo.put("xfileName", filePath+"/"+fileName);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        //返回json
        return jo;
    }

//    private void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
//        File targetFile = new File(filePath);
//        if (!targetFile.exists()) {
//            targetFile.mkdirs();
//        }
//        FileOutputStream out = new FileOutputStream(filePath +"/"+ fileName);
//        out.write(file);
//        out.flush();
//        out.close();
//    }
    //文件获取图标
//    public void toIcon(String filePath, String fileName) throws FileNotFoundException {
//        File file=new File(filePath +"/"+ fileName);
//        System.out.println(file.getPath()+"---------------------------------"+file);
////        Icon  icon=FileSystemView.getFileSystemView().getSystemIcon(file);//获取小图标
//        ShellFolder shellFolder = ShellFolder.getShellFolder(file);
//        Icon icon = new ImageIcon(shellFolder.getIcon(true));
//        File icofile = new File(filePath +"/ico/" );
//        if (!icofile.exists()) {
//            icofile.mkdirs();
//        }
//        OutputStream inStream = new FileOutputStream(icofile+"/"+fileName.substring(0,fileName.indexOf("."))+".ico");
//        try {
//            BufferedImage www = (BufferedImage)((ImageIcon) icon).getImage();
//            ImageIO.write(www, "png", inStream);
//            inStream.flush();
//            inStream.close();
//        } catch (IOException e) {
//// TODO Auto-generated catch block
//            e.printStackTrace();
//            System.out.println("获取成功---------------"+e);
//        }
//    }
}
