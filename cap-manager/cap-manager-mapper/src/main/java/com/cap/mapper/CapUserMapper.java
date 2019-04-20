package com.cap.mapper;

import com.cap.pojo.CapUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.cap.pojo.CapUserExample;

public interface CapUserMapper {
    int countByExample(CapUserExample example);

    int deleteByExample(CapUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CapUser record);

    int insertSelective(CapUser record);

    List<CapUser> selectByExample(CapUserExample example);

    CapUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CapUser record, @Param("example") CapUserExample example);

    int updateByExample(@Param("record") CapUser record, @Param("example") CapUserExample example);

    int updateByPrimaryKeySelective(CapUser record);

    int updateByPrimaryKey(CapUser record);
}