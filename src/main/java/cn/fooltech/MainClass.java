/**
 * <p>佛山市蠢材科技有限公司</p>
 *
 * @Copyright: 2014-${year} www.fooltech.cn. All rights reserved.
 */
package cn.fooltech;

import cn.fooltech.engine.ThymeleafService;
import cn.fooltech.model.JavaField;
import cn.fooltech.utils.GenerateUtils;
import cn.fooltech.utils.GenerateUtils_yimi;
import cn.fooltech.utils.TestUtil2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 类的功能描述
 *
 * @author lufeng
 */
public class MainClass {
    public static void main(String[] args) {
        String projectName = args.length == 0 ? "未添加工程名" : args[0];
        String moduleName = args.length == 0 ? "未添加模块名" : args[1];

//        try {
//            GenerateUtils.generate(projectName, moduleName);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        String outDir = "e:/test";
        try {
//            GenerateUtils_smartschool.generate(projectName, moduleName, outDir);
            GenerateUtils_yimi.generate(projectName, moduleName, outDir);
        } catch (IOException e) {
            e.printStackTrace();
        }


//        try {
//            GenerateTest();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static void GenerateTest() throws IOException {
        FileWriter writer = new FileWriter(new File("e:/test/" + "test.txt"));
//        List<JavaField> javaFieldList = TestUtil.generate();
        List<JavaField> javaFieldList = TestUtil2.generate(); // 要补全注释
        String template = GenerateUtils.class.getResource("/template/testTemplate.txt").getPath();
        ThymeleafService.processTest("", ".txt", template, writer, javaFieldList);
    }

    public static void GenerateTest2() throws IOException {




    }

}

class Clazz {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

class User {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}















