package com.chen.controller.member;
import com.chen.entity.activity;
import com.chen.service.activity.activityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class activityControlle_member {

    @Autowired
    private activityService activityService;

    //活动记录
    @RequestMapping("/member_findActivity")
    public ModelAndView centen_findActivity(HttpSession session) {
        Integer com_id = (Integer) session.getAttribute("com_id");
        ModelAndView view = new ModelAndView();
        view.setViewName("member/find_ActivityList");
        System.out.println("com_id: " + com_id);
        List<activity> activityList = activityService.findCommActivityList(com_id);
        System.out.println(activityList);
        view.addObject("activityList", activityList);
        return view;

    }

    //活动详细信息
    @GetMapping("/ChaKanActivity_member")
    public ModelAndView ChaKanActivity_centen(HttpServletRequest req) {
        Integer activity_id = Integer.parseInt(req.getParameter("activity_id"));
        ModelAndView view = new ModelAndView();
        activity activity = activityService.findCommActivityById(activity_id);
        System.out.println("查看活动" + activity);
        view.addObject("activity", activity);
        view.setViewName("member/ChaKan_activity");
        return view;
    }


    //根据活动名查询
    @GetMapping("/queryCommActivityName_member")
    public ModelAndView queryCommActivitName(HttpSession session, String activityName) {
        Integer com_id = (Integer) session.getAttribute("com_id");
        ModelAndView view = new ModelAndView();
        view.setViewName("member/find_ActivityList");
        System.out.println("com_id: " + com_id+"name："+activityName);
        List<activity> activityList = activityService.queryCommActivityList(com_id, activityName);
        view.addObject("activityList", activityList);
        return view;
    }
}
