package com.xjh.data.Controller;

import com.xjh.data.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xujiahui
 * @create 2022/4/28 15:15
 */
@RequestMapping("data")
@RestController
public class DataController {

   @Autowired
   private DataService dataService;


   @GetMapping("/getDataTable")
   public HashMap<String , ArrayList<String>> getDataTable(String primaryName, String targetName){
      return dataService.getDataTable(primaryName,targetName);
   }
}
