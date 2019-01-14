package com.guo.publictools.common;


import org.apache.commons.lang3.StringUtils;

import java.util.Random;

/**
 * publictools
 * <p>
 * @author guohl
 * <p>
 * @date 2019/1/14 9:24
 * <p>
 * @description
 *      字符串工具类
 */
public class StringToolUtils {

    /**
     * 将最后一个符号去掉
     *
     * @param result
     *            待处理的字符串
     * @param symbol
     *            待去掉的符号
     * @return StringBuffer
     *            处理好的字符串
     */
    public static StringBuffer deleteLastComma(StringBuffer result, String symbol) {
        // 将最后一个“,”截掉
        String outPutResult = result.toString();
        if (StringUtils.indexOf(outPutResult, symbol) > -1) {
            //判断是否该符号为字符串最后一位
            if (outPutResult.lastIndexOf(symbol) == (outPutResult.length() - 1)) {
                outPutResult = StringUtils.substringBeforeLast(outPutResult, symbol);
            }
        }

        return new StringBuffer(outPutResult);
    }

    /**
     * 将字符串转成unicode
     *
     * @param str
     *            待转字符串
     * @return unicode字符串
     */
    public static String convertToUnicode(String str) {
        str = (str == null ? "" : str);
        String tmp;
        StringBuffer sb = new StringBuffer(1000);
        char c;
        int i, j;
        sb.setLength(0);
        for (i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            sb.append("\\u");
            //取出高8位
            j = (c >>> 8);
            tmp = Integer.toHexString(j);

            if (tmp.length() == 1) {
                sb.append("0");
            }

            sb.append(tmp);
            //取出低8位
            j = (c & 0xFF);
            tmp = Integer.toHexString(j);
            if (tmp.length() == 1) {
                sb.append("0");
            }
            sb.append(tmp);
        }
        return (new String(sb));
    }

    /**
     * unicode解码（unicode编码转中文）
     *
     * @param theString
     *            字符串
     * @return String
     */
    public static String unicodeDecode(String theString) {
        char aChar;
        int len = theString.length();
        StringBuffer outBuffer = new StringBuffer(len);
        for (int x = 0; x < len;) {
            aChar = theString.charAt(x++);
            if (aChar == '\\') {
                aChar = theString.charAt(x++);

                if (aChar == 'u') {
                    // Read the xxxx
                    int value = 0;
                    for (int i = 0; i < 4; i++) {
                        aChar = theString.charAt(x++);
                        switch (aChar) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                value = (value << 4) + aChar - '0';
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (value << 4) + 10 + aChar - 'a';
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                value = (value << 4) + 10 + aChar - 'A';
                                break;
                            default:
                                throw new IllegalArgumentException("Malformed   \\uxxxx   encoding.");
                        }
                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't') {
                        aChar = '\t';
                    } else if (aChar == 'r') {
                        aChar = '\r';
                    } else if (aChar == 'n') {
                        aChar = '\n';
                    } else if (aChar == 'f') {
                        aChar = '\f';
                    }
                    outBuffer.append(aChar);
                }
            } else {
                outBuffer.append(aChar);
            }
        }
        return outBuffer.toString();
    }

    /**
     * 生成6位随机码
     * @return 6位随机码
     */
    public static String getSixRandomString() {
        //length表示生成字符串的长度
        String base = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
