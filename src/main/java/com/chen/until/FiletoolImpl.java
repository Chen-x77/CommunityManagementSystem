package com.chen.until;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;


@Component
public class FiletoolImpl implements filetool {


    //文件上传
    @Override
    public String uploadOther(MultipartFile file) {
        String filePath = "\\filesData\\";
        return upload(file,filePath);
    }
    //文件下载
    @Override
    public void downloadOther(HttpServletResponse response, String path,String name) {
        String filePath = "\\filesData\\"+path;
        download(response,filePath,name);
    }
    //文件删除
    @Override
    public boolean deleteOther(String path) {
        String filePath = "\\filesData\\";
        return delete(filePath,path);
    }


    /*文件上传处理类*/
    private String upload (MultipartFile file, String filePath) {
        //String realPath = ClassUtils.getDefaultClassLoader().getResource("/").getPath();
        try{
            //获取项目路径(realPath: C:\Users\chen\Desktop\毕设\master\target\classe)
            String realPath = ResourceUtils.getFile("classpath:").getPath();
           // System.out.println(":" +realPath);
            //获取保存路径
            File folder = new File(realPath+filePath);
            System.out.println("文件的保存路径："+folder);
            //file类的mkdirs方法，判断保存路径是否存在，不存在就创建文件夹，然后将上传的文件保存进去，实现文件上传。
            if(!folder.isDirectory()) {
                folder.mkdirs();
            }
            //上传文件的原始文件名
            String oldName = file.getOriginalFilename();
            //文件路径（UUID.randomUUID()+文件后缀） UUID.randomUUID().toString()唯一识别码
            String newName = UUID.randomUUID().toString()+oldName.substring(oldName.lastIndexOf("."));
                file.transferTo(new File(folder,newName));//文件保存
                return newName;
            }catch (IOException e) {
                e.printStackTrace();
            }
        return null;

    }

    /*文件下载处理*/
    private void download(HttpServletResponse response,String filePath,String name) {
        // 文件地址，真实环境是存放在数据库中的
        InputStream inputStream = null;
        ServletOutputStream servletOutputStream = null;
        try {
           // Resource resource = new DefaultResourceLoader().getResource("classpath:"+filePath);
            // 使用系统文件路径来加载文件
            Resource resource = new PathResource(ResourceUtils.getFile("classpath:").getPath()+filePath);
            System.out.println("resource:"+resource);
            // 设置相关格式
            response.setContentType("application/force-download");
            // 设置下载后的文件名以及header
            String prefix = filePath.substring(filePath.lastIndexOf(".") + 1);
            //name = name + "." + prefix;

            //设置reponse响应头，真实文件名重命名，就是在这里设置，设置编码
            response.setHeader("Content-disposition","attachment; filename="
                    + new String(name.getBytes("utf-8"), "ISO8859-1"));
            // 创建输出对象
            inputStream = resource.getInputStream();
            servletOutputStream = response.getOutputStream();
            IOUtils.copy(inputStream, servletOutputStream);
            response.flushBuffer();
            } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (servletOutputStream != null) {
                    servletOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /*文件删除处理*/
    private boolean delete(String path,String name){
        try{
            String realPath = ResourceUtils.getFile("classpath:").getPath();
            File file = new File(realPath+path+name);//文件保存路径
            if (file.exists()) {
                return file.delete();
            }
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("异常:"+e);
        }
        return false;
    }
}
