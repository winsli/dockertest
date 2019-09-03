/**
 * All rights Reserved, Designed By winsli
 * @Title:  Base64.java
 * @Package com.chaoxing.dockertest.utils
 * @Description:
 * @author: winsli
 * @date:   2019年7月18日 上午11:04:21
 * @version V1.0
 * @Copyright: 2019
 * 注意：本内容仅限于超星集团内部传阅，禁止外泄以及用于其他的商业目
 */
package com.chaoxing.dockertest.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @author winsl
 *
 */
public class Base64Util
{

    /**
     * 解码
     * 
     * @param text
     * @return
     */
    public static String decoder(String text)
    {
        final Base64.Decoder decoder = Base64.getDecoder();
        byte[] textByte;
        try
        {
            textByte = text.getBytes("UTF-8");
            // 解码
            return new String(decoder.decode(textByte), "UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 编码
     * 
     * @param text
     * @return
     */
    public static String encoder(String text)
    {
        // 编码
        final Base64.Encoder encoder = Base64.getEncoder();
        byte[] textByte = null;
        try
        {
            textByte = text.getBytes("UTF-8");
            final String encodedText = encoder.encodeToString(textByte);
            return encodedText;
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args)
    {
        System.out.println(Base64Util.encoder("/opt"));
    }
}
