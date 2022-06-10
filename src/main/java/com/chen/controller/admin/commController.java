package com.chen.controller.admin;

import com.chen.entity.activity;
import com.chen.entity.college;
import com.chen.entity.comm;
import com.chen.entity.people;
import com.chen.service.activity.activityService;
import com.chen.service.comm.commService;
import com.chen.service.loginService;
import com.chen.service.people.peopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class commController {
    @Autowired
    private loginService loginService;
    @Autowired
    private commService commService;
    @Autowired
    private com.chen.service.activity.activityService activityService;
    @Autowired
    private peopleService peopleService;

    /*信息主页**/
    @RequestMapping("/com_index")
    public ModelAndView comIndex() {
        ModelAndView view = new ModelAndView();
        view.setViewName("admin/index");
        System.out.println("/com_index");
        Integer state = 0;
        List<activity> activityList = activityService.findActivityListByState(state);
        System.out.println(activityList);
        List<comm> commList = commService.findCommList();
        int commSum = commList.size();
        int memberSum = peopleService.findPeopleList().size();
        int activitySum1 = activityService.findActivityListByState(1).size();
        int activitySum0 = activityService.findActivityListByState(0).size();
        view.addObject("activityList", activityList);
        view.addObject("commSum", commSum); //社团数
        view.addObject("memberSum", memberSum);//会员数
        view.addObject("activitySum1", activitySum1); //已审批活动数
        view.addObject("activitySum0", activitySum0);  //未审批活动数
        view.addObject("commList", commList);  //社团列表
        return view;
    }

    @GetMapping("/admin_Index_ChaKanComm")
    public ModelAndView admin_Index_ChaKanComm(HttpServletRequest req) {
        ModelAndView view = new ModelAndView();
        view.setViewName("admin/ChanKan_Comm");
        Integer id = Integer.parseInt(req.getParameter("commId"));
        System.out.println("admin_Index_ChaKanComm:" + id);
        people people = peopleService.findPeopleByFlag(id, 1);//查找社团负责人
        view.addObject("people", people);
        comm comm = commService.getCommById(id);
        System.out.println(comm);
        view.addObject("comm", comm);
        return view;
    }

    //去添加社团页面
    @RequestMapping("/com_add_com")
    public String comAddComm(Model model) {
        List<college> collegeList = loginService.finCollegesList();
        model.addAttribute("collegeList", collegeList);
        return "admin/add_community";
    }

    //添加社团
    @RequestMapping("/addcommFrom")
    public ModelAndView comAddCommFrom(String name, String peoUserName, comm comm) {
        System.out.println("进入");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/find_Comm");
        people people = peopleService.findPeopleByUserName(peoUserName);
        System.out.println("负责人是:" + people);
        System.out.println("社团成立日期:" + comm.getDate());
        if (people != null) {
            comm.setPeoName(people.getName());
            comm findComm = commService.findComm(name);
            if (findComm == null) {
                if (commService.addComm(comm)) {
                    mv.addObject("msg", "创建成功");
                } else {
                    mv.addObject("msg", "创建失败，请填写完整资料");
                }
            } else {
                System.out.println("该社团名已存在");
                mv.addObject("msg", "该社团名已存在");
            }
        } else {
            mv.addObject("msg", "负责人账号填写错误!");
        }
        //社团添加后更改负责人信息
        people.setFlag(1);      //设置权限为1
        people.setFlagName("社长");
        people.setCom_id(commService.findComm(name).getId());
        if (peopleService.updatePeople(people)) {
            System.out.println("添加社长成功");
        } else {
            System.out.println("添加社长失败");
        }
        List<comm> commList = commService.findCommList();
        setPeoName(commList);
        mv.addObject("commList", commList);
        return mv;
    }

    public void  setPeoName(List<comm> commList){
        for (int i = 0; i < commList.size(); i++) {
            Integer com_id = commList.get(i).getId();
            List<people> list = peopleService.queryPeopleList(com_id);
            for (int j=0; j<list.size();j++){
                people people=list.get(j);
                if(people.getFlag()==1){
                    commList.get(i).setPeoName(people.getName());
                }
            }
        }
    }
    //社团查看
    @RequestMapping("/com_record")
    public String com_Record(Model model) {
        List<comm> commlist = commService.findCommList();
        setPeoName(commlist);
        model.addAttribute(commlist);
        System.out.println(commlist);
        return "admin/find_Comm";
    }

    //删除社团 （comm表关联表office people）
    @GetMapping("/delComm")
    public ModelAndView delComm(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/find_Comm");
        Integer commId = Integer.parseInt(req.getParameter("commId"));
        people people = peopleService.findPeopleByFlag(commId, 1);
        people.setFlag(0);
        people.setCom_id(null);
        if (commService.delComm(commId) && peopleService.updatePeople(people)) {
            mv.addObject("msg", "删除成功");
        } else {
            mv.addObject("msg", "删除失败");
        }
        List<comm> commList = commService.findCommList();
        setPeoName(commList);
        mv.addObject("commList", commList);
        return mv;
    }

    //修改社团信息
    @RequestMapping("/setComm")
    public String updataComm(HttpServletRequest req, Model model) {
        String commId = req.getParameter("commId");
        Integer id = Integer.parseInt(commId);
        Integer flag = 1;
        people people = peopleService.findPeopleByFlag(id, flag);//查找社团负责人
        model.addAttribute("people", people);
        comm comm = commService.getCommById(id);
        System.out.println(comm);
        model.addAttribute("comm", comm);
        return "admin/update_Comm";
    }

    //修改社团方法
    @PostMapping("/setCommFrom")
    public ModelAndView updataCommFrom(comm comm, String userName) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/admin/find_Comm");
        System.out.println("userName:" + userName);
        people people = peopleService.findPeopleByUserName(userName);
        System.out.println(people);
        if (people == null) {
            mv.addObject("msg", "修改失败，请填写正确的社团负责人账号！");
            return mv;
        }
        //如需修改社长
        people peopleFalg = peopleService.findPeopleByFlag(comm.getId(), 1);  //可能找不到社长
        System.out.println("peopleFlag" + peopleFalg);
        if (peopleFalg != null && !peopleFalg.getUserName().equals(userName)) {
            peopleFalg.setFlag(0);
            peopleService.updatePeople(peopleFalg);//修改原来的社长权限
        }
        //新社长
        people.setCom_id(comm.getId());
        people.setFlag(1);
        peopleService.updatePeople(people);
        commService.updataComm(comm);
        mv.addObject("msg", "修改成功");
        List<comm> list = commService.findCommList();
        setPeoName(list);
        mv.addObject("commList", list);
        return mv;
    }

    //查询社团成员
    @GetMapping("/queryCommFrom")
    public ModelAndView queryCommFrom(String commName) {
        ModelAndView mv = new ModelAndView();
        System.out.println("搜索社团");
        System.out.println(commName);
        List<comm> list = commService.queryCommList(commName);
        //可以创建
        setPeoName(list);
        System.out.println(list);
        mv.addObject(list);
        mv.setViewName("/admin/find_Comm");
        return mv;
    }

}
