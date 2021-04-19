/**
 * <p>佛山市蠢材科技有限公司</p>
 *
 * @Copyright: 2014-2020 www.fooltech.cn. All rights reserved.
 */
package cn.fooltech.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 类的功能描述
 *
 * @author lufeng 2020-06-27
 */
public class FieldWrap {
    /**
     * mysql字段名
     */
    private String columnName;

    /**
     * java字段名
     */
    private String fieldName;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
