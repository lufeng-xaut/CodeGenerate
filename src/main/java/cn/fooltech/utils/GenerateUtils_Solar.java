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
public class GenerateUtils_Solar {
    private static ClazzDefine clazzDefine;
    private static MysqlTable mysqlTable;
    private static ClazzWrap clazzWrap;
    private static String outDirectory;

    static {
        MysqlTable table = MysqlUtil.parse();
        ClazzDefine clazz = ConvertUtil.convert(table);
        mysqlTable = table;
        clazzDefine = clazz;
        clazzWrap = new ClazzWrap(table, clazz);
    }

    public static void generate(String projectName, String moduleName, String outDir) throws IOException {
        outDirectory = outDir;
//        generateBean(projectName, moduleName);
        generateGetRequest(projectName, moduleName);
        generatePutRequest(projectName, moduleName);
        generateDeleteRequest(projectName, moduleName);
        generatePageRequest(projectName, moduleName);
        generateGetResponse(projectName, moduleName);
        generateBusinessService(projectName, moduleName);
        generateBusinessServiceImpl(projectName, moduleName);
        generateController(projectName, moduleName);
//        generateEmErrorCode(projectName, moduleName);
        generateEm(projectName, moduleName);
        generateBusinessMapper(projectName, moduleName);
//        generateMapper(projectName, moduleName);
//        generateXml(projectName, moduleName);
//        generateService(projectName, moduleName);
//        generateController(projectName, moduleName);
//        generateEditVo(projectName, moduleName);
//        generateEditBo(projectName, moduleName);
//        generatePageQueryVo(projectName, moduleName);
//        generatePageQueryBo(projectName, moduleName);
        generateColumnField(projectName, moduleName);
//        generateBean(projectName, moduleName);
    }

    private static void generateGetRequest(String projectName, String moduleName) throws IOException {
        FileWriter writer = new FileWriter(new File(outDirectory + "/Get" + clazzDefine.getClazzName() + "Request.java"));
        String template = GenerateUtils.class.getResource("/template/solar/GetRequestTemplate.txt").getPath();
        ThymeleafService.process(template, writer, clazzDefine, mysqlTable, projectName, moduleName);
    }

    private static void generatePutRequest(String projectName, String moduleName) throws IOException {
        FileWriter writer = new FileWriter(new File(outDirectory + "/Put" + clazzDefine.getClazzName() + "Request.java"));
        String template = GenerateUtils.class.getResource("/template/solar/PutRequestTemplate.txt").getPath();
        ThymeleafService.process(template, writer, clazzDefine, mysqlTable, projectName, moduleName);
    }

    private static void generateDeleteRequest(String projectName, String moduleName) throws IOException {
        FileWriter writer = new FileWriter(new File(outDirectory + "/Delete" + clazzDefine.getClazzName() + "Request.java"));
        String template = GenerateUtils.class.getResource("/template/solar/DeleteRequestTemplate.txt").getPath();
        ThymeleafService.process(template, writer, clazzDefine, mysqlTable, projectName, moduleName);
    }

    private static void generatePageRequest(String projectName, String moduleName) throws IOException {
        FileWriter writer = new FileWriter(new File(outDirectory + "/Page" + clazzDefine.getClazzName() + "Request.java"));
        String template = GenerateUtils.class.getResource("/template/solar/PageRequestTemplate.txt").getPath();
        ThymeleafService.process(template, writer, clazzDefine, mysqlTable, projectName, moduleName);
    }

    private static void generateGetResponse(String projectName, String moduleName) throws IOException {
        FileWriter writer = new FileWriter(new File(outDirectory + "/Get" + clazzDefine.getClazzName() + "Response.java"));
        String template = GenerateUtils.class.getResource("/template/solar/GetResponseTemplate.txt").getPath();
        ThymeleafService.process(template, writer, clazzDefine, mysqlTable, projectName, moduleName);
    }

    private static void generateBusinessService(String projectName, String moduleName) throws IOException {
        FileWriter writer = new FileWriter(new File(outDirectory + "/" + clazzDefine.getClazzName() + "BusinessService.java"));
        String template = GenerateUtils.class.getResource("/template/solar/BusinessServiceTemplate.txt").getPath();
        ThymeleafService.process(template, writer, clazzDefine, mysqlTable, projectName, moduleName);
    }

    private static void generateBusinessServiceImpl(String projectName, String moduleName) throws IOException {
        FileWriter writer = new FileWriter(new File(outDirectory + "/" + clazzDefine.getClazzName() + "BusinessServiceImpl.java"));
        String template = GenerateUtils.class.getResource("/template/solar/BusinessServiceImplTemplate.txt").getPath();
        ThymeleafService.process(template, writer, clazzDefine, mysqlTable, projectName, moduleName);
    }

    private static void generateController(String projectName, String moduleName) throws IOException {
        FileWriter writer = new FileWriter(new File(outDirectory + "/" + clazzDefine.getClazzName() + "Controller.java"));
        String template = GenerateUtils.class.getResource("/template/solar/ControllerTemplate.txt").getPath();
        ThymeleafService.process(template, writer, clazzDefine, mysqlTable, projectName, moduleName);
    }

    private static void generateEmErrorCode(String projectName, String moduleName) throws IOException {
        FileWriter writer = new FileWriter(new File(outDirectory + "/" + "Em" + clazzDefine.getClazzName() + "ErrorCode.java"));
        String template = GenerateUtils.class.getResource("/template/solar/EmErrorCodeTemplate.txt").getPath();
        ThymeleafService.process(template, writer, clazzDefine, mysqlTable, projectName, moduleName);
    }

