package com.frpf.om.dto;

import java.util.List;

/**
 * Created by WuYouGui on 2019/5/28.
 */
public class AllData {

    private List<DataSecond> dataList;

    private Long total;

    public List<DataSecond> getDataList() {
        return dataList;
    }

    public void setDataList(List<DataSecond> dataList) {
        this.dataList = dataList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
