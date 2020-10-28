package com.shz.entity;

import java.util.List;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/12 20:41
 * @See com.shz.entity
 */
public class ResultVo {
    private Integer code = 0;
    private String msg = "";
    private Long count;
    private List data;

    public ResultVo(Long count) {
        this.count = count;
    }

    public ResultVo(Long count, List data) {
        this.count = count;
        this.data = data;
    }

    public ResultVo() {
    }

    public ResultVo(Integer code, String msg, Long count, List data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultVo{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
