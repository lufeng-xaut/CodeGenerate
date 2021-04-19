/**
 * <p>佛山市蠢材科技有限公司</p>
 *
 * @Copyright: 2014-2020 www.fooltech.cn. All rights reserved.
 */

import java.util.EnumMap;
import java.util.Map;

/**
 * 类的功能描述
 *
 * @author lufeng
 */
public enum FruitEnum {
    apple,
    bananar;

    FruitEnum(){
    }

    public static Map<FruitEnum,String> map = new EnumMap<FruitEnum,String>(FruitEnum.class){
        {
            put(apple,"苹果");
            put(bananar,"香蕉");
        }
    };
}
