package org.sc.demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
