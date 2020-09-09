package com.weylau.javamyblogapi.mapper;

import com.weylau.javamyblogapi.entity.Admins;
import com.weylau.javamyblogapi.entity.AdminsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminsMapper {
    long countByExample(AdminsExample example);

    int deleteByPrimaryKey(Integer adminId);

    int insert(Admins record);

    int insertSelective(Admins record);

    List<Admins> selectByExample(AdminsExample example);

    Admins selectByPrimaryKey(Integer adminId);

    int updateByExampleSelective(@Param("record") Admins record, @Param("example") AdminsExample example);

    int updateByExample(@Param("record") Admins record, @Param("example") AdminsExample example);

    int updateByPrimaryKeySelective(Admins record);

    int updateByPrimaryKey(Admins record);
}