/**
 * <p>佛山市蠢材科技有限公司</p>
 *
 * @Copyright: 2014-${year} www.fooltech.cn. All rights reserved.
 */
package cn.fooltech.utils;

import cn.fooltech.engine.ThymeleafService;
import cn.fooltech.model.ClazzDefine;
import cn.fooltech.model.ClazzWrap;
import cn.fooltech.model.MysqlTable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 代码生成
 *
 * @author lufeng
 */
public class GenerateUtils {
    private static ClazzDefine clazzDefine;
    private static MysqlTable mysqlTable;
    private static ClazzWrap clazzWrap;

    static {
        MysqlTable table = MysqlUtil.parse();
        ClazzDefine clazz = ConvertUtil.convert(table);
        mysqlTable = table;
        clazzDefine = clazz;
        clazzWrap = new ClazzWrap(table, clazz);
    }

    public static void generate(String projectName, String moduleName) throws IOException {
        generateBean(projectName, moduleName);
        generateMapper(projectName, moduleName);
        generateXml(projectName, moduleName);
        generateService(projectName, moduleName);
        generateController(projectName, moduleName);
        generateEditVo(projectName, moduleName);
        generateEditBo(projectName, moduleName);
        generatePageQueryVo(projectName, moduleName);
        generatePageQueryBo(projectName, moduleName);

    }

    private static void generateBean(String projectName, String moduleName) throws IOException {
        FileWriter writer = new FileWriter(new File("e:/test/" + clazzDefine.getClazzName() + ".java"));
        String template = GenerateUtils.class.getResource("/template/common/JavaBeanTemplate.txt").getPath();
        ThymeleafService.process(template, writer, clazzDefine, mysqlTable, projectName, moduleName);
    }

    private static void generateMapper(String projectName, String moduleName) throws IOException {
        FileWriter writer = new FileWriter(new File("e:/test/" + clazzDefine.getClazzName() + "Mapper.java"));
        String template = GenerateUtils.class.getResource("/template/kamfu/mapperTemplate.txt").getPath();
        ThymeleafService.process(template, writer, clazzDefine, mysqlTable, projectName, moduleName);
    }

    private static void generateXml(String projectName, String moduleName) throws IOException {
        FileWriter writer = new FileWriter(new File("e:/test/" + clazzDefine.getClazzName() + "Mapper.xml"));
        String template = GenerateUtils.class.getResource("/template/kamfu/xmlTemplate.txt").getPath();
        ThymeleafService.process(template, writer, clazzWrap);
    }

    private static void generateService(String projectName, String moduleName) throws IOException {
        FileWriter writer = new FileWriter(new File("e:/test/" + clazzDefine.getClazzName() + "Service.java"));
        String template =
                GenerateUtils_smartschool.class.getResource("/template/kamfu/serviceTemplate.txt").getPath();
        ThymeleafService.process(template, writer, clazzDefine, mysqlTable, projectName, moduleName);
    }

    private static void generateController(String projectName, String moduleName) throws IOException {
        FileWriter writer = new FileWriter(new File("e:/test/" + clazzDefine.getClazzName() + "Controller.java"));
        String template =
                GenerateUtils_smartschool.class.getResource("/template/common/ControllerTemplate.txt").getPath();
        ThymeleafService.process(template, writer, clazzDefine, mysqlTable, projectName, moduleName);
    }

    private static void generateEditVo(String projectName, String moduleName) throws IOException {
        FileWriter writer = new FileWriter(new File("e:/test/" + clazzDefine.getClazzName() + "EditVo.java"));
        String template = GenerateUtils.class.getResource("/template/common/editVoTemplate.txt").getPath();
        ThymeleafService.process(template, writer, clazzDefine, mysqlTable, projectName, moduleName);
    }

    private static void generateEditBo(String projectName, String moduleName) throws IOException {
        FileWriter writer = new FileWriter(new File("e:/test/" + clazzDefine.getClazzName() + "EditBo.java"));
        String template = GenerateUtils_smartschool.class.getResource("/template/common/editBoTemplate.txt").getPath();
        ThymeleafService.process(template, writer, clazzDefine, mysqlTable, projectName, moduleName);
    }

    private static void generatePageQueryVo(String projectName, String moduleName) throws IOException {
        FileWriter writer = new FileWriter(new File("e:/test/" + clazzDefine.getClazzName() + "PageQueryVo.java"));
        String template =
                GenerateUtils_smartschool.class.getResource("/template/common/PageQueryVoTemplate.txt").getPath();
        ThymeleafService.process(template, writer, clazzDefine, mysqlTable, projectName, moduleName);
    }

    private static void generatePageQueryBo(String projectName, String moduleName) throws IOException {
        FileWriter writer = new FileWriter(new File("e:/test/" + clazzDefine.getClazzName() + "PageQueryBo.java"));
        String template =
                GenerateUtils_smartschool.class.getResource("/template/common/PageQueryBoTemplate.txt").getPath();
        ThymeleafService.process(template, writer, clazzDefine, mysqlTable, projectName, moduleName);
    }

}
