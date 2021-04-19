/**
 * <p>佛山市蠢材科技有限公司</p>
 *
 * @Copyright: 2014-${year} www.fooltech.cn. All rights reserved.
 */
package cn.fooltech.engine;

import cn.fooltech.model.ClazzDefine;
import cn.fooltech.model.ClazzWrap;
import cn.fooltech.model.JavaField;
import cn.fooltech.model.MysqlTable;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.FileTemplateResolver;

import javax.swing.table.TableModel;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * thymeleaf引擎处理模板
 *
 * @author lufeng 2019-05-29
 */
public class ThymeleafService {
    /**
     * 使用环境(web/非web)
     */
    private static Context context;

    /**
     * 模板引擎（解析模板,生成目标文件）
     */
    private static TemplateEngine templateEngine;

    /**
     * 用来定位模板位置
     */
    private static FileTemplateResolver templateResolver;


    public static void process(String template, Writer writer, ClazzWrap clazzWrap) throws IOException {
        String prefix = template.substring(0, template.lastIndexOf("/") + 1);
        String suffix = "." + template.split("\\.")[1];
        String fileName = template.substring(template.lastIndexOf("/") + 1, template.indexOf("."));

        // 1.声明一个 TemplateEngine
        templateEngine = new TemplateEngine();

        // 2.声明context
        context = new Context();
        context.setVariable("clazzWrap", clazzWrap);

        // 3.声明模板解析器
        templateResolver = new FileTemplateResolver();
        templateResolver.setTemplateMode(TemplateMode.TEXT);
        templateResolver.setPrefix(prefix);
        templateResolver.setSuffix(suffix);
        templateResolver.setCharacterEncoding("utf-8");

        // 3.设置 templateResolver
        templateEngine.setTemplateResolver(templateResolver);

        // 4.调用 process方法处理模板
        templateEngine.process(fileName, context, writer);
    }

    public static void process(String template, Writer writer, ClazzDefine clazzDefine, MysqlTable mysqlTable,
                               String projectName, String moduleName) throws IOException {
        String prefix = template.substring(0, template.lastIndexOf("/") + 1);
        String suffix = "." + template.split("\\.")[1];
        String fileName = template.substring(template.lastIndexOf("/") + 1, template.indexOf("."));

        // 1.声明一个 TemplateEngine
        templateEngine = new TemplateEngine();

        // 2.声明context
        context = new Context();
        context.setVariable("clazzDefine", clazzDefine);
        context.setVariable("mysqlTable", mysqlTable);
        context.setVariable("projectName", projectName);
        context.setVariable("moduleName", moduleName);

        // 3.声明模板解析器
        templateResolver = new FileTemplateResolver();
        templateResolver.setTemplateMode(TemplateMode.TEXT);
        templateResolver.setPrefix(prefix);
        templateResolver.setSuffix(suffix);
        templateResolver.setCharacterEncoding("utf-8");

        // 3.设置 templateResolver
        templateEngine.setTemplateResolver(templateResolver);

        // 4.调用 process方法处理模板
        templateEngine.process(fileName, context, writer);
    }

    public static void process2(String prefix, String suffix, String fileName, Writer writer, TableModel tableModel,
                                String projectName,
                                String moduleName) throws IOException {
        // 1.声明一个 TemplateEngine
        templateEngine = new TemplateEngine();

        // 2.声明context
        context = new Context();
        context.setVariable("tableModel", tableModel);
        context.setVariable("projectName", projectName);
        context.setVariable("moduleName", moduleName);

        // 3.声明模板解析器
        templateResolver = new FileTemplateResolver();
        templateResolver.setTemplateMode(TemplateMode.TEXT);
        templateResolver.setPrefix(prefix);
        templateResolver.setSuffix(suffix);
        templateResolver.setCharacterEncoding("utf-8");

        // 3.设置 templateResolver
        templateEngine.setTemplateResolver(templateResolver);

        // 4.调用 process方法处理模板
        templateEngine.process(fileName, context, writer);
    }


    public static void processTest(String prefix, String suffix, String fileName, Writer writer, List<JavaField> list) throws IOException {
        // 1.声明一个 TemplateEngine
        templateEngine = new TemplateEngine();

        // 2.声明context
        context = new Context();
        context.setVariable("list", list);

        // 3.声明模板解析器
        templateResolver = new FileTemplateResolver();
        templateResolver.setTemplateMode(TemplateMode.TEXT);
        templateResolver.setPrefix(prefix);
        templateResolver.setSuffix(suffix);
        templateResolver.setCharacterEncoding("utf-8");

        // 3.设置 templateResolver
        templateEngine.setTemplateResolver(templateResolver);

        // 4.调用 process方法处理模板
        templateEngine.process(fileName, context, writer);
    }

}
