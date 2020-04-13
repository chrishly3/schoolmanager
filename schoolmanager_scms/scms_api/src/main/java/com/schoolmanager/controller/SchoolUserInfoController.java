package com.schoolmanager.controller;



import com.github.pagehelper.PageInfo;
import com.schoolmanager.entity.QueryUser;
import com.schoolmanager.entity.SchoolUserinfo;
import com.schoolmanager.service.SchoolUserInfoService;
import org.hibernate.annotations.Parameter;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import utils.HttpCode.R;

import java.util.HashMap;
import java.util.List;


@RequestMapping("/userinfo")
@RestController
@CrossOrigin

public class SchoolUserInfoController {

    @Autowired
    private SchoolUserInfoService userInfoService;
    private final Logger logger = LoggerFactory.getLogger(SchoolUserInfoController.class);

    /**
     * 编辑用户信息
     */
    @PostMapping("updateUserInfo/{id}")
    public R editUser(@PathVariable String id,@RequestBody SchoolUserinfo schoolUserinfo){
        System.out.println(schoolUserinfo.toString());
        int row=userInfoService.editUser(schoolUserinfo);
        if(row==1){
            return R.ok();
        }else {
            return R.error();
        }
    }

    /**
     * 添加用户的方法
     * @param schoolUserinfo
     * @return 是否添加成功
     */
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public R addSchoolUser(@RequestBody SchoolUserinfo schoolUserinfo) {
        System.err.println(schoolUserinfo.getUserName());
        System.err.println(schoolUserinfo.getUserType());
        logger.info("SchoolUserInfoController-addUser-schoolUserinfo",schoolUserinfo.getUserName());
        int save = userInfoService.saveUser(schoolUserinfo);
        if(save==1) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @GetMapping("getUserInfo/{id}")
    public R getUserInfo(@PathVariable String id) {
        SchoolUserinfo user = userInfoService.getUserById(id);
        return R.ok().data("user",user);
    }

    /**
     * 带条件分页查询
     * @param queryUser
     * @param page
     * @param pageSize
     * @return
     */
    @PostMapping("moreCondtionPageList/{page}/{pageSize}")
    public  R showUsers(@PathVariable Integer page, @PathVariable Integer pageSize,
                        @RequestBody(required = false) QueryUser queryUser){
        PageInfo<SchoolUserinfo>  pageList = userInfoService.showUsers(page, pageSize);
       String userName = queryUser.getUserName();
        System.out.println(userName);
       String userType = queryUser.getUserType();
        if(userName != null || userType != null) {
            pageList = userInfoService.selectUserLike("%"+userName+"%",page, pageSize,"%"+userType+"%");
        }
        System.out.println(pageList);
        return R.ok().data("items",pageList);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public R removeById(@PathVariable String id){
        Integer delete= userInfoService.removeById(id);
        System.out.println(delete);
        if(delete.equals(1)){
            return R.ok();
        }else {
            return R.error();
        }
    }

    /**
     * 测试controller是否可行
     * @return
     */
    @RequestMapping(value = "/caseTest1",method = RequestMethod.GET)
    public String caseTest(){
        return  "111";
    }

    /**
     * 查询所有用户（测试）
     * @return
     */
    @GetMapping("/list")
    public R getAllUserList() {
        //调用service的方法
        List<SchoolUserinfo> list = userInfoService.listUser();
        return R.ok().data("items",list);
    }

}
