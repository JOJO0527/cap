package com.cap.mapper;

import com.cap.pojo.CapItemCat;
import com.cap.pojo.CapItemCatExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CapItemCatMapper {
    int countByExample(CapItemCatExample example);

    int deleteByExample(CapItemCatExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CapItemCat record);

    int insertSelective(CapItemCat record);

    List<CapItemCat> selectByExample(CapItemCatExample example);

    CapItemCat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CapItemCat record, @Param("example") CapItemCatExample example);

    int updateByExample(@Param("record") CapItemCat record, @Param("example") CapItemCatExample example);

    int updateByPrimaryKeySelective(CapItemCat record);

    int updateByPrimaryKey(CapItemCat record);
}