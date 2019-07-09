/*
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */

package com.frpf.pcm.service.impl;
import com.frpf.pcm.dto.Data;
import com.frpf.pcm.mapper.DataMapper;
import com.frpf.pcm.service.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wuyogui
 * @Title DataServiceImpl
 * @Description service
 * @date: 2019-5-13 16:47
 */
@Service
public class DataServiceImpl implements IDataService {

    @Autowired
    private DataMapper dataMapper;

    @Override
    public List<Data> findAllUser() {
        return dataMapper.findAllUser();
    }

    @Override
    public void insertData(Data data) {
        dataMapper.insertData(data);
    }

    @Override
    public void insertDataAuto(Data data) {

    }
}