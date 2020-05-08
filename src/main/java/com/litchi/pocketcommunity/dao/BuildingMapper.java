package com.litchi.pocketcommunity.dao;

import com.litchi.pocketcommunity.bean.Building;
import com.litchi.pocketcommunity.bean.BuildingExample;
import com.litchi.pocketcommunity.bean.BuildingKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BuildingMapper {
    long countByExample(BuildingExample example);

    int deleteByExample(BuildingExample example);

    int deleteByPrimaryKey(BuildingKey key);

    int insert(Building record);

    int insertSelective(Building record);

    List<Building> selectByExample(BuildingExample example);

    Building selectByPrimaryKey(BuildingKey key);

    List<Building> selectByPrimaryKeyWithName(BuildingKey key);

    int updateByExampleSelective(@Param("record") Building record, @Param("example") BuildingExample example);

    int updateByExample(@Param("record") Building record, @Param("example") BuildingExample example);

    int updateByPrimaryKeySelective(Building record);

    int updateByPrimaryKey(Building record);
}