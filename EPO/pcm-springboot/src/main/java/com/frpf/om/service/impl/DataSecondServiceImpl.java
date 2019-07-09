/*
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */

package com.frpf.om.service.impl;
import com.frpf.om.dto.DataSecond;
import com.frpf.om.mapper.DataSecondMapper;
import com.frpf.om.service.IDataSecondService;
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
public class DataSecondServiceImpl implements IDataSecondService {

    @Autowired
    private DataSecondMapper dataSecondMapper;

    @Override
    public List<DataSecond> findAllUser() {
        return dataSecondMapper.findAllUser();
    }

    @Override
    public void insertData(DataSecond data) {
        dataSecondMapper.insertData(data);
    }

    @Override
    public void insertDataAuto(DataSecond data) {

    }
}