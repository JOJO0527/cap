package com.cap.mapper;

import com.cap.pojo.CapItemParamItem;
import com.cap.pojo.CapItemParamItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CapItemParamItemMapper {
    int countByExample(CapItemParamItemExample example);

    int deleteByExample(CapItemParamItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CapItemParamItem record);

    int insertSelective(CapItemParamItem record);

    List<CapItemParamItem> selectByExampleWithBLOBs(CapItemParamItemExample example);

    List<CapItemParamItem> selectByExample(CapItemParamItemExample example);

    CapItemParamItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CapItemParamItem record, @Param("example") CapItemParamItemExample example);

    int updateByExampleWithBLOBs(@Param("record") CapItemParamItem record, @Param("example") CapItemParamItemExample example);

    int updateByExample(@Param("record") CapItemParamItem record, @Param("example") CapItemParamItemExample example);

    int updateByPrimaryKeySelective(CapItemParamItem record);

    int updateByPrimaryKeyWithBLOBs(CapItemParamItem record);

    int updateByPrimaryKey(CapItemParamItem record);
}