package com.geek.action;

import com.geek.entity.SourceFile;
import com.geek.service.SourceFileService;
import com.geek.util.Result;
import com.geek.util.ResultUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

/**
 * @author yuanyang
 */
@Controller
public class ImageAction {

    //图片服务类
    @Autowired
    private SourceFileService service;

    @ResponseBody
    @RequestMapping(value = "/insertImage",method = RequestMethod.POST)
    public Result insertImage(MultipartFile picture){
        service.insertFile(picture);
        return ResultUtil.successResult(null);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteImage",method = RequestMethod.GET)
    public Result deleteImage(Integer imageId){
        service.deleteFile(imageId);
        return ResultUtil.successResult(null);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteImages",method = RequestMethod.GET)
    public Result deleteImages(Integer[] imageIds){
        service.deleteFiles(Arrays.asList(imageIds));
        return ResultUtil.successResult(null);
    }

    @ResponseBody
    @RequestMapping(value = "/updateImage",method = RequestMethod.POST)
    public Result updateImage(SourceFile sourceFile, MultipartFile picture){
        service.updateImage(sourceFile,picture);
        return ResultUtil.successResult(null);
    }

    @ResponseBody
    @RequestMapping(value = "/selectAllImages",method = RequestMethod.GET)
    public Result selectAllImages(){
        List<SourceFile> sourceFiles = service.selectAllFiles();
        return ResultUtil.successResult(sourceFiles);
    }

}
