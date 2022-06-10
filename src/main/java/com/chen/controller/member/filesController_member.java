package com.chen.controller.member;

import com.chen.entity.files;
import com.chen.entity.people;
import com.chen.service.files.filesService;
import com.chen.until.filetool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class filesController_member {
    @Autowired
    private filetool filetool;
    @Autowired
    private filesService filesService;
    //文件查看
    @RequestMapping("/member_comm_file")
    public ModelAndView centen_comm_file(HttpSession session){
        Integer com_id=(Integer) session.getAttribute("com_id");
        System.out.println("com_id"+com_id);
        ModelAndView view = new ModelAndView();
        List<files> filesList=filesService.findCommFileslist(com_id);
        System.out.println("filesList"+filesList);
        view.addObject("filesList",filesList);
        view.setViewName("member/find_commFiles");
        return view;
    }
    //文件下载
    @RequestMapping("/member_dowFiles")
    public ModelAndView dowFiles_centen(HttpSession session,HttpServletRequest request, HttpServletResponse response){
        ModelAndView view = new ModelAndView();
        Integer com_id=(Integer) session.getAttribute("com_id");
        List<files> filesList=filesService.findCommFileslist(com_id);
        view.addObject("filesList",filesList);
        view.setViewName("member/find_commFiles");
        //下载
        Integer id=Integer.parseInt(request.getParameter("files_id"));
        files file=filesService.getFilebyId(id);
        String path=file.getPath();
        String name=file.getName();
        filetool.downloadOther(response,path,name);
        return view;
    }

    //文件上传
    @RequestMapping("/member_commFilesUpload")
    public String member_commFilesUpload(){
       return "member/add_commFiles";
    }

    //文件上传处理
    @RequestMapping("/member_uploadCommFilesFrom")
    @ResponseBody
    public ModelAndView member_uploadCommFilesFrom(HttpSession session,MultipartFile file){
        Integer com_id=(Integer) session.getAttribute("com_id");
        Integer peo_id=((people)session.getAttribute("people")).getId();
        ModelAndView view = new ModelAndView();
        view.setViewName("/member/add_commFiles");
        String filesName = file.getOriginalFilename();//getOriginalFilename 获取文件名
        if(filesName == null ||  filesName.isEmpty() ){
            view.addObject("msg","你还没有选择文件！");
            return view;
        }
        System.out.println("file.getOriginalFilename()："+file.getOriginalFilename());
        String path = filetool.uploadOther(file);  //上传文件的绝对路径
        System.out.println("path:" +path);
        files files = new files();
        if(path !=null && !path.isEmpty()) {
            files.setCom_id(com_id);
            files.setPeo_id(peo_id);
            files.setDate(new Date());
            files.setName(filesName);
            files.setPath(path);
            System.out.println("files:"+files);
            Boolean flag = filesService.addCommFiles(files);
            if (flag){
                view.addObject("msg","上传成功!");
            } else{
                view.addObject("msg","上传失败!");
            }
        }
          return view;
    }

    //文件查询
    @GetMapping("/member_queryFilesFrom")
    public ModelAndView queryFilesFrom(HttpSession session,String fileName){
        Integer com_id=(Integer) session.getAttribute("com_id");
        System.out.println("com_id "+com_id);
        ModelAndView view = new ModelAndView();
        System.out.println("fileName："+fileName);
        List<files> filesList=filesService.queryCommFileslistByName(com_id,fileName);
        System.out.println("filesList"+filesList);
        if(filesList.isEmpty()||filesList==null){
            filesList=filesService.findCommFileslist(com_id);
            view.addObject("msg","没有匹配的记录！");
        }
        view.addObject("filesList",filesList);
        view.setViewName("member/find_commFiles");
        return view;
    }
}
