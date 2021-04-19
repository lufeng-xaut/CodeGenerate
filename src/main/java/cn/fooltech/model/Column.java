/**
 * <p>佛山市蠢材科技有限公司</p>
 *
 * @Copyright: 2014-2020 www.fooltech.cn. All rights reserved.
 */
package cn.fooltech.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * mysql列表示
 *
 * @author lufeng 2020-06-26
 */
public class Column {
    /**
     * 字段名称
     */
    private String name;

    /**
     * mysql类型
     */
    private String type;

    /**
     * java类型
     */
    private String javaType;

    /**
     * 注释
     */
    private String comment;

    /**
     * 是否必填
     */
    private Boolean required;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
