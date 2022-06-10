package com.chen.controller.member;

import com.chen.entity.*;
import com.chen.service.activity.activityService;
import com.chen.service.applycommService;
import com.chen.service.comm.commService;
import com.chen.service.office.officeService;
import com.chen.service.people.peopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class peopleController_member {
    @Autowired
    private commService commService;
    @Autowired
    private peopleService peopleService;
    @Autowired
    private applycommService applycommService;
    @Autowired
    private activityService activityService;
    @Autowired
    private officeService officeService;

    /*信息主页**/
    @RequestMapping("/member_index")
    public ModelAndView comIndex(HttpSession session) {
        ModelAndView view = new ModelAndView();
        view.setViewName("member/index");
        Integer com_id = (Integer) session.getAttribute("com_id");
        List<comm> commList = commService.findCommList();
        int commSum = commList.size();
        int memberSum = peopleService.queryPeopleList(com_id).size();
        int applySum = applycommService.finApplycommList(com_id).size();
        int activitySum0 = 0;
        List<activity> activityList = activityService.findCommActivityList(com_id);
        for (int i = 0; i < activityList.size(); i++) {
            if (activityList.get(i).getState() == 0) {
                activitySum0 = activitySum0 + 1;
            }
        }
        view.addObject("activityList", activityList);
        view.addObject("commSum", commSum); //社团数
        view.addObject("memberSum", memberSum);//本社会员数
        view.addObject("applySum",applySum);//入社申请数
        view.addObject("activitySum0", activitySum0);  //未审批活动数
        view.addObject("commList", commList);  //社团列表
        return view;
    }

    //查询社团office表的职位信息 查询该社团的所有职位的 和 所有负责人id
    public void setOfficeName(people people) {
        if (people.getOfficePosition() == null) {
            people.setOfficePosition("普通成员");
        }
        if (people.getFlag() == 1) {
            people.setOfficePosition("社长");
        }
    }
    public void setOfficeName(List<people> peopleList) {
        for (int i = 0; i < peopleList.size(); i++) {
            if (peopleList.get(i).getOfficePosition() == null) {
                peopleList.get(i).setOfficePosition("普通成员");
            }
            if (peopleList.get(i).getFlag() == 1) {
                peopleList.get(i).setOfficePosition("社长");
            }
        }
    }

    //查看会员
    @RequestMapping("/member_find_stu")
    public String centen_find_stu(Model model, HttpSession session) {
        Integer com_id = (Integer) session.getAttribute("com_id");
        List<people> peopleCommList = peopleService.queryPeopleList(com_id);
        setOfficeName(peopleCommList);  //没有职位塞入普通成员属性
        model.addAttribute("peopleList", peopleCommList);
        return "member/find_People";
    }

    //查看人员信息
    @RequestMapping("/member_ChaKanPeople")
    public String ChakanPeopleComm(HttpServletRequest req, Model model) {
        Integer peo_id = Integer.parseInt(req.getParameter("peo_id"));
        String userName = peopleService.findPeopleById(peo_id).getUserName();
        System.out.println(userName);
        people people = peopleService.findPeopleByUserName(userName);
        setOfficeName(people);          //没有职位塞入普通成员属性
        System.out.println(people);
        model.addAttribute("people", people);
        return "member/ChaKanPeople";
    }
    //根据姓名查找成员
    @GetMapping("/member_queryPeople")
    public String queryPeople_centen(String peopleName, HttpSession session, Model model) {
        Integer com_id = (Integer) session.getAttribute("com_id");
        List<people> peopleCommList = peopleService.queryCommPeopleListByName(com_id, peopleName);
        setOfficeName(peopleCommList);
        model.addAttribute("peopleList", peopleCommList);
        return "member/find_People";
    }
    private ModelAndView getModelAndView(Integer id, ModelAndView mv, comm comm) {
        mv.addObject("comm",comm);
        List<office> officeList = officeService.finCommOfficeList(id);
        System.out.println("officeList:"+officeList);
        mv.addObject("officeList",officeList);
        mv.addObject("commOfficeSum",officeList.size());
        int activitySum=activityService.findCommActivityList(id).size();
        mv.addObject("activitySum",activitySum);
        mv.setViewName("member/commInfo");
        return mv;
    }
    //社团简介
    @RequestMapping("/member_com_Info")
    public ModelAndView com_Info(HttpSession session) {
        ModelAndView view = new ModelAndView();
        Integer peo_id = (Integer) session.getAttribute("peo_id");
        people people = peopleService.findPeopleById(peo_id);
        view.addObject("people",people);
        Integer com_id = (Integer) session.getAttribute("com_id");
        comm comm = commService.getCommById(com_id);
        return getModelAndView(com_id, view, comm);
    }

}
