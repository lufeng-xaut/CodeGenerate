/**
 * <p>佛山市蠢材科技有限公司</p>
 *
 * @Copyright: 2014-2020 www.fooltech.cn. All rights reserved.
 */
package cn.fooltech.model;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 类的功能描述
 *
 * @author lufeng 2020-06-27
 */
public class ClazzWrap {
    /**
     * mysql表名
     */
    private String tableName;

    /**
     * java类名
     */
    private String clazzName;

    /**
     * 表注释
     */
    private String clazzComment;

    /**
     * 列
     */
    private List<FieldWrap> fieldWrapList;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public String getClazzComment() {
        return clazzComment;
    }

    public void setClazzComment(String clazzComment) {
        this.clazzComment = clazzComment;
    }

    public List<FieldWrap> getFieldWrapList() {
        return fieldWrapList;
    }

    public void setFieldWrapList(List<FieldWrap> fieldWrapList) {
        this.fieldWrapList = fieldWrapList;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    public ClazzWrap() {

    }

    public ClazzWrap(MysqlTable mysqlTable, ClazzDefine clazzDefine) {
        this.clazzComment = mysqlTable.getTableComment();
        this.clazzName = clazzDefine.getClazzName();
        this.tableName = mysqlTable.getTableName();

        List<FieldWrap> fieldWrapList = Lists.newArrayList();
        List<Column> columnList = mysqlTable.getColumnList();
        List<JavaField> fieldList = clazzDefine.getJavaFieldList();
        for (int i = 0; i < columnList.size(); i++) {
            FieldWrap fieldWrap = new FieldWrap();
            fieldWrap.setColumnName(columnList.get(i).getName());
            fieldWrap.setFieldName(fieldList.get(i).getName());
            fieldWrapList.add(fieldWrap);
        }

        this.fieldWrapList = fieldWrapList;
    }
}
