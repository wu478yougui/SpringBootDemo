/*
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */

package com.frpf.om.service;
import com.frpf.om.dto.DataSecond;

import java.util.List;

public interface IDataSecondService {

    List<DataSecond> findAllUser();

    void insertData(DataSecond data);

    void insertDataAuto(DataSecond data);
}
