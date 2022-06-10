package com.chen.entity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/*系统管理员*/
@Data
@Entity
public class people {
    @Id
    private Integer id;  //id
    private String userName;//账号
    private String passWord;//密码
    private String name;  // 姓名
    private Integer college;//所属学院 （*外键 联级删除为set null）
    private String phone;//手机
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;//加入时间
    private Integer flag;    //成员权限 //1社长，0其他
    private String name_class;//班级
    private String wx;//微信
    //所属社团  联级删除为 set null。（具体社团主表的删除方法 把从表成员的com_id设置为暂无）
    private Integer com_id;
    //增加属性
    private String flagName;   //权限名 是否社长
    private String comName;    //所属社团名称
    private String collegeName; //所属学院
    private String officeName;//部门名称
    private String officePosition;//职位名称
}
