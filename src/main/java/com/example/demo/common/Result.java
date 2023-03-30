package com.example.demo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 统一返回类
 *
 * @param <T>
 */
@Getter
@Setter
@AllArgsConstructor
public class Result<T> {

    private String code;
    private String msg;
    private T data;


    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> Result<T> success(T data){
        return new Result<>("10000", "success", data);
    }

    public static <T> Result<T> success(){
        return new Result<>("10000", "success");
    }

    public static <T> Result<T> error(T data){
        return new Result<>("20000", "fail", data);
    }
}
