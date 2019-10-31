package org.sc.demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "应用服务",description = "提供应用所需的所有APi")
@RestController
@RequestMapping
public class AppController {


    /**
     * http://localhost:8080/swagger-ui.html
     * @param key
     * @param value
     * @return
     */
    @ApiOperation("得到服务键值对")
    @GetMapping("/getkv")
    public String get(@RequestParam String key,@RequestParam String value){
        return key+value;
    }


    @ApiOperation("得到服务键值对")
    @GetMapping("/demo/obj")
    @ResponseBody
    public Map get(String key){
        Map map = new HashMap();
        Object list = new ArrayList<>();
        map.put("list",list);
        return map;
    }

}
