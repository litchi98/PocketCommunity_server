package com.litchi.pocketcommunity.dao;

import com.litchi.pocketcommunity.bean.Verify;
import com.litchi.pocketcommunity.bean.VerifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VerifyMapper {
    long countByExample(VerifyExample example);

    int deleteByExample(VerifyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Verify record);

    int insertSelective(Verify record);

    List<Verify> selectByExample(VerifyExample example);

    Verify selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Verify record, @Param("example") VerifyExample example);

    int updateByExample(@Param("record") Verify record, @Param("example") VerifyExample example);

    int updateByPrimaryKeySelective(Verify record);

    int updateByPrimaryKey(Verify record);
}