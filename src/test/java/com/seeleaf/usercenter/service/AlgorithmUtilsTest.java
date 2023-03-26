package com.seeleaf.usercenter.service;

import com.seeleaf.usercenter.utils.AlgorithmUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 算法工具类测试
 */
public class AlgorithmUtilsTest {

    @Test
    void test(){
        List<String> tagList1 = Arrays.asList("java", "大一", "男");
        List<String> tagList2 = Arrays.asList("java", "大二", "女");
        int i1 = AlgorithmUtils.minDistance(tagList1, tagList2); // 1
        System.out.println(i1);

    }

}
