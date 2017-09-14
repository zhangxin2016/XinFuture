package com.zx.tvm.annotation;

import com.zx.tvm.annotation.TestAn;
/**
 * Created by zhangx on 2017/9/12
 */
public class Apple {

    @TestAn("zhangsan")
    public String a;

    public String getA() {
        return a;
    }


    public static void main(String[] args) {

    }
}
