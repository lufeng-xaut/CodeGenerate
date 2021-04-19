/**
 * <p>佛山市蠢材科技有限公司</p>
 *
 * @Copyright: 2014-2020 www.fooltech.cn. All rights reserved.
 */
package cn.fooltech.utils;

import cn.fooltech.model.JavaField;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 类的功能描述
 *
 * @author lufeng
 */
public class TestUtil {
    private static List<String> rows;
    private static List<JavaField> javaFieldList = Lists.newArrayList();

    static {
        String path = FileUtil.class.getResource("/template/test.txt").getPath();
        List<String> list = FileUtil.readRowByPath(path);
        rows = list.stream().filter(e -> {
            return StringUtils.isNotBlank(e);
        }).collect(Collectors.toList());
    }

    public static List<JavaField> generate(){
        ParseRows(rows);
        return javaFieldList;
    }

    private static void ParseRows(List<String> rows) {
        List<String> privateList = rows.stream().filter(e -> {
            return e.startsWith("private");
        }).map(e -> {
            return e.replace(";", "");
        }).collect(Collectors.toList());
        List<String> apiList = rows.stream().filter(e -> {
            return e.startsWith("@ApiModelProperty");
        }).collect(Collectors.toList());
        parse(privateList, apiList);
    }

    private static void parse(List<String> privateList, List<String> apiList) {
        for (String s : privateList) {
            String[] strArr = s.split(" ");
            String name = strArr[2];
            String type = strArr[1];
            String comment = null;
            for (String api : apiList) {
                if (api.contains(name)){
                    comment = api.substring(api.indexOf("\"", api.indexOf("value")) + 1, api.lastIndexOf("\""));
                }
            }
            JavaField javaField = new JavaField();
            javaField.setName(name);
            javaField.setComment(comment);
            javaField.setType(type);
            javaFieldList.add(javaField);
        }


    }

    public static void main(String[] args) {
        List<JavaField> javaFieldList = generate();
        javaFieldList.forEach(System.out::println);
    }


}
