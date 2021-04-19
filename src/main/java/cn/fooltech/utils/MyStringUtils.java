/**
 * <p>佛山市蠢材科技有限公司</p>
 *
 * @Copyright: 2014-${year} www.fooltech.cn. All rights reserved.
 */
package cn.fooltech.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 字符串工具类
 *
 * @author lufeng 2019-05-29
 */
public class MyStringUtils {

    /**
     * 下划线转驼峰
     *
     * @param s
     * @return
     */
    public static String convertToCamel(String s) {

        String src = s.toLowerCase();// 先转成小写，不然后面转大写会出错

        if (StringUtils.isEmpty(src)) {
            return null;
        }

        char[] srcChars = src.toCharArray();
        StringBuilder sb = new StringBuilder();

        boolean flag = false;

        for (int i = 0; i < srcChars.length; i++) {

            if (flag) {
                sb.append((char) (srcChars[i] - 32));
                flag = false;
                continue;
            }

            if (srcChars[i] == '_') {
                flag = true;
                continue;
            }
            sb.append(srcChars[i]);
        }

        return sb.toString();
    }

    /**
     * 驼峰转下划线
     *
     * @param src
     * @return
     */
    public static String convertToUnderline(String src) {
        if (StringUtils.isEmpty(src)) {
            return null;
        }

        char[] srcChars = src.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < srcChars.length; i++) {
            if (srcChars[i] >= 'A' && srcChars[i] <= 'Z') {
                sb.append('_');
                sb.append((char) (srcChars[i] + 32));
                continue;
            }
            sb.append(srcChars[i]);
        }

        return sb.toString();
    }

    public static List<String> convertToCamelForList(List<String> srcList) {
        return srcList.stream().map(MyStringUtils::convertToCamel).collect(Collectors.toList());
    }

    public static List<String> convertToUnderlineForList(List<String> srcList) {
        return srcList.stream().map(MyStringUtils::convertToUnderline).collect(Collectors.toList());
    }
}
