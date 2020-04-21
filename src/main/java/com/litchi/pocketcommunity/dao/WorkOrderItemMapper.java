package com.litchi.pocketcommunity.dao;

import com.litchi.pocketcommunity.bean.WorkOrderItem;
import com.litchi.pocketcommunity.bean.WorkOrderItemExample;
import com.litchi.pocketcommunity.bean.WorkOrderItemKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkOrderItemMapper {
    long countByExample(WorkOrderItemExample example);

    int deleteByExample(WorkOrderItemExample example);

    int deleteByPrimaryKey(WorkOrderItemKey key);

    int insert(WorkOrderItem record);

    int insertSelective(WorkOrderItem record);

    List<WorkOrderItem> selectByExample(WorkOrderItemExample example);

    List<WorkOrderItem> selectByExampleWithName(WorkOrderItemExample example);

    WorkOrderItem selectByPrimaryKey(WorkOrderItemKey key);

    int updateByExampleSelective(@Param("record") WorkOrderItem record, @Param("example") WorkOrderItemExample example);

    int updateByExample(@Param("record") WorkOrderItem record, @Param("example") WorkOrderItemExample example);

    int updateByPrimaryKeySelective(WorkOrderItem record);

    int updateByPrimaryKey(WorkOrderItem record);
}