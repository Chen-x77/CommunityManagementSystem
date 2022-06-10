package com.chen.controller.people;

import com.chen.entity.applycomm;
import com.chen.entity.comm;
import com.chen.entity.people;
import com.chen.service.applycommService;
import com.chen.service.comm.commService;
import com.chen.service.loginService;
import com.chen.service.people.peopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class commController_people {
    @Autowired
    private loginService loginService;
    @Autowired
    private commService commService;
    @Autowired
    private peopleService peopleService;
    @Autowired
    private applycommService applycommService;

    //社团查看
    @RequestMapping("/com_record_people")
    public String com_Record(Model model) {
        List<comm> commlist = commService.findCommList();
        model.addAttribute(commlist);
        System.out.println(commlist);
        return "people/find_Comm";
    }

    //社团查看
    @RequestMapping("/getComm_people")
    public String getComm_people(HttpServletRequest req, Model model) {
        String commId = req.getParameter("commId");
        Integer id = Integer.parseInt(commId);
        Integer flag = 1;
        people people = peopleService.findPeopleByFlag(id, flag);//查找社团负责人
        model.addAttribute("people", people);
        comm comm = commService.getCommById(id);
        System.out.println(comm);
        model.addAttribute("comm", comm);
        return "people/get_Comm";
    }

    //点击加入社团请求
    @RequestMapping("/applyComm_people")
    public ModelAndView applComm_people(HttpServletRequest req, HttpSession session) {
        String commId = req.getParameter("commId");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("people/find_Comm");
        Integer peo_id = (Integer) (session.getAttribute("peo_id"));
        applycomm applycomm = applycommService.getApplycommByPeoid(peo_id);
        if (applycomm == null) {
            mv.addObject("state", 0);//0.未批准 ，1.已同意
            mv.addObject("peo_id", peo_id);
            mv.addObject("com_id", commId);
            mv.setViewName("people/addApplComm");
        }else {
            mv.addObject("msg", "你已经提交过入社申请!");
        }
        return mv;
    }

    //填写自我介绍
    @PostMapping("/addApplCommFrom")
    public ModelAndView applComm_people(applycomm applycomm) {
        ModelAndView mv = new ModelAndView();
        System.out.println("addApplCommFrom:" + applycomm);
        mv.setViewName("people/find_Comm");
        if (applycommService.addApplycomm(applycomm)) {
            mv.addObject("msg", "已提交入社申请");
        } else {
            mv.addObject("msg", "入社失败");
        }
        return mv;
    }
    //查询社团成员
    @GetMapping("/queryCommFrom_people")
    public ModelAndView queryCommFrom(String commName) {
        ModelAndView mv = new ModelAndView();
        System.out.println("搜索社团");
        System.out.println(commName);
        List<comm> list = commService.queryCommList(commName);
        //可以创建
        System.out.println(list);
        mv.addObject(list);
        mv.setViewName("/people/find_Comm");
        return mv;
    }
}
