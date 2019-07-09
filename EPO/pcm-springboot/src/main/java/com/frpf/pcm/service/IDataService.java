/*
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */

package com.frpf.pcm.service;



import com.frpf.pcm.dto.Data;

import java.util.List;

public interface IDataService {

    List<Data> findAllUser();

    void insertData(Data data);

    void insertDataAuto(Data data);
}
