/**
 * <p>佛山市蠢材科技有限公司</p>
 *
 * @Copyright: 2014-2020 www.fooltech.cn. All rights reserved.
 */

import java.util.List;

/**
 * 类的功能描述
 *
 * @author lufeng
 */
public class ResourceTreeVo {
    private String id;
    private String name;
    private String code;
    private String parentId;
    private List<ResourceTreeVo> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<ResourceTreeVo> getChildren() {
        return children;
    }

    public void setChildren(List<ResourceTreeVo> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ResourceTreeVo{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", code='").append(code).append('\'');
        sb.append(", parentId='").append(parentId).append('\'');
        sb.append(", children=").append(children);
        sb.append('}');
        return sb.toString();
    }
}
