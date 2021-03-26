package TestCode;

import java.util.*;

public class test5 {
    //这是一个统计代英语句子中单词数的程序
    public static Set<String> wordsStatisticsInSet(String sentence) {
        String str = sentence.toLowerCase();
        String[] sentence1 = str.trim().split("[, . ? ! ; \' \" : ]");
        TreeSet<String> res = new TreeSet<>(Arrays.asList(sentence1));
        int n = res.size();
        System.out.println("单词个数（不计重复单词） = " + n);
        Arrays.sort(sentence1);
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < sentence1.length; i++) {
            if (!("".equals(sentence1[i]))) {
                Iterator<String> it = map.keySet().iterator();
                map.put(sentence1[i], 1);
            }
        }
        for (Map.Entry<String, Integer> wards : map.entrySet()) {
            System.out.print(wards.getKey());
            System.out.print("\t");
        }
        System.out.print("\n");
        return null;
    }

    public static List<String> wordsStatisticsInList(String sentence) {
        String str = sentence.toLowerCase();
        String[] sentence2 = str.trim().split("[, . ? ! ; ]");
        ArrayList<String> res = new ArrayList<>(Arrays.asList(sentence2));
        int n = res.size();
        System.out.println("单词个数（计重复单词） = " + n);
        Arrays.sort(sentence2);
        for (int i = 0; i < sentence2.length; i++) {
            System.out.print(sentence2[i]);
            System.out.print("\t");
        }
        System.out.print("\n");

        return null;
    }

    public static Map<String, Integer> wordsStatisticsInMap(String sentence) {
        System.out.print("单词出现次数\n");
        String str = sentence.toLowerCase();
        String[] sentence3 = str.trim().split("[, . ? ! ; \' \" : ]");
        Arrays.sort(sentence3);
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < sentence3.length; i++) {
            if (!("".equals(sentence3[i]))) {
                Iterator<String> it = map.keySet().iterator();
                boolean exist = false;
                while (it.hasNext()) {
                    String key = it.next();
                    if (key.equalsIgnoreCase(sentence3[i])) {
                        exist = true;
                        map.put(key, map.get(key) + 1);
                    }
                }
                if (exist == false) {
                    map.put(sentence3[i], 1);
                }
            }
        }
        for (Map.Entry<String, Integer> wards : map.entrySet()) {
            System.out.print(wards.getKey() + ":" + wards.getValue());
            System.out.print("\t");
        }

        return null;
    }


    public static void main(String[] args) {
        String sentence = "  There are moments in life when you miss someone so much that you just want to pick them from your dreams and hug them for real! Dream what you want to dream;go where you want to go;be what you want to be,because you have only food life and food chance to do all the things you want to do. ";

        wordsStatisticsInSet(sentence);
        wordsStatisticsInList(sentence);
        wordsStatisticsInMap(sentence);

    }
}

