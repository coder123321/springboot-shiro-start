package com.sh.controller;

import com.sh.entity.AjaxResponse;
import com.sh.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2021/2/7.
 * 验证solr搜索功能
 */
@RestController
@RequestMapping("/api")
public class TestSolrController {
    @Autowired
    private SearchService searchservice;
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse search(HttpServletRequest request,String name){
        searchservice.searchText(name);
        return AjaxResponse.success();
    }
    @RequestMapping(value = "/createIndex",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse createIndex(HttpServletRequest request){
        searchservice.createIndex();
        return AjaxResponse.success();
    }
}
