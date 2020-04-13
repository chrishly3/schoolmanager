package com.schoolmanager.controller.adminLogin;


import com.schoolmanager.entity.SchoolUserinfo;
import com.schoolmanager.service.SchoolUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utils.HttpCode.R;

import java.util.Map;

@RequestMapping("/login")
@RestController
public class AdminLoginController {

   @Autowired
   private SchoolUserInfoService userInfoService;

   @RequestMapping(value = "/getlogin",method = RequestMethod.POST)
   public R login(@RequestParam String userName,
                  @RequestParam String passWord) {
      //先查询数据库根据用户
      if(userName == null && passWord == null){
         return R.error();
      }
//String md5PassWord = Md5Utils.getMD5(passWord);
      R result = userInfoService.getPersonExist(userName,passWord);
      return result;
   }


}
