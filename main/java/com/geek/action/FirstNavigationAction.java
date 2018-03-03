package com.geek.action;

import com.geek.entity.FirstNavigation;
import com.geek.entity.SecondNavigation;
import com.geek.service.FirstNavigationService;
import com.geek.util.Result;
import com.geek.util.ResultUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author hetiantian
 */
@Controller
public class   FirstNavigationAction {

    //一级导航栏服务类
    @Autowired
    private FirstNavigationService firstNavigationService;

    @RequestMapping(value = "/selectAllFirstNavigationName", method = RequestMethod.GET)
    @ResponseBody
    public Result selectAllFirstNavigationName() {
         List<FirstNavigation> firstNavigationList = firstNavigationService.selectAllFirstNavigationName();
         System.out.println("firstNavigationService一级导航: " + firstNavigationService);
         return ResultUtil.successResult(firstNavigationList);
    }

    @RequestMapping(value = "/selectAllSecondNavigationById", method = RequestMethod.GET)
    @ResponseBody
    public Result selectAllSecondNavigation() {
        List<SecondNavigation> secondNavigations = firstNavigationService.selectAllSecondNavigationById();
        return ResultUtil.successResult(secondNavigations);
    }

    @RequestMapping(value ="/insertFirstNavigation", method = RequestMethod.GET)
    @ResponseBody
    public Result insertFirstNavigation(FirstNavigation firstNavigation) {
        firstNavigationService.insertFirstNavigation(firstNavigation);
        return ResultUtil.successResult(null);
    }

    @RequestMapping(value = "/deleteFirstNavigation", method = RequestMethod.GET)
    @ResponseBody
    public Result deleteFirstNavigation(Integer firstNavigationId) {
        firstNavigationService.deleteFirstNavigation(firstNavigationId);
        return ResultUtil.successResult(null);
    }

    @RequestMapping(value="/batchDeleteFirstNavigation", method = RequestMethod.GET)
    @ResponseBody
    public Result batchDeleteFirstNavigation(List<FirstNavigation>firstNavigationList) {
        firstNavigationService.batchDeleteFirstNavigation(firstNavigationList);
        return ResultUtil.successResult(null);
    }

    @RequestMapping(value = "/updateFirstNavigation", method = RequestMethod.GET)
    public Result updateFirstNavigation(FirstNavigation firstNavigation) {
        firstNavigationService.updateFirstNavigation(firstNavigation);
        return ResultUtil.successResult(null);
    }

    @RequestMapping(value = "/selectFirstNavigationAndSecondNavigation", method = RequestMethod.GET)
    @ResponseBody
    public Result selectFirstNavigationAndSecondNavigation(@RequestParam("secondNavigationName") String secondNavigationName) {
        FirstNavigation firstNavigation = firstNavigationService.selectFirstNavigationAndSecondNavigation(secondNavigationName);
        return ResultUtil.successResult(firstNavigation);
    }

}
