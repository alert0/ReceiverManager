package tznin.com.receivermanager;

/**
 * Created by PC on 2016/4/29.
 */



    import android.util.Base64;

    import java.security.Key;
    import java.security.KeyFactory;
    import java.security.KeyPair;
    import java.security.KeyPairGenerator;
    import java.security.PrivateKey;
    import java.security.PublicKey;
    import java.security.Signature;
    import java.security.interfaces.RSAPrivateKey;
    import java.security.interfaces.RSAPublicKey;
    import java.security.spec.PKCS8EncodedKeySpec;
    import java.security.spec.X509EncodedKeySpec;
    import java.util.HashMap;
    import java.util.Map;

    import javax.crypto.Cipher;

    public class RSA {



       public static  String PUBLICKEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC7ngibX7hBGf+tXi+Pa/FzwCbFwetrH2Mlu3XJ+s8xJ41EXNK98nyLDoEMXE5ZhiYyt9ypKwTtIBNGmh9+fpjmHfIUqbYaHyyuGIPK7wRBfIwgy2zT5MuFZbsGmRjSXaZRjhluNsYi8wVLQdt8Wgjv/W8ZbnsV0Ccp0keh5LRXYwIDAQAB";//RSA.getPublicKey(key);
       public static  String PRIVATEKEY = "/61eL49r8XPAJsXB62sfYyW7dcn6zzEnjURc0r3yfIsOgQxcTlmGJjK33KkrBO0gE0aaH35+mOYd8hSpthofLK4Yg8rvBEF8jCDLbNPky4VluwaZGNJdplGOGW42xiLzBUtB23xaCO/9bxluexXQJynSR6HktFdjAgMBAAECgYB+UGClEuW/VtyvgTjuC5ONBbJU9EEmZwRek/4ylRzHkERo4UG1RruY95PkmYTaexnejbEPZ/oyF6VCpGNNy7fuFl7/gKE92ubouTYOgFHcchM9jj09lBVoqAVB8bb/EY9odVFgXIVulsMzXw386GYOtGAxc97niHSFRVvYqP9VsQJBAOiDFr8VLmXWDB7Fh3L90BtAyQfgqnylt0xdfqevujb5cNsqqv7LVq8BEe+Jj/l+QwpvNjqJ2OIrZIUj7iv7cOkCQQDOkfAUvCQK9LuJzqZn33MCwkp/bwOEpCTyOFLAMtjlFNNZqKjJGAEdWP7gfT2zc7L/hs6uVSmxq/jbt1mrkzZrAkAZpLuRf4iKer0Dd82khRG6r758O+8RqEU7CuS5Icxr277yrRYG2+5HhtqvjIBwh9hlAjb85c8hwp9nf7r45tZhAkEAge4deo1UhmelRmrrFE7iQov+2+Tx645rhseSlT3mW0EcJzsE32fv24vM1VsxYhyWLE+Y1OLQVOb8owbSqi7wfQJBAMtYJcQ9sETSw2jqbNhdq3B0r5+3ADg3gPUgc2TD2AEG53iYuQFs3jw8B+AelleRoncKXWss5cMw2QroLpgZF9E=";//RSA.getPrivateKey(key);


        public static final String KEY_ALGORITHM = "RSA";
        public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

        private static final String PUBLIC_KEY = "RSAPublicKey";
        private static final String PRIVATE_KEY = "RSAPrivateKey";

        public static byte[] decryptBASE64(String key) throws Exception {
            return Base64.decode(key, Base64.DEFAULT);
        }

        public static String encryptBASE64(byte[] key) throws Exception {
            return Base64.encodeToString(key, Base64.DEFAULT);
        }

        /**
         * 用私钥对信息生成数字签名
         *
         * @param data
         *            加密数据
         * @param privateKey
         *            私钥
         *
         * @return
         * @throws Exception
         */
        public static String sign(byte[] data, String privateKey) throws Exception {
            // 解密由base64编码的私钥
            byte[] keyBytes = decryptBASE64(privateKey);

            // 构造PKCS8EncodedKeySpec对象
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);

            // KEY_ALGORITHM 指定的加密算法
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

            // 取私钥匙对象
            PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);

            // 用私钥对信息生成数字签名
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initSign(priKey);
            signature.update(data);

            return encryptBASE64(signature.sign());
        }

        /**
         * 校验数字签名
         *
         * @param data
         *            加密数据
         * @param publicKey
         *            公钥
         * @param sign
         *            数字签名
         *
         * @return 校验成功返回true 失败返回false
         * @throws Exception
         *
         */
        public static boolean verify(byte[] data, String publicKey, String sign)
                throws Exception {

            // 解密由base64编码的公钥
            byte[] keyBytes = decryptBASE64(publicKey);

            // 构造X509EncodedKeySpec对象
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);

            // KEY_ALGORITHM 指定的加密算法
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

            // 取公钥匙对象
            PublicKey pubKey = keyFactory.generatePublic(keySpec);

            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initVerify(pubKey);
            signature.update(data);

            // 验证签名是否正常
            return signature.verify(decryptBASE64(sign));
        }

        /**
         * 解密<br>
         * 用私钥解密
         *
         * @param data
         * @param key
         * @return
         * @throws Exception
         */
        public static byte[] decryptByPrivateKey(byte[] data, String key)
                throws Exception {
            // 对密钥解密
            byte[] keyBytes = decryptBASE64(key);

            // 取得私钥
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

            // 对数据解密
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, privateKey);

            return cipher.doFinal(data);
        }

        /**
         * 解密<br>
         * 用公钥解密
         *
         * @param data
         * @param key
         * @return
         * @throws Exception
         */
        public static byte[] decryptByPublicKey(byte[] data, String key)
                throws Exception {
            // 对密钥解密
            byte[] keyBytes = decryptBASE64(key);

            // 取得公钥
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            Key publicKey = keyFactory.generatePublic(x509KeySpec);

            // 对数据解密
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, publicKey);

            return cipher.doFinal(data);
        }

        /**
         * 加密<br>
         * 用公钥加密
         *
         * @param data
         * @param key
         * @return
         * @throws Exception
         */
        public static byte[] encryptByPublicKey(byte[] data, String key)
                throws Exception {
            // 对公钥解密
            byte[] keyBytes = decryptBASE64(key);

            // 取得公钥
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            Key publicKey = keyFactory.generatePublic(x509KeySpec);

            // 对数据加密
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            return cipher.doFinal(data);
        }

        /**
         * 加密<br>
         * 用私钥加密
         *
         * @param data
         * @param key
         * @return
         * @throws Exception
         */
        public static byte[] encryptByPrivateKey(byte[] data, String key)
                throws Exception {
            // 对密钥解密
            byte[] keyBytes = decryptBASE64(key);

            // 取得私钥
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

            // 对数据加密
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);

            return cipher.doFinal(data);
        }

        /**
         * 取得私钥
         *
         * @param keyMap
         * @return
         * @throws Exception
         */
        public static String getPrivateKey(Map<String, Object> keyMap)
                throws Exception {
            Key key = (Key) keyMap.get(PRIVATE_KEY);

            return encryptBASE64(key.getEncoded());
        }

        /**
         * 取得公钥
         *
         * @param keyMap
         * @return
         * @throws Exception
         */
        public static String getPublicKey(Map<String, Object> keyMap)
                throws Exception {
            Key key = (Key) keyMap.get(PUBLIC_KEY);

            return encryptBASE64(key.getEncoded());
        }

        /**
         * 初始化密钥
         *
         * @return
         * @throws Exception
         */
        public static Map<String, Object> initKey() throws Exception {
            KeyPairGenerator keyPairGen = KeyPairGenerator
                    .getInstance(KEY_ALGORITHM);
            keyPairGen.initialize(1024);

            KeyPair keyPair = keyPairGen.generateKeyPair();

            // 公钥
            RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

            // 私钥
            RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

            Map<String, Object> keyMap = new HashMap<String, Object>(2);

            keyMap.put(PUBLIC_KEY, publicKey);
            keyMap.put(PRIVATE_KEY, privateKey);
            return keyMap;
        }
    }

