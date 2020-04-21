package com.litchi.pocketcommunity.dao;

import com.litchi.pocketcommunity.bean.WorkOrder;
import com.litchi.pocketcommunity.bean.WorkOrderExample;
import com.litchi.pocketcommunity.bean.WorkOrderKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkOrderMapper {
    long countByExample(WorkOrderExample example);

    int deleteByExample(WorkOrderExample example);

    int deleteByPrimaryKey(WorkOrderKey key);

    int insert(WorkOrder record);

    int insertSelective(WorkOrder record);

    List<WorkOrder> selectByExample(WorkOrderExample example);

    WorkOrder selectByPrimaryKey(WorkOrderKey key);

    int updateByExampleSelective(@Param("record") WorkOrder record, @Param("example") WorkOrderExample example);

    int updateByExample(@Param("record") WorkOrder record, @Param("example") WorkOrderExample example);

    int updateByPrimaryKeySelective(WorkOrder record);

    int updateByPrimaryKey(WorkOrder record);
}