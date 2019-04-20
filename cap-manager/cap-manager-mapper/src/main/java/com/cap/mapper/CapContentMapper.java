package com.cap.mapper;

import com.cap.pojo.CapContent;
import com.cap.pojo.CapContentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CapContentMapper {
    int countByExample(CapContentExample example);

    int deleteByExample(CapContentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CapContent record);

    int insertSelective(CapContent record);

    List<CapContent> selectByExampleWithBLOBs(CapContentExample example);

    List<CapContent> selectByExample(CapContentExample example);

    CapContent selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CapContent record, @Param("example") CapContentExample example);

    int updateByExampleWithBLOBs(@Param("record") CapContent record, @Param("example") CapContentExample example);

    int updateByExample(@Param("record") CapContent record, @Param("example") CapContentExample example);

    int updateByPrimaryKeySelective(CapContent record);

    int updateByPrimaryKeyWithBLOBs(CapContent record);

    int updateByPrimaryKey(CapContent record);
}