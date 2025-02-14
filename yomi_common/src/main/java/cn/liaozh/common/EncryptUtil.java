package cn.liaozh.common;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.MessageDigest;
import java.security.SecureRandom;

public class EncryptUtil {
    public static final String MD5 = "MD5";
    public static final String SHA1 = "SHA1";
    public static final String HmacMD5 = "HmacMD5";
    public static final String HmacSHA1 = "HmacSHA1";
    public static final String DES = "DES";
    public static final String AES = "AES";
    public static String charset = "utf-8";
    public static int keysizeDES = 0;
    public static int keysizeAES = 128;

    public EncryptUtil() {
    }

    private static String messageDigest(String res, String algorithm) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            byte[] resBytes = charset == null ? res.getBytes() : res.getBytes(charset);
            return base64(md.digest(resBytes));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String keyGeneratorMac(String res, String algorithm, String key) {
        try {
            SecretKey sk = null;
            Object var7;
            if (key == null) {
                KeyGenerator kg = KeyGenerator.getInstance(algorithm);
                var7 = kg.generateKey();
            } else {
                byte[] keyBytes = charset == null ? key.getBytes() : key.getBytes(charset);
                var7 = new SecretKeySpec(keyBytes, algorithm);
            }

            Mac mac = Mac.getInstance(algorithm);
            mac.init((Key)var7);
            byte[] result = mac.doFinal(res.getBytes());
            return base64(result);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String keyGeneratorES(String res, String algorithm, String key, int keysize, boolean isEncode) {
        try {
            KeyGenerator kg = KeyGenerator.getInstance(algorithm);
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            byte[] keyBytes = charset == null ? key.getBytes() : key.getBytes(charset);
            secureRandom.setSeed(keyBytes);
            kg.init(secureRandom);
            SecretKey sk = kg.generateKey();
            SecretKeySpec sks = new SecretKeySpec(sk.getEncoded(), algorithm);
            Cipher cipher = Cipher.getInstance(algorithm);
            if (isEncode) {
                cipher.init(1, sks);
                byte[] resBytes = charset == null ? res.getBytes() : res.getBytes(charset);
                return parseByte2HexStr(cipher.doFinal(resBytes));
            } else {
                cipher.init(2, sks);
                return new String(cipher.doFinal(parseHexStr2Byte(res)));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String base64(byte[] res) {
        return Base64.encode(res);
    }

    public static String parseByte2HexStr(byte[] buf) {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < buf.length; ++i) {
            String hex = Integer.toHexString(buf[i] & 255);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }

            sb.append(hex.toUpperCase());
        }

        return sb.toString();
    }

    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        } else {
            byte[] result = new byte[hexStr.length() / 2];

            for(int i = 0; i < hexStr.length() / 2; ++i) {
                int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
                int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
                result[i] = (byte)(high * 16 + low);
            }

            return result;
        }
    }

    public static String MD5(String res) {
        return messageDigest(res, "MD5");
    }

    public static String MD5(String res, String key) {
        return keyGeneratorMac(res, "HmacMD5", key);
    }

    public static String SHA1(String res) {
        return messageDigest(res, "SHA1");
    }

    public static String SHA1(String res, String key) {
        return keyGeneratorMac(res, "HmacSHA1", key);
    }

    public static String DESencode(String res, String key) {
        return keyGeneratorES(res, "DES", key, keysizeDES, true);
    }

    public static String DESdecode(String res, String key) {
        return keyGeneratorES(res, "DES", key, keysizeDES, false);
    }

    public static String AESencode(String res, String key) {
        return keyGeneratorES(res, "AES", key, keysizeAES, true);
    }

    public static String AESdecode(String res, String key) {
        return keyGeneratorES(res, "AES", key, keysizeAES, false);
    }

    public static String XORencode(String res, String key) {
        byte[] bs = res.getBytes();

        for(int i = 0; i < bs.length; ++i) {
            bs[i] = (byte)(bs[i] ^ key.hashCode());
        }

        return parseByte2HexStr(bs);
    }

    public static String XORdecode(String res, String key) {
        byte[] bs = parseHexStr2Byte(res);

        for(int i = 0; i < bs.length; ++i) {
            bs[i] = (byte)(bs[i] ^ key.hashCode());
        }

        return new String(bs);
    }

    public static int XOR(int res, String key) {
        return res ^ key.hashCode();
    }

    public static String Base64Encode(String res) {
        return Base64.encode(res.getBytes());
    }

    public static String Base64Decode(String res) {
        return new String(Base64.decode(res));
    }
}
