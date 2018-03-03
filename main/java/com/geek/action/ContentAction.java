package com.geek.action;

import com.geek.entity.Content;
import com.geek.service.ContentService;
import com.geek.util.Result;
import com.geek.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * @author yuanyang
 */
@Controller
public class ContentAction {

    //内容服务类
    @Autowired
    private ContentService service;

    @ResponseBody
    @RequestMapping(value = "/insertContent",method = RequestMethod.POST)
    public Result insertContent(Content content){
        service.insertContent(content);
        return ResultUtil.successResult(null);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteContent",method = RequestMethod.GET)
    public Result deleteContent(Integer contentId){
        service.deleteContent(contentId);
        return ResultUtil.successResult(null);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteContents",method = RequestMethod.GET)
    public Result deleteContents(Integer[] contentIds){
        service.deleteContents(Arrays.asList(contentIds));
        return ResultUtil.successResult(null);
    }

    @ResponseBody
    @RequestMapping(value = "/updateContent",method = RequestMethod.POST)
    public Result updateImage(Content content){
        service.updateContent(content);
        return ResultUtil.successResult(null);
    }

    @ResponseBody
    @RequestMapping(value = "/selectAllContents",method = RequestMethod.GET)
    public Result selectAllImages(){
        List<Content> contents = service.selectAllContents();
        return ResultUtil.successResult(contents);
    }

    @ResponseBody
    @RequestMapping(value = "/selectContentByPart",method = RequestMethod.GET)
    public Result selectContentByPart(Integer contentPart){
        List<Content> contents = service.selectContentByPart(contentPart);
        return ResultUtil.successResult(contents);
    }

}