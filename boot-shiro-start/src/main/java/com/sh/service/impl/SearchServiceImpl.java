package com.sh.service.impl;

import com.sh.entity.AjaxResponse;
import com.sh.service.SearchService;
import org.springframework.stereotype.Service;
import org.wltea.analyzer.util.LuceneIKService;
import org.wltea.analyzer.util.LucenePageResult;

import java.util.*;

/**
 * Created by Administrator on 2021/2/7.
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Override
    public AjaxResponse searchText(String name) {
        String[] fields = {"NAME","ID"};
        String keyword = name;
        LinkedHashSet<String> fieldSet = new LinkedHashSet<>();
        fieldSet.add("ID");
        fieldSet.add("NAME");
        LuceneIKService luceneIKService= LuceneIKService.getInstance();
        List<LinkedHashMap<String, Object>> result = luceneIKService.search(fields,keyword,fieldSet,1);
        LucenePageResult result123 =  luceneIKService.searchPage(fields,keyword,fieldSet,1,20,true);
        if(result.size()>0){
            return AjaxResponse.success(result);
        }else{
            return AjaxResponse.success();
        }
    }

    @Override
    public AjaxResponse createIndex() {
        List<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("ID","system");
        map.put("NAME","系统管理员");
        dataList.add(map);
        LuceneIKService.getInstance().createIndex(dataList, "ID");
        return AjaxResponse.success();
    }
}
