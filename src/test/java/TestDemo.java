/**
 * <p>佛山市蠢材科技有限公司</p>
 *
 * @Copyright: 2014-2020 www.fooltech.cn. All rights reserved.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 类的功能描述
 *
 * @author lufeng
 */
public class TestDemo {

    @Test
    public void unitTest() {


        List<? extends Fruit> list2 = new ArrayList<Apple>();
        List<? extends Fruit> list3 = new ArrayList<Jonathan>();


    }



}

class Fruit{}
class Apple extends Fruit{}
class Jonathan extends Apple{}
class Orange extends Fruit{}