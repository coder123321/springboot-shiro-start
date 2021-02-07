package com.sh.service;

import com.sh.entity.AjaxResponse;

/**
 * Created by Administrator on 2021/2/7.
 */
public interface SearchService {
    public AjaxResponse searchText(String name);
    public AjaxResponse createIndex();
}
