package com.myself;

import com.myself.util.CalculateUtils;
import org.junit.Assert;
import org.mvel2.MVEL;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Wang Yu Qiang
 * @Description:
 * @Date: Create in 16:13 2019/4/29
 */
public class Test {

    public static void main(String args[]) {

        String formula = "A ><1";

        Map<String, Object> variables = new HashMap<>();
        variables.put("A", "1");
        variables.put("B", 2L);
        variables.put("C", 3.0D);
        variables.put("D", 4);
        variables.put("E", new BigDecimal("20"));
        variables.put("F", "3");
        variables.put("G", "20");
        variables.put("H", "2");

//        BigDecimal result = CalculateUtils.calculate(formula, variables);
        System.out.println(MVEL.evalToBoolean(formula,variables));


//        System.out.println(result.doubleValue());
//        Assert.assertTrue(new
//                BigDecimal("10000.0").
//                compareTo(result) == 0);

    }
}