    private static void generateEm(String projectName, String moduleName) throws IOException {
        FileWriter writer = new FileWriter(new File(outDirectory + "/" + "Em" + clazzDefine.getClazzName() + ".java"));
        String template = GenerateUtils.class.getResource("/template/solar/EmTemplate.txt").getPath();
        ThymeleafService.process(template, writer, clazzDefine, mysqlTable, projectName, moduleName);
    }

    private static void generateBean(String projectName, String moduleName) throws IOException {
        FileWriter writer = new FileWriter(new File(outDirectory + "/" + clazzDefine.getClazzName() + ".java"));
        String template = GenerateUtils.class.getResource("/template/solar/JavaBeanTemplate.txt").getPath();
        ThymeleafService.process(template, writer, clazzDefine, mysqlTable, projectName, moduleName);
    }

    private static void generateMapper(String projectName, String moduleName) throws IOException {
        FileWriter writer = new FileWriter(new File(outDirectory + "/" + clazzDefine.getClazzName() + "Mapper.java"));
        String template = GenerateUtils.class.getResource("/template/smartschool/mapperTemplate_smartschool.txt").getPath();
        ThymeleafService.process(template, writer, clazzDefine, mysqlTable, projectName, moduleName);
    }

    private static void generateBusinessMapper(String projectName, String moduleName) throws IOException {
        FileWriter writer = new FileWriter(new File(outDirectory + "/" + clazzDefine.getClazzName() + "BusinessMapper.java"));
        String template = GenerateUtils.class.getResource("/template/solar/BusinessMapper.txt").getPath();
        ThymeleafService.process(template, writer, clazzDefine, mysqlTable, projectName, moduleName);
    }

    private static void generateXml(String projectName, String moduleName) throws IOException {
        FileWriter writer = new FileWriter(new File(outDirectory + "/" + clazzDefine.getClazzName() + "Mapper.xml"));
        String template = GenerateUtils.class.getResource("/template/smartschool/xmlTemplate_smartschool.txt").getPath();
        ThymeleafService.process(template, writer, clazzWrap);
    }

    private static void generateService(String projectName, String moduleName) throws IOException {
        FileWriter writer = new FileWriter(new File(outDirectory + "/" + clazzDefine.getClazzName() + "Service.java"));
        String template = GenerateUtils_Solar.class.getResource("/template/smartschool/ServiceTemplate_smartschool.txt").getPath();
        ThymeleafService.process(template, writer, clazzDefine, mysqlTable, projectName, moduleName);
    }

    private static void generateEditVo(String projectName, String moduleName) throws IOException {
        FileWriter writer = new FileWriter(new File(outDirectory + "/" + clazzDefine.getClazzName() + "EditVo.java"));
        String template = GenerateUtils.class.getResource("/template/common/editVoTemplate.txt").getPath();
        ThymeleafService.process(template, writer, clazzDefine, mysqlTable, projectName, moduleName);
    }

    private static void generateEditBo(String projectName, String moduleName) throws IOException {
        FileWriter writer = new FileWriter(new File(outDirectory + "/" + clazzDefine.getClazzName() + "EditBo.java"));
        String template = GenerateUtils_Solar.class.getResource("/template/common/editBoTemplate.txt").getPath();
        ThymeleafService.process(template, writer, clazzDefine, mysqlTable, projectName, moduleName);
    }

    private static void generatePageQueryVo(String projectName, String moduleName) throws IOException {
        FileWriter writer = new FileWriter(new File(outDirectory + "/" + clazzDefine.getClazzName() + "PageQueryVo.java"));
        String template = GenerateUtils_Solar.class.getResource("/template/common/PageQueryVoTemplate.txt").getPath();
        ThymeleafService.process(template, writer, clazzDefine, mysqlTable, projectName, moduleName);
    }

    private static void generatePageQueryBo(String projectName, String moduleName) throws IOException {
        FileWriter writer = new FileWriter(new File(outDirectory + "/" + clazzDefine.getClazzName() + "PageQueryBo.java"));
        String template = GenerateUtils_Solar.class.getResource("/template/common/PageQueryBoTemplate.txt").getPath();
        ThymeleafService.process(template, writer, clazzDefine, mysqlTable, projectName, moduleName);
    }

    private static void generateBatchDeleteQueryVo(String projectName, String moduleName) throws IOException {
        FileWriter writer = new FileWriter(new File(outDirectory + "/" + "BatchDeleteQueryVo.java"));
        String template = GenerateUtils_Solar.class.getResource("/template/BatchDeleteQueryVoTemplate.txt").getPath();
        ThymeleafService.process(template, writer, clazzDefine, mysqlTable, projectName, moduleName);
    }

    private static void generateColumnField(String projectName, String moduleName) throws IOException {
        FileWriter writer = new FileWriter(new File(outDirectory + "/ColumnField.txt"));
        String template = GenerateUtils.class.getResource("/template/common/ColumnFieldTemplate.txt").getPath();
        ThymeleafService.process(template, writer, clazzDefine, mysqlTable, projectName, moduleName);
    }

//    private static void generateToVo(String projectName, String moduleName) throws IOException {
//        FileWriter writer = new FileWriter(new File(outDirectory + "/" + clazzDefine.getClazzName() + "toVo.txt"));
//        String template = GenerateUtils.class.getResource("/template/toVo.txt").getPath();
//        ThymeleafService.process(template, writer, clazzDefine, mysqlTable, projectName, moduleName);
//    }

}
