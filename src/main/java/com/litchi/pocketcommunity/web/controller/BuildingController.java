package com.litchi.pocketcommunity.web.controller;

import com.litchi.pocketcommunity.service.IBuildingService;
import com.litchi.pocketcommunity.util.ResultMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: BuildingController
 * @Description: TODO
 * @author: litchi
 */
@RestController
public class BuildingController {

    @Autowired
    private IBuildingService buildingService;

    @ApiOperation(value = "get building by id")
    @GetMapping("/building/{id}")
    public ResultMessage getBuildingById(@PathVariable String id){
        return buildingService.getBuildingById(id);
    }
}
