package util;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 * 图像工具
 * Created by yanchuang on 2017/7/27.
 */
public class ImageUtils {

    public static double[] RGB2LAB(int[] rgb) {
        return RGB2LAB(rgb[0], rgb[1], rgb[2]);
    }

    public static double[] RGB2LAB(int ri, int gi, int bi) {
        // first, normalize RGB values
        double r = ri / 255.0;
        double g = gi / 255.0;
        double b = bi / 255.0;

        // D65 standard referent
        double X = 0.950470, Y = 1.0, Z = 1.088830;

        // second, map sRGB to CIE XYZ
        r = r <= 0.04045 ? r / 12.92 : Math.pow((r + 0.055) / 1.055, 2.4);
        g = g <= 0.04045 ? g / 12.92 : Math.pow((g + 0.055) / 1.055, 2.4);
        b = b <= 0.04045 ? b / 12.92 : Math.pow((b + 0.055) / 1.055, 2.4);
        double x = (0.4124564 * r + 0.3575761 * g + 0.1804375 * b) / X,
                y = (0.2126729 * r + 0.7151522 * g + 0.0721750 * b) / Y,
                z = (0.0193339 * r + 0.1191920 * g + 0.9503041 * b) / Z;

        // third, map CIE XYZ to CIE L*a*b* and return
        x = x > 0.008856 ? Math.pow(x, 1.0 / 3) : 7.787037 * x + 4.0 / 29;
        y = y > 0.008856 ? Math.pow(y, 1.0 / 3) : 7.787037 * y + 4.0 / 29;
        z = z > 0.008856 ? Math.pow(z, 1.0 / 3) : 7.787037 * z + 4.0 / 29;

        double L = 116 * y - 16,
                A = 500 * (x - y),
                B = 200 * (y - z);

        double[] result = new double[3];
        result[0] = L;
        result[1] = A;
        result[2] = B;
        return result;
    }

    public static double ciede2000(double[] x, double[] y) {
        // adapted from Sharma et al's MATLAB implementation at
        //  http://www.ece.rochester.edu/~gsharma/ciede2000/

        // parametric factors, use defaults
        double kl = 1, kc = 1, kh = 1;

        // compute terms
        double pi = Math.PI,
                L1 = x[0], a1 = x[1], b1 = x[2], Cab1 = Math.sqrt(a1 * a1 + b1 * b1),
                L2 = y[0], a2 = y[1], b2 = y[2], Cab2 = Math.sqrt(a2 * a2 + b2 * b2),
                Cab = 0.5 * (Cab1 + Cab2),
                G = 0.5 * (1 - Math.sqrt(Math.pow(Cab, 7) / (Math.pow(Cab, 7) + Math.pow(25, 7)))),
                ap1 = (1 + G) * a1,
                ap2 = (1 + G) * a2,
                Cp1 = Math.sqrt(ap1 * ap1 + b1 * b1),
                Cp2 = Math.sqrt(ap2 * ap2 + b2 * b2),
                Cpp = Cp1 * Cp2;

        // ensure hue is between 0 and 2pi
        double hp1 = Math.atan2(b1, ap1);
        if (hp1 < 0) hp1 += 2 * pi;
        double hp2 = Math.atan2(b2, ap2);
        if (hp2 < 0) hp2 += 2 * pi;

        double dL = L2 - L1,
                dC = Cp2 - Cp1,
                dhp = hp2 - hp1;

        if (dhp > +pi) dhp -= 2 * pi;
        if (dhp < -pi) dhp += 2 * pi;
        if (Cpp == 0) dhp = 0;

        // Note that the defining equations actually need
        // signed Hue and chroma differences which is different
        // from prior color difference formulae
        double dH = 2 * Math.sqrt(Cpp) * Math.sin(dhp / 2);

        // Weighting functions
        double Lp = 0.5 * (L1 + L2),
                Cp = 0.5 * (Cp1 + Cp2);

        // Average Hue Computation
        // This is equivalent to that in the paper but simpler programmatically.
        // Average hue is computed in radians and converted to degrees where needed
        double hp = 0.5 * (hp1 + hp2);
        // Identify positions for which abs hue diff exceeds 180 degrees
        if (Math.abs(hp1 - hp2) > pi) hp -= pi;
        if (hp < 0) hp += 2 * pi;

        // Check if one of the chroma values is zero, in which case set
        // mean hue to the sum which is equivalent to other value
        if (Cpp == 0) hp = hp1 + hp2;

        double Lpm502 = (Lp - 50) * (Lp - 50),
                Sl = 1 + 0.015 * Lpm502 / Math.sqrt(20 + Lpm502),
                Sc = 1 + 0.045 * Cp,
                T = 1 - 0.17 * Math.cos(hp - pi / 6)
                        + 0.24 * Math.cos(2 * hp)
                        + 0.32 * Math.cos(3 * hp + pi / 30)
                        - 0.20 * Math.cos(4 * hp - 63 * pi / 180),
                Sh = 1 + 0.015 * Cp * T,
                ex = (180 / pi * hp - 275) / 25,
                delthetarad = (30 * pi / 180) * Math.exp(-1 * (ex * ex)),
                Rc = 2 * Math.sqrt(Math.pow(Cp, 7) / (Math.pow(Cp, 7) + Math.pow(25, 7))),
                RT = -1 * Math.sin(2 * delthetarad) * Rc;

        dL = dL / (kl * Sl);
        dC = dC / (kc * Sc);
        dH = dH / (kh * Sh);

        // The CIE 00 color difference
        return Math.sqrt(dL * dL + dC * dC + dH * dH + RT * dC * dH);
    }

