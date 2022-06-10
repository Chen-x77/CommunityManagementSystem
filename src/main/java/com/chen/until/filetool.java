package com.chen.until;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/** @Description: 文件操作接口
* @Author: wangshilei
 * 操作：
 * down:    files.downloadMetting(HttpServletResponse response,path,newname);
 * upload:  files.uploadMetting(file);
 * delete:  file.deleteMetting(name);
 * */
public interface filetool {



    /*文件上传*/
    String uploadOther(MultipartFile file);
    /*文件下载*/
    void downloadOther(HttpServletResponse response,String path,String name);
    /* 删除文件 */
    boolean deleteOther(String path);

}

