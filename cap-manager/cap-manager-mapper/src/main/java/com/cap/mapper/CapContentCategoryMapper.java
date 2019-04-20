package com.cap.mapper;

import com.cap.pojo.CapContentCategory;
import com.cap.pojo.CapContentCategoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CapContentCategoryMapper {
    int countByExample(CapContentCategoryExample example);

    int deleteByExample(CapContentCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CapContentCategory record);

    int insertSelective(CapContentCategory record);

    List<CapContentCategory> selectByExample(CapContentCategoryExample example);

    CapContentCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CapContentCategory record, @Param("example") CapContentCategoryExample example);

    int updateByExample(@Param("record") CapContentCategory record, @Param("example") CapContentCategoryExample example);

    int updateByPrimaryKeySelective(CapContentCategory record);

    int updateByPrimaryKey(CapContentCategory record);
}