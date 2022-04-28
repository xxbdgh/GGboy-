package com.xjh.data.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xujiahui
 * @create 2022/4/28 15:18
 */
public interface DataService {

   /**
    * 查询不同
    * @param primaryName 主环境
    * @param targetName 目标环境
    * @return 不同
    */
   HashMap<String , ArrayList<String>> getDataTable(String primaryName, String targetName);
}
