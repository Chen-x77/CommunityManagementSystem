package com.chen.controller.admin;

import com.chen.entity.activity;
import com.chen.entity.people;
import com.chen.service.activity.activityService;
import com.chen.service.people.peopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class activityController_admin {

    @Autowired
    private activityService activityService;
    @Autowired
    private peopleService peopleService;

    //未审批活动列表
    @GetMapping("/admin_fin_act_W")
    public ModelAndView admin_fin_act_W() {
        ModelAndView view = new ModelAndView();
        view.setViewName("admin/find_State0_ActivityList");
        Integer state = 0;
        List<activity> activityList = activityService.findActivityListByState(state);
        System.out.println(activityList);
        view.addObject("activityList", activityList);
        return view;
    }

    //已审批活动列表
    @GetMapping("/admin_fin_act")
    public ModelAndView admin_fin_act() {
        ModelAndView view = new ModelAndView();
        view.setViewName("admin/find_State1_ActivityList");
        Integer state = 1;
        List<activity> activityList = activityService.findActivityListByState(state);
        System.out.println(activityList);
        view.addObject("activityList", activityList);
        return view;
    }

    //活动批复
    @GetMapping("/ReplyActivity")
    public ModelAndView ReplyActivity(HttpServletRequest req) {
        Integer activity_id = Integer.parseInt(req.getParameter("activity_id"));
        ModelAndView view = new ModelAndView();
        System.out.println("activity_id:" + activity_id);
        view.addObject("activity_id", activity_id);
        view.setViewName("admin/reply_Activity");
        return view;
    }

    //活动批复处理
    @PostMapping("/replyActivityFrom")
    public ModelAndView replyActivityFrom(Integer activity_id, String reply) {
        ModelAndView view = new ModelAndView();
        view.setViewName("admin/find_State0_ActivityList");
        Integer state = 1;
        activity activity = activityService.findCommActivityById(activity_id);
        System.out.println(reply);
        activity.setReply(reply);
        activity.setState(state);
        Boolean flag = activityService.updataActivity(activity);//修改状态和审批意见
        if (flag) {
            view.addObject("msg", "活动批复成功！");
        } else {
            view.addObject("msg", "活动批复失败！");
        }
        state = 0;
        List<activity> activityList = activityService.findActivityListByState(state);
        System.out.println(activityList);
        view.addObject("activityList", activityList);
        return view;
    }

    //活动查看
    @GetMapping("/ChaKan_Activity_Admin")
    public ModelAndView ChaKan_Activity_Admin(HttpServletRequest req) {
        Integer activity_id = Integer.parseInt(req.getParameter("activity_id"));
        ModelAndView view = new ModelAndView();
        activity activity = activityService.findCommActivityById(activity_id);
        System.out.println("查看活动" + activity);
        people people = peopleService.findPeopleById(activity.getPeo_id());
        activity.setPeoPhone(people.getPhone());
        view.addObject("activity", activity);
        view.setViewName("admin/ChaKan_Activity");
        return view;
    }

    //根据活动名查询
    @GetMapping("/queryActivityName")
    public ModelAndView queryCommActivitName(String flag, String activityName) {
        ModelAndView view = new ModelAndView();
        System.out.println("flag:"+flag);
        Integer state=1;
        view.setViewName("admin/find_State1_ActivityList");
       if (flag.equals("0")) {
            view.setViewName("admin/find_State0_ActivityList");
            state = 0;
        }
        List<activity> activityList = activityService.findActivityListByNameState(activityName,state);
        System.out.println(activityList);
        view.addObject("activityList", activityList);
        return view;
    }
}
