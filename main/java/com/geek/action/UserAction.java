package com.geek.action;

import com.geek.entity.User;
import com.geek.service.UserService;
import com.geek.util.JsonUtil;
import com.geek.util.Result;
import com.geek.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserAction {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Result login(String loginName, String password, HttpServletRequest request){
        userService.login(loginName,password,request);
        return ResultUtil.successResult(null);
    }

    @RequestMapping(value = "/insertUser",method = RequestMethod.POST)
    @ResponseBody
    public Result insertUser(User user){
        userService.insertUser(user);
        return ResultUtil.successResult(null);
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    @ResponseBody
    public Result deleteUser(Integer id){
        userService.deleteUser(id);
        return ResultUtil.successResult(null);
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    @ResponseBody
    public Result updateUser(User user){
        userService.updateUser(user);
        return ResultUtil.successResult(null);
    }

    @RequestMapping(value = "/findAllUsers",method = RequestMethod.GET)
    @ResponseBody
    public Result findAllUsers(){
        List<User> users = userService.findAllUsers();
        return ResultUtil.successResult(users);
}

    @RequestMapping(value = "/deleteUsers",method = RequestMethod.GET)
    @ResponseBody
    public Result deleteUsers(String ids){
        userService.deleteUsers(ids);
        return ResultUtil.successResult(null);
    }


}
