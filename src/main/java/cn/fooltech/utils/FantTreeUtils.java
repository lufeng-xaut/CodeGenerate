package cn.fooltech.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class FantTreeUtils {
    static final Logger logger = LoggerFactory.getLogger(FantTreeUtils.class);

    public FantTreeUtils() {
    }

    public static <E> List<E> createTrees(List<E> datas, String idProperty, String parentIdProperty, String childrenProperty) {
        Map<Object, E> dataMap = new LinkedHashMap();
        List<E> retList = new ArrayList();
        Iterator iterator = datas.iterator();

        Object data;
        Object parentId;
        E parent;
        while(iterator.hasNext()) {
            data = iterator.next();

            try {
                parentId = PropertyUtils.getProperty(data, idProperty);
            } catch (Exception var13) {
                logger.error("无法读取id属性", var13);
                throw new RuntimeException();
            }

            try {
                parent = (E) BeanUtils.cloneBean(data);
                dataMap.put(parentId, parent);
            } catch (Exception var12) {
                logger.error("无法复制数据", var12);
                throw new RuntimeException();
            }
        }

        try {
            iterator = dataMap.values().iterator();

//            while(true) {
                while(iterator.hasNext()) {
                    data = iterator.next();
                    parentId = PropertyUtils.getProperty(data, parentIdProperty);
                    if (parentId != null && dataMap.containsKey(parentId)) {
                        parent = dataMap.get(parentId);
                        Object children = PropertyUtils.getProperty(parent, childrenProperty);
                        if (children == null) {
                            children = new ArrayList();
                            PropertyUtils.setProperty(parent, childrenProperty, children);
                        }

                        if (!(children instanceof List)) {
                            throw new ClassCastException("属性" + childrenProperty + "不是有效的子级数据属性");
                        }

                        List<E> list = (List)children;
                        list.add((E) data);
                    } else {
                        retList.add((E) data);
                    }
                }

                return retList;
//            }
        } catch (Exception var14) {
            logger.error("父节点Id或则子节点列表属性字段异常", var14);
            throw new RuntimeException("树节点配置异常");
        }
    }
}