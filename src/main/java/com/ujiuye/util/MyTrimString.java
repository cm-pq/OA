package com.ujiuye.util;

import org.springframework.core.convert.converter.Converter;
/**
 * @Auther: 王建东
 * @Date: 2019/5/10 15:25
 */
public class MyTrimString implements Converter<String,String> {
    /*
        自己定义的忽略表单参数空格
     */
    @Override
    public String convert(String s) {
        return s.trim();
    }
}
