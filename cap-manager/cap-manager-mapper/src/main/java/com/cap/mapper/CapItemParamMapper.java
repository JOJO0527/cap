package com.cap.mapper;

import com.cap.pojo.CapItemParam;
import com.cap.pojo.CapItemParamExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CapItemParamMapper {
    int countByExample(CapItemParamExample example);

    int deleteByExample(CapItemParamExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CapItemParam record);

    int insertSelective(CapItemParam record);

    List<CapItemParam> selectByExampleWithBLOBs(CapItemParamExample example);

    List<CapItemParam> selectByExample(CapItemParamExample example);

    CapItemParam selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CapItemParam record, @Param("example") CapItemParamExample example);

    int updateByExampleWithBLOBs(@Param("record") CapItemParam record, @Param("example") CapItemParamExample example);

    int updateByExample(@Param("record") CapItemParam record, @Param("example") CapItemParamExample example);

    int updateByPrimaryKeySelective(CapItemParam record);

    int updateByPrimaryKeyWithBLOBs(CapItemParam record);

    int updateByPrimaryKey(CapItemParam record);
}