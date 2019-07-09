package com.frpf.pcm.mapper;

import com.frpf.pcm.dto.Data;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by WuYouGui on 2019/5/13.
 */
@Mapper
public interface DataMapper{

    List<Data> findAllUser();

    void insertData(Data data);
}
