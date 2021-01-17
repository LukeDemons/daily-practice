package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import util.ImageUtils;

/**
 * 色差测试
 * Created by yanchuang on 2017/7/27.
 */
public class CIEDE2000Test {

    public void simpleTest() {
        int r1 = 255, g1 = 0, b1 = 0;
        int r2 = 252, g2 = 0, b2 = 5;
        double[] x = ImageUtils.RGB2LAB(r1, g1, b1);
        double[] y = ImageUtils.RGB2LAB(r2, g2, b2);
        double delta = ImageUtils.ciede2000(x, y);

        System.out.println(delta);
    }

    public void compare2RGB() throws IOException {
        String rgb1 = "d5d7d5";
        String rgb2 = "d5d5d7";

        double[] x = ImageUtils.RGB2LAB(ImageUtils.string2RGB(rgb1));
        double[] y = ImageUtils.RGB2LAB(ImageUtils.string2RGB(rgb2));

        System.out.println(rgb1 + "-" + rgb2);
        System.out.println(ImageUtils.ciede2000(x, y));
    }

    public void compareP2P() throws IOException {
        String standard = "d5d5d5";
        String fileName = "41.jpg";
        File standardFile = new File("src/test/resources/img/compare/standards/" + fileName);
        int[] rgb = ImageUtils.getXYPixel(standardFile, 10, 10);
        double[] x = ImageUtils.RGB2LAB(rgb);

        double[] y = ImageUtils.RGB2LAB(ImageUtils.string2RGB(standard));

        System.out.println(ImageUtils.RGB2String(rgb) + "-" + standard);

        System.out.println(ImageUtils.ciede2000(x, y));
    }

    public void compareAllRGB() throws IOException {
        String[] standards = {"dee6e9", "e2eceb", "e3e6dd", "e7ebee", "e2e3e8",
                "dfe6ea", "e2ecea", "e3e6dc", "e7ebee", "e1e3e9",
                "f3eee8", "ede7e9", "f0edef", "efedf0"};
        double delta = 100d;
        String warmest = "init";
        File standardFile = new File("src/test/resources/part3/364890.jpg");
        for (String standard : standards) {
            int[] rgb = ImageUtils.getXYPixel(standardFile, 10, 10);
            double[] x = ImageUtils.RGB2LAB(rgb);

            double[] y = ImageUtils.RGB2LAB(ImageUtils.string2RGB(standard));

            System.out.println(ImageUtils.RGB2String(rgb) + "-" + standard);

            if (ImageUtils.ciede2000(x, y) < delta) {
                delta = ImageUtils.ciede2000(x, y);
                warmest = standard;
            }

        }
        System.out.println(delta + "======" + warmest);
    }
    // 结论：demo 图读完都有 0.5 的色差

    public void compareAll() throws IOException {
        String basePath = "src/test/resources/img/compare/standard";
        List<File> files = ImageUtils.getListFiles(basePath);
        double delta = 100d;
        String warmest = "init";
        for (File standardFile : files) {
            int[] standardRGB = ImageUtils.getXYPixel(standardFile, 10, 10);
            double[] x = ImageUtils.RGB2LAB(standardRGB);

            File compareFile = new File("src/test/resources/img/compare/2140-327001.jpg");
            int[] rgb = ImageUtils.getXYPixel(compareFile, 10, 10);
            double[] y = ImageUtils.RGB2LAB(rgb);


//            System.out.println("red " + rgb[0] + "-" + standardRGB[0] + "; green " +
//                    rgb[1] + "-" + standardRGB[1] + "; blue " + rgb[2] + "-" + standardRGB[2] + ";");
            System.out.println(standardFile.getName() + "-" + ImageUtils.RGB2String(standardRGB));

            if (ImageUtils.ciede2000(x, y) < delta) {
                delta = ImageUtils.ciede2000(x, y);
                warmest = standardFile.getName();
            }

        }
        System.out.println(delta + "======" + warmest);
    }
    // 结论，最接近第一张，且色差为 2.058

    public void compare() throws IOException {

        File standardFile = new File("src/test/resources/img/compare/standard/21.jpg");
        int[] standardRGB = ImageUtils.getXYPixel(standardFile, 10, 10);
        double[] x = ImageUtils.RGB2LAB(standardRGB);

        File compareFile = new File("src/test/resources/img/compare/2311-324583.jpg");
        int[] rgb = ImageUtils.getXYPixel(compareFile, 10, 10);
        double[] y = ImageUtils.RGB2LAB(rgb);

        System.out.println("red " + rgb[0] + "-" + standardRGB[0] + "; green " +
                rgb[1] + "-" + standardRGB[1] + "; blue " + rgb[2] + "-" + standardRGB[2] + ";");
        System.out.println(ImageUtils.RGB2String(rgb) + "-" + ImageUtils.RGB2String(standardRGB));

        double delta = ImageUtils.ciede2000(x, y);

        System.out.println(delta);
    }

