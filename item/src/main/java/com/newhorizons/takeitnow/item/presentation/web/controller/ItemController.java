package com.newhorizons.takeitnow.item.presentation.web.controller;

import com.newhorizons.takeitnow.item.application.mainmodule.dto.ItemDto;
import com.newhorizons.takeitnow.item.domain.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RefreshScope
@RestController
@RequestMapping("/item")
public class ItemController {

    @Value("${configuracion.usuario}")
    private String UserName;

    @Autowired
    private Environment environment;

    @Autowired
    private ItemService itemService;

    @GetMapping("/getAll")
    public List<ItemDto> getAll(){
        return itemService.getAll();
    }

    @GetMapping("getItem/{productId}/{quantity}")
    public ItemDto getItem(@PathVariable("productId") long productId, @PathVariable("quantity") long quantity){
        return itemService.getItem(productId, quantity);
    }

    @GetMapping("/getConfigProperties")
    public ResponseEntity<?> getConfigProperties(){
        Map<String, String> jsonObject = new HashMap<>();
        jsonObject.put("userName", UserName);

        if(environment.getActiveProfiles().length > 0 && environment.getActiveProfiles()[0].equals("dev")){
            jsonObject.put("port", environment.getProperty("server.port"));
        }

        return new ResponseEntity<Map<String,String>>(jsonObject, HttpStatus.OK);
    }
}
