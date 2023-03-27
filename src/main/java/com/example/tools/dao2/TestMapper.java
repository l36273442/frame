package com.example.tools.dao2;

import com.example.tools.entity2.Test;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface TestMapper {

    List<Test> selectAll();

}
