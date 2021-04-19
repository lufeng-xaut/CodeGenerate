/**
 * <p>佛山市蠢材科技有限公司</p>
 *
 * @Copyright: 2014-2020 www.fooltech.cn. All rights reserved.
 */
package cn.fooltech.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * java类描述
 *
 * @author lufeng 2020-06-26
 */
public class ClazzDefine {
    /**
     * 类名
     */
    private String clazzName;

    /**
     * 类描述
     */
    private String clazzComment;

    /**
     * java字段
     */
    private List<JavaField> javaFieldList;

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

    public List<JavaField> getJavaFieldList() {
        return javaFieldList;
    }

    public void setJavaFieldList(List<JavaField> javaFieldList) {
        this.javaFieldList = javaFieldList;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
