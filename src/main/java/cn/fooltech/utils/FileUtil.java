/**
 * <p>佛山市蠢材科技有限公司</p>
 *
 * @Copyright: 2014-2020 www.fooltech.cn. All rights reserved.
 */
package cn.fooltech.utils;

import com.google.common.io.Files;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * 类的功能描述
 *
 * @author lufeng 2020-06-26
 */
public class FileUtil {

    public static List<String> readRowsByStream(InputStream in) {
        // 使用ArrayList来存储每行读取到的字符串
        ArrayList<String> arrayList = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String str;
            while ((str = br.readLine()) != null) {
                arrayList.add(str);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return arrayList;
    }

    public static List<String> readRowByPath(String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("文件不存在,请检查路径！");
            System.out.println(file.getAbsolutePath());
            return null;
        }

        List<String> list = null;
        try {
            list = Files.readLines(file, Charset.forName("UTF8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }


    public static void main(String[] args) {
//        String path = FileUtil.class.getResource("/template/from_sql.txt").getPath();
//        List<String> list = readRowByPath(path);
//        list.forEach(System.out::println);

        InputStream inputStream =
                FileUtil.class.getClassLoader().getResourceAsStream("template/from_sql.txt");
        List<String> list2 = readRowsByStream(inputStream);
        list2.forEach(System.out::println);

    }


}
