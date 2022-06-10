package com.chen.controller.centen;

import com.chen.entity.office;
import com.chen.entity.people;
import com.chen.service.office.officeService;
import com.chen.service.people.peopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class officeController {
    @Autowired
    peopleService peopleService;
    @Autowired
    officeService officeService;
    //去添加页面
    @RequestMapping("/centen_add_office")
    public String centen_find_office() {
        return "centen/add_Office";
    }
    //添加提交
    @PostMapping("/addCommOfficeFrom")
    public ModelAndView addCommOfficeFrom(String userName, office office, HttpSession session) {
        Integer com_id = (Integer) session.getAttribute("com_id");
        ModelAndView view = new ModelAndView();
        people people = peopleService.findPeopleByUserName(userName);
        System.out.println(com_id);
        if (people == null || people.getCom_id() != com_id) {
            view.addObject("msg", "请输入正确的本社成员账号！");
            view.setViewName("centen/add_Office");
            return view;
        }
        if(officeService.finCommOfficeBypeoId(people.getId()) != null){
            view.addObject("msg", "该成员已有任职信息！");
            view.setViewName("centen/add_Office");
            return view;
        }
        office.setCom_id(com_id);
        office.setPeo_id(people.getId());
        System.out.println(office);
        officeService.addCommOffice(office);
        List<office> officeList = officeService.finCommOfficeList(com_id);
        view.addObject("officeList", officeList);
        view.addObject("msg","添加成功");
        view.setViewName("centen/find_Office");
        return view;
    }

    //查看部门 centen_find_office
    @RequestMapping("/centen_find_office")
    public String centen_find_office(Model model, HttpSession session) {
        Integer com_id = (Integer) session.getAttribute("com_id");
        List<office> officeList = officeService.finCommOfficeList(com_id);
        model.addAttribute("officeList", officeList);
        return "centen/find_Office";
    }

    //删除部门
    @RequestMapping("/delOffice_centen")
    public ModelAndView delOffice_centen(HttpServletRequest req,HttpSession session) {
        Integer id = Integer.parseInt(req.getParameter("officeId"));
        ModelAndView view = new ModelAndView();
        view.setViewName("centen/find_Office");
        if (officeService.delCommOffice(id)) {
            view.addObject("msg", "删除成功");
        } else {
            view.addObject("msg", "删除失败");
        }
        Integer com_id=(Integer) session.getAttribute("com_id");
        List<office> officeList = officeService.finCommOfficeList(com_id);
        view.addObject("officeList", officeList);
        return view;
    }
}
