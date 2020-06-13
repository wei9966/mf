package com.wb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create By WeiBin on 2020/3/22 23:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult<T> {
    //状态码
    private int code;
    //返回信息
    private String message;
    //类型
    private T data;

    public JsonResult(int code,String message){
        this.code=code;
        this.message=message;
    }

}
