package com.chen.controller;

import com.alibaba.fastjson.JSONArray;
import com.chen.entity.*;
import com.chen.service.activity.activityService;
import com.chen.service.comm.commService;
import com.chen.service.loginService;
import com.chen.service.office.officeService;
import com.chen.service.people.peopleService;
import com.chen.until.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

/**
 * @program: community
 * @description: 视图控制器
 **/
@Controller
public class viewConller {
    @Autowired
    private loginService login;
    @Autowired
    private peopleService peopleService;
    @Autowired
    private commService commService;
    @Autowired
    private officeService officeService;
    @Autowired
    private activityService activityService;

    @PostMapping("/registerFrom")
    public ModelAndView register(String userName, people people) {
        System.out.println("进入");
        System.out.println(people);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        people people1 = login.peoLogin(userName);
        if (people1 == null) {
            System.out.println(people);
            if (login.register(people)) {
                mv.addObject("msg", "注册成功");
            } else {
                System.out.println("注册失败，请填写完整资料");
                mv.addObject("msg", "注册失败，请填写完整资料");
            }
        } else {
            System.out.println("该账户已经存在");
            mv.addObject("msg", "该账户以及存在");
        }
        return mv;
    }

    @RequestMapping("/admin_password")
    public ModelAndView admin_password() {
        ModelAndView view = new ModelAndView();
        view.setViewName("admin/password");
        return view;
    }

    @RequestMapping("/centen_password")
    public ModelAndView centen_password() {
        ModelAndView view = new ModelAndView();
        view.setViewName("centen/password");
        return view;
    }

