package com.xl.common.Utils;

import sun.awt.shell.ShellFolder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class FileUtils {
    private static void  uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + "/" + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    //文件获取图标
    public static void toIcon(String filePath, String fileName) throws FileNotFoundException {
        File file = new File(filePath + "/" + fileName);
        System.out.println(file.getPath() + "---------------------------------" + file);
//        Icon  icon=FileSystemView.getFileSystemView().getSystemIcon(file);//获取小图标
        ShellFolder shellFolder = ShellFolder.getShellFolder(file);
        Icon icon = new ImageIcon(shellFolder.getIcon(true));
        File icofile = new File(filePath + "/ico/");
        if (!icofile.exists()) {
            icofile.mkdirs();
        }
        OutputStream inStream = new FileOutputStream(icofile + "/" + fileName.substring(0, fileName.indexOf(".")) + ".ico");
        try {
            BufferedImage www = (BufferedImage) ((ImageIcon) icon).getImage();
            ImageIO.write(www, "png", inStream);
            inStream.flush();
            inStream.close();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("获取成功---------------" + e);
        }
    }
}
