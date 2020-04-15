package com.litchi.pocketcommunity.dao;

import com.litchi.pocketcommunity.bean.ImageFile;
import com.litchi.pocketcommunity.bean.ImageFileExample;
import com.litchi.pocketcommunity.bean.ImageFileKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImageFileMapper {
    long countByExample(ImageFileExample example);

    int deleteByExample(ImageFileExample example);

    int deleteByPrimaryKey(ImageFileKey key);

    int insert(ImageFile record);

    int insertSelective(ImageFile record);

    List<ImageFile> selectByExample(ImageFileExample example);

    ImageFile selectByPrimaryKey(ImageFileKey key);

    int updateByExampleSelective(@Param("record") ImageFile record, @Param("example") ImageFileExample example);

    int updateByExample(@Param("record") ImageFile record, @Param("example") ImageFileExample example);

    int updateByPrimaryKeySelective(ImageFile record);

    int updateByPrimaryKey(ImageFile record);
}