    public void imageAllTest() throws IOException {

        String[] part1 = {"efeae5", "eff2e7", "f1ebed", "edebe1", "ebe7e3"};
        String[] part2 = {"f1eeef", "f1ebed", "eeeff3", "f1edf4", "f4edea",
                "ede5e5", "f1ebe8", "eee6ea", "f3eee8", "ede7e9", "f0edef", "e6e8ed"};

        String[] part1_f = {"efeae6", "eff2e7", "f1ebed", "edede3", "ebe8e3"};
        String[] part2_f = {"f0eeef", "f1ebed", "eeeff3", "f0edf4", "f5edea",
                "ede4e5", "f1ece9", "efe6eb", "f3eee8", "ede7e9", "efedf0", "e7e8ed"};
        String[] part3 = {"dfe6ea", "e2ecea", "e3e6dc", "e7ebee", "e1e3e9"};
        String[] part3_f = {"dee6e9", "e2eceb", "e3e6dd", "e7ebee", "e2e3e8"};
        String[] part4 = {"e0e0e0", "d5d5d5"};

        handleFile("part4_pass", part4);
//        handleFile("part1_deny", part1);
//        handleFile("part2_pass", part2);
//        handleFile("part3_pass", part3);
//        handleFile("part4_pass", part4);

//        handlePart(part4);

    }

    private void handlePart(String[] standardList) {
        double max = 0;
        for (int i = 0; i < standardList.length; i++) {
            for (int j = 0; j < i; j++) {
                double[] x = ImageUtils.RGB2LAB(ImageUtils.string2RGB(standardList[i]));
                double[] y = ImageUtils.RGB2LAB(ImageUtils.string2RGB(standardList[j]));
                double temp = ImageUtils.ciede2000(x, y);
                if (temp > max) {
                    max = temp;
                }
            }
        }
        System.out.printf("%.3f%n", max);
    }

    private void handleFile(String filePath, String[] standardList) throws IOException {
        Map<File, Double> map = new TreeMap<>();

        String basePath = "D:\\WorkSpace\\pycharm\\img\\";
        List<File> files = ImageUtils.getListFiles(basePath + filePath);
        for (String standard : standardList) {
            int[] standardRGB = ImageUtils.string2RGB(standard);
            double[] x = ImageUtils.RGB2LAB(standardRGB);

            for (File file : files) {
                int[] rgb = ImageUtils.getXYPixel(file, 10, 10);
                System.out.println("red " + rgb[0] + "-" + standardRGB[0] + "; green " +
                        rgb[1] + "-" + standardRGB[1] + "; blue " + rgb[2] + "-" + standardRGB[2] + ";");
                double[] y = ImageUtils.RGB2LAB(rgb);
                double delta = ImageUtils.ciede2000(x, y);

                System.out.println(delta);
                if (map.get(file) == null || map.get(file) > delta) {
                    map.put(file, delta);
                }

            }
        }
        // 这里将 map.entrySet() 转换成list
        List<Map.Entry<File, Double>> list = new ArrayList<>(map.entrySet());
        // 然后通过比较器来实现升序排序
        list.sort(Map.Entry.comparingByValue());

        File file = new File("C:\\Users\\yanchuang\\Desktop\\part4_pic_rgb.txt");
        FileWriter fw = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fw);
//        double count = 0;
        for (Map.Entry<File, Double> mapping : list) {
//            System.out.println(mapping.getKey() + ": " + mapping.getValue());
//            if (mapping.getValue() <= 1) {
//                count++;
//            }
            String ad_id = mapping.getKey().getName();
            ad_id = ad_id.split("\\.")[0];
            System.out.println(ad_id + "\t" +
                    String.format("%.3f", mapping.getValue()));



            writer.write(ad_id + "\t" +
                    String.format("%.3f", mapping.getValue()));
            writer.newLine();//换行
            writer.flush();

        }
//        System.out.println("通过数量：" + (int)count + "，总数量共：" + list.size() + "，" +
//                "通过率为：" + String.format("%.3f", count / list.size() * 100) + "%");

        writer.close();
        fw.close();
    }

    public void imageTest() throws IOException {
        Map<File, Double> map = new TreeMap<>();

        String[] standards = {"efeae5", "eff2e7", "f1ebed", "edebe1", "ebe7e3"};
        String basePath = "C:\\Users\\yanchuang\\Desktop\\CPD-template\\爱吃素材\\pass";
        List<File> files = ImageUtils.getListFiles(basePath);
        for (String standard : standards) {
            int[] standardRGB = ImageUtils.string2RGB(standard);
            double[] x = ImageUtils.RGB2LAB(standardRGB);

            for (File file : files) {
                int[] rgb = ImageUtils.getXYPixel(file, 10, 10);
                System.out.println("red " + rgb[0] + "; green " + rgb[1] + "; blue " + rgb[2] + ";");
                double[] y = ImageUtils.RGB2LAB(rgb);
                double delta = ImageUtils.ciede2000(x, y);

                System.out.println(delta);
                if (map.get(file) == null || map.get(file) > delta) {
                    map.put(file, delta);
                }

            }
        }

        // 这里将 map.entrySet() 转换成list
        List<Map.Entry<File, Double>> list = new ArrayList<>(map.entrySet());
        // 然后通过比较器来实现升序排序
        list.sort(Map.Entry.comparingByValue());

        for (Map.Entry<File, Double> mapping : list) {
            System.out.println(mapping.getKey() + ": " + mapping.getValue());
        }

    }

    public void string2RGBTest() {
        ImageUtils.string2RGB("FFCCEE");
    }
}
