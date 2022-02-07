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
        double a = 0.02;
        double b = 0.03;
        double c = b - a;
        System.out.println(c);


    }



}

class Fruit{}
class Apple extends Fruit{}
class Jonathan extends Apple{}
class Orange extends Fruit{}