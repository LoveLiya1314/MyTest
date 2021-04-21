/******************************************************************************
 * VIDI VINI VIKI                                                             *
 * Copyright ©  17:3 2021 -4 -21  Lambert All rights reserved.                *
 *    Licensed under the Apache License, Version 2.0 (the "License");         *
 *    you may not use this file except in compliance with the License.        *
 *    You may obtain a copy of the License at                                 *
 *                                                                            *
 *      http://www.apache.org/licenses/LICENSE-2.0                            *
 *                                                                            *
 *    Unless required by applicable law or agreed to in writing, software     *
 *    distributed under the License is distributed on an "AS IS" BASIS,       *
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.*
 *    See the License for the specific language governing permissions and     *
 *    limitations under the License.                                          *
 * Love Liya Forever!                                                         *
 ******************************************************************************/

package ApplicationCode;
public class Feistel {


    /**
     * 加密轮数
     **/
    private static final int LOOP_NUM = 16;
    private final String[] keys = new String[LOOP_NUM];
    private String[] pContent;
    private String[] cContent;
    private int origin_length;

    public Feistel(String content, String key) {
        generateKey(key);
        divideGroups(content);

        System.out.println("原始明文：" + content + "\n原始密钥：" + key);
    }

    public static void main(String[] args) {

        Feistel feistelTest = new Feistel("Android将军->GeneralAndroid", "ABCDE");
        feistelTest.encrypt();
        feistelTest.decrypt();


    }

    public void encrypt() {
        StringBuilder c = new StringBuilder();
        for (int i = 0; i < pContent.length; i++) {
            cContent[i] = loop(pContent[i], 0);
            c.append(cContent[i]);
        }

        System.out.println("密文:\n" + c);
    }

    public void decrypt() {
        StringBuilder p = new StringBuilder();
        for (int i = 0; i < cContent.length; i++) {
            pContent[i] = loop(cContent[i], 1);
            p.append(pContent[i]);
        }
        System.out.println("明文：\n" + p.substring(0, origin_length));
    }

    /**
     * 生成子密钥，采用简单移位操作来实现
     **/
    public void generateKey(String key) {
        while (key.length() < 16) {
            key = key + key;
        }
        key = key.substring(0, 16);
//        System.out.println("after sub key:"+key);
        for (int i = 0; i < 16; i++) {
            key = swapStr(key, i);
            keys[i] = key;
        }
//        System.out.println(Arrays.toString(keys));
    }

    private String swapStr(String key, int i) {
        char last = key.charAt(key.length() - 1);
        key = last + key.substring(0, key.length() - 1);
//        System.out.println("i:"+i+"\t key:"+key);
        return key;
    }

    /**
     * 对明文进行分组
     **/
    public void divideGroups(String content) {
        int g_num;
        int m_num;
        int b_num;
        origin_length = content.length();
        g_num = origin_length / 8;
        m_num = origin_length % 8;
        b_num = 8 - m_num;
//        System.out.println("g_num:"+g_num+"\t m_num:"+m_num+"\t b_num:"+b_num);
        if (m_num != 0) {
            for (int i = 0; i <= b_num; i++) {
                content = content + b_num;
            }
        }
        g_num = content.length() / 8;
        pContent = new String[g_num];
        cContent = new String[g_num];
        for (int i = 0; i < g_num; i++) {
            pContent[i] = content.substring(8 * i, 8 * (i + 1));
        }
//        System.out.println(Arrays.toString(pContent));
    }


    /**
     * 轮加密与解密
     **/
    public String loop(String content, int flag) {
        if (flag == 0) {
            for (int i = 0; i < 16; i++) {
                content = f(i, content, flag);
            }
        } else if (flag == 1) {
            for (int i = 15; i > -1; i--) {
                content = f(i, content, flag);
            }
        }
        return content;

    }

    /**
     * f函数
     **/
    public String f(int time, String content, int flag) {
        if (content.length() > 8) {
            System.out.println("ERROR!!!!!");
        }
        String LE = content.substring(0, 4);
        String RE = content.substring(4, 8);
        String LE1 = null;
        String RE1 = null;
        String key = keys[time];
//        System.out.println("LE:"+LE+"\t RE:"+RE+"\t key:"+key);
        char[] tmp = new char[4];
        for (int j = 0; j < 4; j++) {
            tmp[j] = (char) (RE.charAt(j) ^ key.charAt(4 * j) ^ LE.charAt(j));
        }
//        System.out.println("tmp re:"+Arrays.toString(tmp));
        LE1 = RE;
        RE1 = new String(tmp);
//        System.out.println("time:"+time+"\t L:"+LE1+RE1+"\t key:"+key);


        if (((flag == 0) && (time == 15)) || ((flag == 1) && (time == 0))) {
            return RE1 + LE1;
        }

        return LE1 + RE1;
    }


}
