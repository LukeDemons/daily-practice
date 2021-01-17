package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import util.ImagePHash;
import util.ImageUtils;

public class PHashTest {

    public void imageHash() throws Exception {
        ImagePHash tool = new ImagePHash(32, 8);
        List<File> repeatList = ImageUtils.getListFiles("src/test/resources/repeat2");
        Map<String, List<String>> resultMap = new TreeMap<>();

        for (int i = 0; i < repeatList.size(); i++) {
            for (int j = 0; j < i; j++) {
                InputStream is1 = new FileInputStream(repeatList.get(i));
                InputStream is2 = new FileInputStream(repeatList.get(j));
                String hash1 = tool.getHash(is1);
                String hash2 = tool.getHash(is2);
                String key = repeatList.get(i).getName().concat("|").concat(repeatList.get(j).getName());
                int distance = tool.distance(hash1, hash2);

                List<String> list = new ArrayList<>(3);
                list.add(distance + "");
                list.add(hash1);
                list.add(hash2);
                resultMap.put(key, list);
            }
        }

        for (Map.Entry<String, List<String>> entry : resultMap.entrySet()) {
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }
    }
}
