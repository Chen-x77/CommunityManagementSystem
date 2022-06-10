package com.chen.controller.centen;

import com.chen.entity.activity;
import com.chen.service.activity.activityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class activityController {

    @Autowired
    private activityService activityService;

    //添加活动
    @RequestMapping("/centen_act_new")
    public String centen_act_new() {
        return "centen/add_Activity";
    }
    /*addActivityForm*/

    @PostMapping("/addActivityForm")
    public ModelAndView addActivityForm(activity activity,HttpSession session) {
         Integer com_id = (Integer) session.getAttribute("com_id");
         Integer peo_id = (Integer) session.getAttribute("peo_id");
         ModelAndView view = new ModelAndView();
         System.out.println(activity.getDate_start());
         view.setViewName("centen/find_ActivityList");
         activity.setCom_id(com_id);
         activity.setPeo_id(peo_id);
         activity.setDate(new Date());
         activity.setState(0);//0为未批复
         System.out.println(activity);
         if(activityService.addCommActivity(activity)){
             view.addObject("msg","活动申请成功，等待管理员批复");
         }else{
             view.addObject("msg","活动申请失败!");
         }
         List<activity> activityList = activityService.findCommActivityList(com_id);
         System.out.println(activityList);
         view.addObject("activityList", activityList);
         return view;
    }

    //活动记录
    @RequestMapping("/centen_findActivity")
    public ModelAndView centen_findActivity(HttpSession session) {
        Integer com_id = (Integer) session.getAttribute("com_id");
        ModelAndView view = new ModelAndView();
        view.setViewName("centen/find_ActivityList");
        System.out.println("com_id: " + com_id);
        List<activity> activityList = activityService.findCommActivityList(com_id);
        System.out.println(activityList);
        view.addObject("activityList", activityList);
        return view;

    }

    //活动详细信息
    @GetMapping("ChaKanActivity_centen")
    public ModelAndView ChaKanActivity_centen(HttpServletRequest req) {
        Integer activity_id = Integer.parseInt(req.getParameter("activity_id"));
        ModelAndView view = new ModelAndView();
        activity activity = activityService.findCommActivityById(activity_id);
        System.out.println("查看活动" + activity);
        view.addObject("activity", activity);
        view.setViewName("centen/ChaKan_activity");
        return view;
    }

    //删除活动
    @GetMapping("/delActivity_centen")
    public ModelAndView delActivit_centen(HttpServletRequest req, HttpSession session) {
        Integer com_id = (Integer) session.getAttribute("com_id");
        ModelAndView view = new ModelAndView();
        view.setViewName("centen/find_ActivityList");
        Integer activit_id = Integer.parseInt(req.getParameter("activity_id"));
        System.out.println("activity_id: " + activit_id);
        if (activityService.delCommActivityById(activit_id)) {
            view.addObject("msg", "删除成功");
        } else {
            view.addObject("msg", "删除失败");
        }
        List<activity> activityList = activityService.findCommActivityList(com_id);
        view.addObject("activityList", activityList);
        return view;
    }

    //根据活动名查询
    @GetMapping("/queryCommActivityName")
    public ModelAndView queryCommActivitName(HttpSession session, String activityName) {
        Integer com_id = (Integer) session.getAttribute("com_id");
        ModelAndView view = new ModelAndView();
        view.setViewName("centen/find_ActivityList");
        System.out.println("com_id: " + com_id+"name："+activityName);
        List<activity> activityList = activityService.queryCommActivityList(com_id, activityName);
        view.addObject("activityList", activityList);
        return view;
    }
}
