package com.chen.until;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/*登陆之类的判断*/

@Component
public class judge {


    /*密码判断*/
    public boolean judgePassword(String password,HttpSession session){
        String pass = (String) session.getAttribute("password");
        if (password.equals(pass)) {
            return true;
        }
        else return false;
    }

    /*验证码判断*/

    public boolean judgeCode(String code,HttpSession session){
        String num = (String)session.getAttribute("imgCode");
        System.out.println(num);
        System.out.println(num.equalsIgnoreCase(code));
        if (num.equalsIgnoreCase(code)) return true;

        else return false;
    }
}
