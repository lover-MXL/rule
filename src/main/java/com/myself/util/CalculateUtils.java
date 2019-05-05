package com.myself.util;

import com.myself.exception.CalculateException;
import org.mvel2.CompileException;
import org.mvel2.MVEL;
import org.mvel2.PropertyAccessException;
import org.springframework.util.NumberUtils;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;


/**
 * 计算工具
 *
 * @author valsong
 * @date Jul 24, 2017
 */
public class CalculateUtils {

    /**
     * 根据传入的公式和参数进行计算
     *
     * @param formula
     * @param variables
     * @return
     */
    public static <T> BigDecimal calculate(String formula, Map<String, T> variables) {
        if (SimpleStringUtils.isBlank(formula)) {
            throw new CalculateException("MVEL formula can't be null! formula : " + formula); // 公式不能为空
        }
        if (variables == null || variables.size() == 0) {
            throw new CalculateException("MVEL variables can't be null! variables : " + String.valueOf(variables)); // 参数不能为空
        }

        try {
            // 将公式中的变量全部转化为BigDecimal类型
            variables.entrySet().stream().filter(e -> e != null && e.getKey() != null && e.getValue() != null)
                    .map(CalculateUtils::convert).collect(Collectors.toMap(Entry::getKey, Entry::getValue));

        } catch (NumberFormatException e) {
            throw new CalculateException(
                    "MVEL can't convert to BigDecimal, please check the variables : " + String.valueOf(variables) + "!",
                    e);
        } catch (Exception e) {
            throw e;
        }
        BigDecimal result = null;
        try {
            result = (BigDecimal) MVEL.eval(formula, variables);
        } catch (PropertyAccessException pae) {
            throw new CalculateException(
                    "MVEL please check the formula :" + formula + " & variables : " + String.valueOf(variables) + "!",
                    pae);
        } catch (CompileException ce) {
            throw new CalculateException("MVEL calculate error! ", ce);
        } catch (Exception e) {
            throw e;
        }
        return result;
    }


    /**
     * 将参数转化为Bigdecimal类型
     *
     * @param entry
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> Entry<String, T> convert(Entry<String, T> entry) {
        if (entry != null) {
            BigDecimal value = null;
            if (entry.getValue() instanceof BigDecimal) {
                value = (BigDecimal) entry.getValue();
            } else if (entry.getValue() instanceof Long) {
                value = BigDecimal.valueOf(new Long((Long) entry.getValue()).intValue());
            }else if(entry.getValue() instanceof Double){
                value=BigDecimal.valueOf(((Double) entry.getValue()).doubleValue());
            }
            else{
                value = BigDecimal.valueOf(Long.valueOf(entry.getValue().toString()));
            }
            entry.setValue((T) value);
        }
        return entry;
    }

}