package com.litchi.pocketcommunity.dao;

import com.litchi.pocketcommunity.bean.Notice;
import com.litchi.pocketcommunity.bean.NoticeExample;
import com.litchi.pocketcommunity.bean.NoticeKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeMapper {
    long countByExample(NoticeExample example);

    int deleteByExample(NoticeExample example);

    int deleteByPrimaryKey(NoticeKey key);

    int insert(Notice record);

    int insertSelective(Notice record);

    List<Notice> selectByExample(NoticeExample example);

    List<Notice> selectByExampleWithName(NoticeExample example);

    Notice selectByPrimaryKey(NoticeKey key);

    int updateByExampleSelective(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByExample(@Param("record") Notice record, @Param("example") NoticeExample example);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);
}