    @GetMapping("/updatePwaAjax")
    public void pwdmodify(HttpServletRequest req, HttpServletResponse resp) {
        //从SessionL里面拿ID；
        Object o = req.getSession().getAttribute(Constants.USER_SESSION);
        String oldpassword = req.getParameter("oldpassword");
        //万能的map,结果集
        HashMap<String, String> resultMap = new HashMap<>();
        if (o == null) {  //Session失效或者过期
            resultMap.put("result", "sessionerror");
        } else if (oldpassword.isEmpty() || oldpassword == null) {
            resultMap.put("result", "error"); //密码输入为空
        } else {
            String userPassword = ((admin) o).getPassWord();//获取Session中用户密码
            if (oldpassword.equals(userPassword)) {
                resultMap.put("result", "true");  //密码输入正确
            } else {
                resultMap.put("result", "false");  //密码输入错误
            }
        }
        System.out.println("as " + resultMap.toString());
        try {
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();
            writer.write(JSONArray.toJSONString(resultMap));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @GetMapping("/centen_updatePwaAjax")
    public void centen_pwdmodify(HttpServletRequest req, HttpServletResponse resp) {
        //从SessionL里面拿ID；
        Integer peo_id = ((people) req.getSession().getAttribute("people")).getId();
        people people = peopleService.findPeopleById(peo_id);
        String oldpassword = req.getParameter("oldpassword");
        //万能的map,结果集
        HashMap<String, String> resultMap = new HashMap<>();
        if (people == null) {  //Session失效或者过期
            resultMap.put("result", "sessionerror");
        } else if (oldpassword.isEmpty() || oldpassword == null) {
            resultMap.put("result", "error"); //密码输入为空
        } else {
            String userPassword = people.getPassWord();//获取Session中用户密码
            if (oldpassword.equals(userPassword)) {
                resultMap.put("result", "true");  //密码输入正确
            } else {
                resultMap.put("result", "false");  //密码输入错误
            }
        }
        try {
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();
            writer.write(JSONArray.toJSONString(resultMap));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //系统管理员
    @PostMapping("/passwordFrom")
    public ModelAndView admin_password(String newpassword, HttpSession session) {
        ModelAndView view = new ModelAndView();
        view.setViewName("admin/password");
        System.out.println("newpassword" + newpassword);
        //从SessionL里面拿ID；
        admin admin = (admin) session.getAttribute(Constants.USER_SESSION);
        System.out.println(admin);
        boolean flag;
        if (admin != null && newpassword != null && !newpassword.isEmpty()) {
            flag = login.adminUpdatePwd(admin.getId(), newpassword);
            if (flag) {
                view.addObject("msg", "修改密码成功，请退出，使用新密码登入");
                //密码修改成功，移除当前Session
                session.removeAttribute(Constants.USER_SESSION);
            } else {
                view.addObject("msg", "修改密码失败");
            }
        } else {
            view.addObject("msg", "新密码输入错误");
        }
        return view;
    }

    //社团管理员
    @PostMapping("/centen_passwordFrom")
    public ModelAndView centen_admin_password(String newpassword, HttpSession session) {
        ModelAndView view = new ModelAndView();
        view.setViewName("centen/password");
        System.out.println("newpassword" + newpassword);
        //从SessionL里面拿ID；
        Integer peo_id = ((people) session.getAttribute("people")).getId();
        people people = peopleService.findPeopleById(peo_id);
        System.out.println(people);
        people.setPassWord(newpassword);
        boolean flag;
        if (people != null && newpassword != null && !newpassword.isEmpty()) {
            flag = peopleService.updatePeople(people);
            if (flag) {
                session.removeAttribute("people");
                view.addObject("msg", "修改密码成功，请退出，使用新密码登入");
                //密码修改成功，移除当前Session
            } else {
                view.addObject("msg", "修改密码失败");
            }
        } else {
            view.addObject("msg", "新密码输入错误");
        }
        return view;
    }

    //修改个人信息
    @RequestMapping("/centenInfo_modify")
    public ModelAndView centenInfo_modify(HttpSession session) {
        ModelAndView view = new ModelAndView();
        Integer peo_id = ((people)session.getAttribute("people")).getId();
        people people = peopleService.findPeopleById(peo_id);
        view.addObject("people",people);
        view.setViewName("centen/update_people");
        return view;
    }
    @PostMapping("/setPeopleFrom")
    public ModelAndView setPeopleFrom(people peopleModify,String name_class,HttpSession session) {
        ModelAndView view = new ModelAndView();
        view.setViewName("centen/update_people");
        Integer peo_id =((people)session.getAttribute("people")).getId();
        people people=peopleService.findPeopleById(peo_id);
        System.out.println(people);
        people.setName(peopleModify.getName());  //姓名
        people.setCollege(peopleModify.getCollege()); //学院
        people.setPhone(peopleModify.getPhone());  //手机
        people.setWx(peopleModify.getWx());         //微信
        people.setName_class(name_class); //班级
        System.out.println(name_class);
        if(peopleService.updatePeople(people)){
            System.out.println(people);
            view.addObject("msg","修改成功");
        }else {
            view.addObject("msg","修改失败");
        }
        view.addObject("people",people);
        return view;
    }
    //社团简介
    @RequestMapping("/com_Info")
    public ModelAndView com_Info(HttpSession session) {
        ModelAndView view = new ModelAndView();
        Integer peo_id = (Integer) session.getAttribute("peo_id");
        people people = peopleService.findPeopleById(peo_id);
        view.addObject("people",people);
        Integer com_id = (Integer) session.getAttribute("com_id");
        comm comm = commService.getCommById(com_id);
        return getModelAndView(com_id, view, comm);
    }

    @RequestMapping("/updateComm_centen")
    public String updateComm_centen(HttpServletRequest req, Model model) {
        Integer comm_id = Integer.parseInt(req.getParameter("comm_id"));
        comm comm = commService.getCommById(comm_id);
        System.out.println(comm);
        model.addAttribute("comm", comm);
        return "centen/update_Comm";
    }
    //修改社团方法
    @PostMapping("/centen_setCommFrom")
    public ModelAndView updataCommFrom(Integer id,Integer sum, String intro,HttpSession session) {
        ModelAndView mv = new ModelAndView();
        comm comm=commService.getCommById(id);
        comm.setSum(sum);
        comm.setIntro(intro);
        boolean flag = commService.updataComm(comm);
        if(flag){
            mv.addObject("msg","修改成功");
        }else {
            mv.addObject("msg","修改失败");
        }

        Integer peo_id = (Integer) session.getAttribute("peo_id");
        people people = peopleService.findPeopleById(peo_id);
        mv.addObject("people",people);
        return getModelAndView(id, mv, comm);

    }

    private ModelAndView getModelAndView(Integer id, ModelAndView mv, comm comm) {
        mv.addObject("comm",comm);
        List<office> officeList = officeService.finCommOfficeList(id);
        System.out.println("officeList:"+officeList);
        mv.addObject("officeList",officeList);
        mv.addObject("commOfficeSum",officeList.size());
        int activitySum=activityService.findCommActivityList(id).size();
        mv.addObject("activitySum",activitySum);
        mv.setViewName("centen/commInfo");
        return mv;
    }

}