    /**
     * x, y 一定要包含在图像中，否则会报空指针
     *
     * @param image 图像文件
     * @param x     x 坐标
     * @param y     y 坐标
     * @return 返回当前像素点 rgb 值
     * @throws IOException 图像文件可能路径有误
     */
    public static int[] getXYPixel(File image, int x, int y) throws IOException {
        int[] rgb = new int[3];
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(image);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        int pixel = bi.getRGB(x, y);
        // 下面三行代码将一个数字转换为 RGB 数字
        rgb[0] = (pixel & 0xff0000) >> 16;
        rgb[1] = (pixel & 0xff00) >> 8;
        rgb[2] = (pixel & 0xff);
        return rgb;
    }

    public static int[] string2RGB(String str) {
        int[] rgb = new int[3];
        rgb[0] = (Integer.parseInt(str, 16) & 0xff0000) >> 16;
        rgb[1] = (Integer.parseInt(str, 16) & 0xff00) >> 8;
        rgb[2] = (Integer.parseInt(str, 16) & 0xff);
        return rgb;
    }

    public static String RGB2String(int[] rgb) {
        return Integer.toHexString(rgb[0]) + Integer.toHexString(rgb[1]) + Integer.toHexString(rgb[2]);
    }

    /**
      * BufferedImage图片剪裁
      * @param srcBfImg - 被剪裁的BufferedImage
      * @param x - 左上角剪裁点X坐标
      * @param y - 左上角剪裁点Y坐标
      * @param width - 剪裁出的图片的宽度
      * @param height - 剪裁出的图片的高度
      * @return 剪裁得到的BufferedImage
      */
    public static BufferedImage cutBufferedImage(BufferedImage srcBfImg, int x, int y, int width, int height) {
        BufferedImage cutedImage = null;
        CropImageFilter cropFilter = new CropImageFilter(x, y, width, height);
        Image img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(srcBfImg.getSource(), cropFilter));
        cutedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = cutedImage.getGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();
        return cutedImage;
    }

    public static List<File> getListFiles(Object obj) {
        File directory;
        if (obj instanceof File) {
            directory = (File) obj;
        } else {
            directory = new File(obj.toString());
        }
        List<File> files = new ArrayList<File>();
        if (directory.isFile()) {
            files.add(directory);
            return files;
        } else if (directory.isDirectory()) {
            File[] fileArr = directory.listFiles();
            for (File file : fileArr) {
                files.addAll(getListFiles(file));
            }
        }
        return files;
    }

}
