package com.litchi.pocketcommunity.dao;

import com.litchi.pocketcommunity.bean.ImageFile;
import com.litchi.pocketcommunity.bean.ImageFileExample;
import com.litchi.pocketcommunity.bean.ImageFileKey;
import com.litchi.pocketcommunity.bean.ImageFileWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImageFileMapper {
    long countByExample(ImageFileExample example);

    int deleteByExample(ImageFileExample example);

    int deleteByPrimaryKey(ImageFileKey key);

    int insert(ImageFileWithBLOBs record);

    int insertSelective(ImageFileWithBLOBs record);

    List<ImageFileWithBLOBs> selectByExampleWithBLOBs(ImageFileExample example);

    List<ImageFile> selectByExample(ImageFileExample example);

    ImageFileWithBLOBs selectByPrimaryKey(ImageFileKey key);

    int updateByExampleSelective(@Param("record") ImageFileWithBLOBs record, @Param("example") ImageFileExample example);

    int updateByExampleWithBLOBs(@Param("record") ImageFileWithBLOBs record, @Param("example") ImageFileExample example);

    int updateByExample(@Param("record") ImageFile record, @Param("example") ImageFileExample example);

    int updateByPrimaryKeySelective(ImageFileWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ImageFileWithBLOBs record);

    int updateByPrimaryKey(ImageFile record);
}