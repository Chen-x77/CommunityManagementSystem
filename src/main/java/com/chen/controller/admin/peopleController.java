package com.chen.controller.admin;
import com.chen.entity.college;
import com.chen.entity.comm;
import com.chen.entity.office;
import com.chen.entity.people;
import com.chen.service.collegeService;
import com.chen.service.comm.commService;
import com.chen.service.loginService;
import com.chen.service.office.officeService;
import com.chen.service.people.peopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class peopleController {
    @Autowired
    private peopleService peopleService;
    @Autowired
    private officeService officeService;
    @Autowired
    private commService commService;
    @Autowired
    private collegeService collegeService;
    public void setFlagName(List<people> peopleList) {
        for (int i = 0; i < peopleList.size(); i++) {
            if (peopleList.get(i).getFlag() == 1) {
                peopleList.get(i).setFlagName("社长");
            } else{
                peopleList.get(i).setFlagName("普通成员");
            }
        }
    }
    public void setFlagName(people people) {
        //塞入其他属性
        System.out.println("塞入属性");
        Integer CommId=people.getCom_id();
        System.out.println("社团ID");
        comm comm=commService.getCommById(CommId);
        System.out.println("找到社团"+comm);
        String ComName=comm.getName();
        System.out.println(ComName);
        people.setComName(ComName);
        Integer collegeId=people.getCollege();
        System.out.println(collegeId);
        college college=collegeService.getCollegeById(collegeId);
        System.out.println("找到学院"+college);
        people.setCollegeName(college.getName());
        if (people.getFlag() == 1) {
            people.setFlagName("社长");
        } else {
            people.setFlagName("普通成员");
        }
    }
    //会员查看(不包含普通用户)
    @RequestMapping("/com_fin_stu")
    public String com_fin_stu(Model model) {
        List<people> peopleList = peopleService.findPeopleList();
        System.out.println(peopleList);
        setFlagName(peopleList);
        model.addAttribute("peopleList", peopleList);
        return "admin/find_People";
    }
    @GetMapping("/queryPeople")
    public ModelAndView queryPeople(String commName) {
        System.out.println("进入查询成员方法" + commName);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/find_People");
        //如果输入为null则返回所有成员
        if (commName == null) {
            List<people> peopleList = peopleService.findPeopleList();
            setFlagName(peopleList);
            mv.addObject("peopleList", peopleList);
            return mv;
        }
        comm comm = commService.findComm(commName);
        if (comm != null) {
            Integer com_id = comm.getId();
            //查询该社团所有成员
            List<people>  peopleList = peopleService.queryPeopleList(com_id);
            setFlagName(peopleList);
            mv.addObject("peopleList", peopleList);
        } else {
            List<people> peopleList = peopleService.findPeopleList();
            setFlagName(peopleList);
            mv.addObject("peopleList", peopleList);
            mv.addObject("msg", "请输入正确的社团名称!");
        }
        return mv;
    }

    //删除成员 （comm表关联表office people）
    @GetMapping("/delPeople")
    public ModelAndView delComm(HttpServletRequest req) {
        System.out.println("进入删除方法");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin/find_People");
        Integer peoId = Integer.parseInt(req.getParameter("peopleId"));
        Integer peoFlag = Integer.parseInt(req.getParameter("peopleFlag"));
        System.out.println("peoId:"+peoId +"peoFlag:"+peoFlag);
        //删除
        List<office> list =officeService.finCommOfficeBypeoId(peoId);
        if (peoFlag == 1 || !list.isEmpty()) {
            System.out.println("officeService"+list);
            mv.addObject("msg", "该成员有任职信息不可删除");
            return mv;
        }
        if (peopleService.delCommPeople(null, peoId)) {
            mv.addObject("msg", "删除成功");
        } else {
            mv.addObject("msg", "删除失败");
        }
        List<people> peopleList = peopleService.findPeopleList();
        setFlagName(peopleList);//添加职位信息
        mv.addObject("peopleList", peopleList);
        return mv;
    }
    //查看人员信息
    @RequestMapping("/ChaKanPeople")
    public String ChakanPeopleComm(HttpServletRequest req, Model model) {
        String userName = req.getParameter("userName");
        System.out.println(userName);
        people people = peopleService.findPeopleByUserName(userName);
        System.out.println(people);
        setFlagName(people);
        model.addAttribute("people", people);
        return "admin/ChaKanPeople";
    }
}
