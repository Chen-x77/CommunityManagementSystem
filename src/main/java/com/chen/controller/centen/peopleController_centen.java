package com.chen.controller.centen;

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
public class peopleController_centen {
    @Autowired
    private commService commService;
    @Autowired
    private peopleService peopleService;
    @Autowired
    private applycommService applycommService;
    @Autowired
    private officeService officeService;
    @Autowired
    private activityService activityService;
    /*信息主页**/
    @RequestMapping("/centen_index")
    public ModelAndView comIndex(HttpSession session) {
        ModelAndView view = new ModelAndView();
        view.setViewName("centen/index");
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
        view.addObject("applySum", applySum); //入社请求数
        view.addObject("activitySum0", activitySum0);  //未审批活动数
        view.addObject("commList", commList);  //社团列表
        return view;
    }

    //增加会员
    @RequestMapping("/centen_add_stu")
    public String centen_add_stu(Model model, HttpSession session) {
        Integer com_id = (Integer) session.getAttribute("com_id");
        //通过社团号去找列表 comName peoName peoUserName peoPhone
        List<applycomm> applycommList = applycommService.finApplycommList(com_id);
        System.out.println(applycommList);
        model.addAttribute("applycommList", applycommList);
        return "centen/find_Add_People";
    }

    //拒绝入社
    @GetMapping("/centen_Refuse_applycomm")
    public ModelAndView centen_refuse_applycomm(HttpServletRequest req) {
        ModelAndView view = new ModelAndView();
        view.setViewName("centen/find_Add_People");
        Integer com_id = Integer.parseInt(req.getParameter("com_id"));
        Integer apply_id = Integer.parseInt(req.getParameter("apply_id"));
        applycommService.delApplycomm(apply_id); //删除申请记录
        List<applycomm> applycommList = applycommService.finApplycommList(com_id);
        view.addObject("applycommList", applycommList);
        view.addObject("msg", "已拒绝！");
        return view;
    }

    //同意
    @GetMapping("/centen_Agree_applycomm")
    public ModelAndView centen_Agree_applycomm(HttpServletRequest req) {
        ModelAndView view = new ModelAndView();
        view.setViewName("centen/find_Add_People");
        //peo_id=${applycomm.peo_id}&com_id=${applycomm.com_id}&apply_id=${applycomm.id}
        Integer peo_id = Integer.parseInt(req.getParameter("peo_id"));
        Integer com_id = Integer.parseInt(req.getParameter("com_id"));
        Integer apply_id = Integer.parseInt(req.getParameter("apply_id"));
        System.out.println("pid:" + peo_id + "  cid:" + com_id + " aid:" + apply_id);
        people people = peopleService.findPeopleById(peo_id);
        people.setCom_id(com_id);
        peopleService.updatePeople(people); //修该社团id
        applycommService.delApplycomm(apply_id); //删除申请记录
        List<applycomm> applycommList = applycommService.finApplycommList(com_id);
        view.addObject("applycommList", applycommList);
        view.addObject("msg", "添加成功");
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
    @RequestMapping("/centen_find_stu")
    public String centen_find_stu(Model model, HttpSession session) {
        Integer com_id = (Integer) session.getAttribute("com_id");
        List<people> peopleCommList = peopleService.queryPeopleList(com_id);
        setOfficeName(peopleCommList);  //没有职位塞入普通成员属性
        model.addAttribute("peopleList", peopleCommList);
        return "centen/find_People";
    }

    //删除成员 （comm表关联表office people）
    @GetMapping("/delPeople_centen")
    public ModelAndView delComm(HttpServletRequest req) {
        System.out.println("进入删除方法");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("centen/find_People");
        Integer peoId = Integer.parseInt(req.getParameter("peopleId"));
        Integer peoFlag = Integer.parseInt(req.getParameter("peopleFlag"));
        if (peoFlag == 1 || !officeService.finCommOfficeBypeoId(peoId).isEmpty()) {
            mv.addObject("msg", "该成员有任职信息不可删除");
            return mv;
        }
        if (peopleService.delCommPeople(null, peoId)) {
            mv.addObject("msg", "删除成功");
        } else {
            mv.addObject("msg", "删除失败");
        }
        List<people> peopleList = peopleService.findPeopleList();
        setOfficeName(peopleList);//添加职位信息
        mv.addObject("peopleList", peopleList);
        return mv;
    }

    //查看人员信息
    @RequestMapping("/ChaKanPeople_centen")
    public String ChakanPeopleComm(HttpServletRequest req, Model model) {
        Integer peo_id = Integer.parseInt(req.getParameter("peo_id"));
        String userName = peopleService.findPeopleById(peo_id).getUserName();
        System.out.println(userName);
        people people = peopleService.findPeopleByUserName(userName);
        setOfficeName(people);          //没有职位塞入普通成员属性
        System.out.println(people);
        model.addAttribute("people", people);
        return "centen/ChaKanPeople";
    }

    //根据姓名查找成员
    @GetMapping("/queryPeople_centen")
    public String queryPeople_centen(String peopleName, HttpSession session, Model model) {
        Integer com_id = (Integer) session.getAttribute("com_id");
        List<people> peopleCommList = peopleService.queryCommPeopleListByName(com_id, peopleName);
        setOfficeName(peopleCommList);
        model.addAttribute("peopleList", peopleCommList);
        return "centen/find_People";
    }


}
