package com.geek.action;

import com.geek.entity.SecondNavigation;
import com.geek.service.SecondNavigationService;
import com.geek.util.Result;
import com.geek.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.Request;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hetiantian
 */
@Controller
public class SecondNavigationAction {

    //二级导航栏服务类
    @Autowired
    private SecondNavigationService secondNavigationService;


    @RequestMapping(value = "/batchDeleteSecondNavigation", method = RequestMethod.POST)
    @ResponseBody
    public Result batchDeleteSecondNavigation(@RequestParam("CheckedList") List<Integer> secondNavigationIds) {
        System.out.println(secondNavigationIds);
        secondNavigationService.batchDeleteSecondNavigation(secondNavigationIds);
        System.out.println("执行了批量删除以后");
        return ResultUtil.successResult(null);
    }

    @RequestMapping(value = "/deleteSecondNavigation", method = RequestMethod.GET)
    @ResponseBody
    public Result deleteSecondNavigation(Integer secondNavigationId) {
        secondNavigationService.deleteSecondNavigation(secondNavigationId);
        return ResultUtil.successResult(null);
    }

    @RequestMapping(value = "/insertSecondNavigation", method = RequestMethod.GET)
    @ResponseBody
    public Result insertSecondNavigation(Integer firstNavigationId) {
        secondNavigationService.insertSecondNavigation(firstNavigationId);
        return ResultUtil.successResult(null);
    }

    @RequestMapping(value = "/updateSecondNavigation", method = RequestMethod.GET)
    @ResponseBody
    public Result updateSecondNavigation(SecondNavigation secondNavigation) {
        secondNavigationService.updateSecondNavigation(secondNavigation);
        return ResultUtil.successResult(null);
    }

    @RequestMapping(value = "/selectSecondNavigationByName", method = RequestMethod.GET)
    @ResponseBody
    public Result selectSecondNavigationByName(@RequestParam ("keyWord")String secondNavigationName) {
        System.out.println("start");
        System.out.println("sname: " + secondNavigationName);
        List<SecondNavigation> secondNavigationList = secondNavigationService.selectSecondNavigationByName(secondNavigationName);
        return ResultUtil.successResult(secondNavigationList);
    }


    @RequestMapping(value = "/querySecondNavigationByPage", method = RequestMethod.GET)
    @ResponseBody
    public Result querySecondNavigationByPage(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize) {
        System.out.println("success...1");
        int total = secondNavigationService.selectTotalSecondNavigation();
        System.out.println("total: " + total);
        List<SecondNavigation> data = secondNavigationService.selectAllSecondNavigation(pageNo, pageSize);
        return ResultUtil.successPagedResult(data,total);
    }

    @RequestMapping(value = "/deleteAllSecondNavigation", method = RequestMethod.GET)
    @ResponseBody
    public Result deleteAllSecondNavigation() {
        secondNavigationService.deleteAllSecondNavigation();
        return ResultUtil.successResult(null);
    }

    @RequestMapping(value = "/insertArticleContent", method = RequestMethod.POST)
    @ResponseBody
    public Result insertArticleContent( SecondNavigation secondNavigation) {
        System.out.println(secondNavigation.getArticleContent());
        System.out.println(secondNavigation.getArticleTitle());
        secondNavigationService.insertArticleContent(secondNavigation);
        return ResultUtil.successResult(null);
    }

    @RequestMapping(value = "/selectSecondNavigations", method = RequestMethod.GET)
    @ResponseBody
    public Result selectSecondNavigations(@RequestParam("firstNavigationName") String firstNavigationName) {
        List<SecondNavigation> secondNavigationList = secondNavigationService.selectSecondNavigations(firstNavigationName);
        return ResultUtil.successResult(secondNavigationList);
    }

    @RequestMapping(value = "/selectSecondNavigation", method = RequestMethod.GET)
    @ResponseBody
    public Result selectSecondNavigation(@RequestParam("secondNavigationName") String secondNavigationName) {
        System.out.println("s" + secondNavigationName);
        SecondNavigation secondNavigationList = secondNavigationService.selectSecondNavigation(secondNavigationName);
        return ResultUtil.successResult(secondNavigationList);
    }

    @RequestMapping(value = "/insertSecondNavigationPicture", method = RequestMethod.GET)
    @ResponseBody
    public Result insertSecondNavigationPicture(@RequestParam("picture") MultipartFile picture) throws IOException {
        String pictureUrl = secondNavigationService.insertSecondNavigationPicture(picture);
        return ResultUtil.successResult(pictureUrl);
    }

}
