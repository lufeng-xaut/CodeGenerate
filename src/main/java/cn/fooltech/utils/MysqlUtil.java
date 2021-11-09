/**
 * <p>佛山市蠢材科技有限公司</p>
 *
 * @Copyright: 2014-2020 www.fooltech.cn. All rights reserved.
 */
package cn.fooltech.utils;

import cn.fooltech.define.MysqlType;
import cn.fooltech.model.Column;
import cn.fooltech.model.MysqlTable;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SQL解析工具
 *
 * @author lufeng 2020-06-26
 */
public class MysqlUtil {
    private static MysqlTable table = new MysqlTable();
    private static List<String> rows;

    static {
        String path = FileUtil.class.getResource("/template/from_sql.txt").getPath();
        List<String> list = FileUtil.readRowByPath(path);
        rows = list.stream().filter(e -> {
            return StringUtils.isNotBlank(e);
        }).collect(Collectors.toList());
    }

    public static MysqlTable parse() {
        extractTableAndComment(rows);
        ParseRows(rows);
        return table;
    }

    /**
     * 提取列
     *
     * @param rows
     */
    private static void ParseRows(List<String> rows) {
        // 过滤出包含有列的行
        List<String> columnList = rows.stream().filter(e -> e.trim().startsWith("`")).collect(Collectors.toList());
        for (String row : columnList) {
            rowParse(row);
        }
    }


    /**
     * 注：
     * 1）不能按空格分割，因为注释里可能也带有空格
     * 优化：1）先提取子串把注释提取出来 `edit_time` datetime DEFAULT NULL, ',",`
     * 2）再按空格分割，,最多就这3个符号，过滤掉，分别取1，2个字段和注释
     * 有个问题，如果没有"`"符号，怎么判断列从哪行开始
     * @param row
     */
    private static void rowParse(String row) {
        Column column = new Column();

        String columnName = row.substring(row.indexOf("`") + 1, row.lastIndexOf("`"));
        String columnComment = null;
        if (row.contains("COMMENT")) {
            columnComment = row.substring(row.indexOf("'", row.indexOf("COMMENT")) + 1, row.lastIndexOf("'"));
        } else {
            columnComment = null;
        }
        column.setName(columnName);
        column.setComment(columnComment);
        column.setRequired(row.contains("NOT NULL") ? true : false);

        // 取得mysql类型,对应的java类型
        List<String> list = Arrays.asList(StringUtils.split(row, " "));
        for (String s : list) {
            String tem = new String(s);
            if (tem.contains("(")) {
                tem = tem.substring(0, tem.indexOf("("));
            }
            for (String type : MysqlType.typeList) {
                if (tem.equals(type)) {
                    column.setType(s);
                    column.setJavaType(MysqlType.map.get(type));
                    break;
                }
            }
        }
        table.getColumnList().add(column);
    }


    /**
     * 提取表名和表注释
     */
    private static void extractTableAndComment(List<String> rows) {
        if (rows != null && !rows.isEmpty()) {
            if (rows.size() < 2) {
                throw new RuntimeException("SQL有误");
            }
            String firstRow = rows.get(0);
            String lastRow = rows.get(rows.size() - 1);
            String tableName = firstRow.substring(firstRow.indexOf("`") + 1, firstRow.lastIndexOf("`"));
            String tableComment = null;
            if (lastRow.contains("COMMENT")) {
                tableComment = lastRow.substring(lastRow.indexOf("'") + 1, lastRow.lastIndexOf("'"));
            } else {
                tableComment = null;
            }
            table.setTableName(tableName);
            table.setTableComment(tableComment);
        }
    }


    public static void main(String[] args) {
        MysqlTable table = parse();
        System.out.println(table);
    }


}
