/**
 * <p>佛山市蠢材科技有限公司</p>
 *
 * @Copyright: 2014-2020 www.fooltech.cn. All rights reserved.
 */
package cn.fooltech.define;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类的功能描述
 *
 * @author lufeng
 */
public final class MysqlType {
    private MysqlType() {
    }

    // 数字类型
    public static final String TINYINT = "tinyint";
    public static final String SMALLINT = "smallint";
    public static final String MEDIUMINT = "mediumint";
    public static final String INT = "int";
    public static final String BIGINT = "bigint";
    public static final String FLOAT = "float";
    public static final String DOUBLE = "double";
    public static final String DECIMAL = "decimal";
    // 日期类型
    public static final String DATE = "date";
    public static final String TIME = "time";
    public static final String YEAR = "year";
    public static final String DATETIME = "datetime";
    public static final String TIMESTAMP = "timestamp";
    // 字符串类型
    public static final String CHAR = "char";
    public static final String VARCHAR = "varchar";
    public static final String TINYBLOB = "tinyblob";
    public static final String TINYTEXT = "tinytext";
    public static final String BLOB = "blob";
    public static final String TEXT = "text";
    public static final String MEDIUMBLOB = "mediumblob";
    public static final String MEDIUMTEXT = "mediumtext";
    public static final String LONGBLOB = "longblob";
    public static final String LONTEXT = "lontext";

    public static final List<String> typeList = new ArrayList<String>() {
        {
            add("tinyint");
            add("smallint");
            add("mediumint");
            add("int");
            add("bigint");
            add("float");
            add("double");
            add("decimal");
            add("date");
            add("time");
            add("year");
            add("datetime");
            add("timestamp");
            add("char");
            add("varchar");
            add("tinyblob");
            add("tinytext");
            add("blob");
            add("text");
            add("mediumblob");
            add("mediumtext");
            add("longblob");
            add("longtext");
        }
    };

    public static final Map<String, String> map = new HashMap<String, String>() {
        {
            put("tinyint", "Integer");
            put("smallint", "Integer");
            put("mediumint", "Integer");
            put("int", "Integer");
            put("bigint", "Integer");
            put("float", "Float");
            put("double", "Double");
            put("decimal", "BigDecimal");
            put("date", "LocalDate");
            put("time", "Time");
            put("year", "Date");
            put("datetime", "LocalDateTime");
            put("timestamp", "LocalDateTime");
            put("char", "String");
            put("varchar", "String");
//            put("tinyblob","");
//            put("tinytext","");
            put("blob", "byte[]");
            put("text", "String");
            put("longtext", "String");
//            put("mediumblob","");
//            put("mediumtext","");
//            put("longblob","");
//            put("lontext","");
        }
    };
}
