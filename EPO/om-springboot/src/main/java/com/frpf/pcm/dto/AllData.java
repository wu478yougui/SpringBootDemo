package com.frpf.pcm.dto;

import java.util.List;

/**
 * Created by WuYouGui on 2019/5/28.
 */
public class AllData {

    private List<Data> dataList;

    private Long total;

    public List<Data> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
