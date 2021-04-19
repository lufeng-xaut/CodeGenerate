/**
 * <p>佛山市蠢材科技有限公司</p>
 *
 * @Copyright: 2014-2020 www.fooltech.cn. All rights reserved.
 */
package cn.fooltech.utils;

import cn.fooltech.model.ClazzDefine;
import cn.fooltech.model.JavaField;
import cn.fooltech.model.MysqlTable;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 类的功能描述
 *
 * @author lufeng 2020-06-26
 */
public class ConvertUtil {
    private static ClazzDefine clazzDefine = new ClazzDefine();

    public static ClazzDefine convert(MysqlTable table) {
        String s = MyStringUtils.convertToCamel(table.getTableName());
        String clazzName = s.substring(0, 1).toUpperCase() + s.substring(1);
        clazzDefine.setClazzName(clazzName);
        clazzDefine.setClazzComment(table.getTableComment());

        List<JavaField> fieldList = table.getColumnList().stream().map(e -> {
            JavaField javaField = new JavaField();
            javaField.setName(MyStringUtils.convertToCamel(e.getName()));
            javaField.setComment(e.getComment());
            javaField.setType(e.getJavaType());
            return javaField;
        }).collect(Collectors.toList());

        clazzDefine.setJavaFieldList(fieldList);

        return clazzDefine;
    }

    public static void main(String[] args) {
        MysqlTable table = MysqlUtil.parse();
        ClazzDefine clazzDefine = convert(table);
        System.out.println(clazzDefine);
    }

}
