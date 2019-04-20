package com.cap.mapper;

import com.cap.pojo.CapItemDesc;
import com.cap.pojo.CapItemDescExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CapItemDescMapper {
    int countByExample(CapItemDescExample example);

    int deleteByExample(CapItemDescExample example);

    int deleteByPrimaryKey(Long itemId);

    int insert(CapItemDesc record);

    int insertSelective(CapItemDesc record);

    List<CapItemDesc> selectByExampleWithBLOBs(CapItemDescExample example);

    List<CapItemDesc> selectByExample(CapItemDescExample example);

    CapItemDesc selectByPrimaryKey(Long itemId);

    int updateByExampleSelective(@Param("record") CapItemDesc record, @Param("example") CapItemDescExample example);

    int updateByExampleWithBLOBs(@Param("record") CapItemDesc record, @Param("example") CapItemDescExample example);

    int updateByExample(@Param("record") CapItemDesc record, @Param("example") CapItemDescExample example);

    int updateByPrimaryKeySelective(CapItemDesc record);

    int updateByPrimaryKeyWithBLOBs(CapItemDesc record);

    int updateByPrimaryKey(CapItemDesc record);
}