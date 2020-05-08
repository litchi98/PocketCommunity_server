package com.litchi.pocketcommunity.service.impl;

import com.litchi.pocketcommunity.bean.Building;
import com.litchi.pocketcommunity.bean.BuildingKey;
import com.litchi.pocketcommunity.dao.BuildingMapper;
import com.litchi.pocketcommunity.service.IBuildingService;
import com.litchi.pocketcommunity.util.ErrorMessage;
import com.litchi.pocketcommunity.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: BuildingService
 * @Description: TODO
 * @author: litchi
 */
@Service
public class BuildingService implements IBuildingService {

    @Autowired
    private BuildingMapper buildingMapper;
    
    /**
    * @description: get building by id 
    * TODO 
    * @param: id
    * @return: ResultMessage
    * @author: litchi
    */
    @Override
    public ResultMessage getBuildingById(String id) {
        BuildingKey buildingKey = new BuildingKey();
        buildingKey.setId("%"+id+"%");
        List<Building> buildings = buildingMapper.selectByPrimaryKeyWithName(buildingKey);
        return checkEmpty(buildings, "buildings");
    }
    
    /**
     * @description: check whether the query result is null
     * TODO
     * @param: list, key
     * @return: ResultMessage
     * @author: litchi
     */
    private ResultMessage checkEmpty(List list, String key){
        if (list.size() > 0 ){
            return ResultMessage.getInstance().result(ResultMessage.SUCCESS_RESULT).putData(key, list);
        } else {
            return ResultMessage.getInstance().result(ResultMessage.ERROR_RESULT).msg(ErrorMessage.QUERY_RESULT_IS_EMPTY);
        }
    }
}
