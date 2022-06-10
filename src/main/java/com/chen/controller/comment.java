package com.chen.controller;
import com.chen.entity.admin;
import com.chen.entity.comm;
import com.chen.entity.people;
import com.chen.service.comm.commService;
import com.chen.service.loginService;
import com.chen.service.people.peopleService;
import com.chen.until.Constants;
import com.chen.until.judge;
import com.chen.until.validatio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class comment {

    @Autowired
    private validatio validatio;
    @Autowired
    private loginService login;
    @Autowired
    private judge judge;
    @Autowired
    private commService commService;
    @Autowired
    private peopleService peopleService;

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }


    //注册
    @PostMapping("/register")
    public ModelAndView register(people people) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login_register");
        return mv;
    }
    /*系统管理员登入*/
    @PostMapping("/adminLogin")
    public ModelAndView adminLogin(String userName, String passWord, String codeNum, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        System.out.println("进入方法adminLogin------------");
        System.out.println(userName + " " + passWord);
        mv.setViewName("index");

        //  if (judge.judgeCode(codeNum,session)) {
        admin admin = login.adminLogin(userName, passWord);
        if (admin != null) {
            mv.setViewName("index_admin");
            session.setAttribute(Constants.USER_SESSION,admin);
        } else mv.addObject("msg", "用户名或密码错误，请重新输入");
        // }else mv.addObject("msg","验证码错误，请重新输入");
        return mv;
    }

    @PostMapping("/peoLogin")
    public ModelAndView peoLogin(String userName, String passWord, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        System.out.println(session.getId());
        System.out.println(session.getCreationTime());
        //if (judge.judgeCode(codeNum,session)){
        people people = login.peoLogin(userName); //查询账号
        if (people != null && people.getPassWord().equals(passWord)) {
            session.setAttribute("people", people); //人员信息
            session.setAttribute("peo_id", people.getId());
            session.setAttribute("peo_name", people.getName());
            session.setAttribute("ple_flag", people.getFlag());
            mv.addObject("people",people);  //人员
            //没有社团
            if (people.getCom_id() == null) {
                mv.setViewName("index_people");
                System.out.println("peo: "+people);
                return  mv;
            }
            //有社团，社长 社员
            comm comm = commService.getCommById(people.getCom_id());
            people peopleFlag =peopleService.findPeopleByFlag(comm.getId(),1);
            session.setAttribute("peo_id", peopleFlag.getId());
            session.setAttribute("com_id", comm.getId());
            mv.addObject("comm",comm);
            if (people.getFlag() == 1) {
                mv.setViewName("index_centen");  //社长
            } else if(people.getFlag()==0){
                mv.setViewName("index_member"); //成员
            }
        } else mv.addObject("msg", "用户名或密码错误，请重新输入");
        // }else mv.addObject("msg","验证码错误，请重新输入");
        return mv;
    }


    /*获取图形状验证码**/
    @RequestMapping("/imgCode")
    public void getCodeImg(HttpServletResponse response, HttpSession session) {
        try {
            validatio.output(response.getOutputStream());
            session.setMaxInactiveInterval(120);
            session.setAttribute("imgCode", validatio.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*视图解析器*/
    @RequestMapping("/teacher")
    public ModelAndView teacher() {
        return new ModelAndView("index_teacher");
    }

    @RequestMapping("/student")
    public ModelAndView student() {
        return new ModelAndView("index_student");
    }

    @RequestMapping("/centens")
    public ModelAndView centen() {
        return new ModelAndView("index_centen");
    }
}
