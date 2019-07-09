package com.frpf.om.mapper;

import com.frpf.om.dto.DataSecond;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by WuYouGui on 2019/5/13.
 */
@Mapper
public interface DataSecondMapper{

    List<DataSecond> findAllUser();

    void insertData(DataSecond data);
}
