package com.wb.pojo;

import java.util.List;

/**
 * 分页显示实体类
 */
public class PageInfo {
    //第几页
    private int pageNumber;
    /**
     * 每一页显示的数量
     */
    private int pageSize;
    /**
     * 总条数量
     */
    private int total;
    private int pageStart;
    /**
     * 每页显示的数据
     */
    private List<?> list;
    public int getPageNumber() {
        return pageNumber;
    }
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public List<?> getList() {
        return list;
    }
    public void setList(List<?> list) {
        this.list = list;
    }

    public int getPageStart() {
        return pageStart;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }
}