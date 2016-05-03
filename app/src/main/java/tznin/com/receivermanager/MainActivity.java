package tznin.com.receivermanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {



    @Bind(R.id.name)
    EditText name;
    @Bind(R.id.password)
    EditText password;
    @Bind(R.id.sendserver)
    EditText sendserver;
    @Bind(R.id.port)
    EditText port;
    @Bind(R.id.rmail)
    EditText rmail;
    @Bind(R.id.mima)
    EditText mima;
    @Bind(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        //建立Intent对象
//        Intent intent = new Intent();
//        //设置对象动作
//        intent.setAction(Intent.ACTION_SEND);
//        //设置对方邮件地址
//        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{ "alert8@qq.com","alert8@qq.com" });
//        //设置标题内容
//        intent.putExtra(Intent.EXTRA_SUBJECT, "test");
//        //设置邮件文本内容
//        intent.putExtra(Intent.EXTRA_TEXT, "test mail");
//      //  启动一个新的ACTIVITY,"Sending mail..."是在启动这个
//        // ACTIVITY的等待时间时所显示的文字
//        startActivity(Intent.createChooser(intent, "Sending .mail...") );
        // SendMessage.create("fff","111");




       Info info =   Storage.getUserInfo();

        if(info != null) {

            name.setText(info.getName() );
            password.setText(info.getPassword() );
            sendserver.setText(info.getSendServer() );
            port.setText(info.getPort() );
            rmail.setText(info.getRmail() );
            mima.setText(info.getKey() );
        }

//            @Bind(R.id.name)
//            EditText name;
//            @Bind(R.id.password)
//            EditText password;
//            @Bind(R.id.sendserver)
//            EditText sendserver;
//            @Bind(R.id.port)
//            EditText port;
//            @Bind(R.id.rmail)
//            EditText rmail;
//            @Bind(R.id.mima)
//            EditText mima;



    }

    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    @OnClick(R.id.button)
    public void onClick() {

        try {




            //   Map<String, Object> key =  RSA.initKey();
            String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC7ngibX7hBGf+tXi+Pa/FzwCbFwetrH2Mlu3XJ+s8xJ41EXNK98nyLDoEMXE5ZhiYyt9ypKwTtIBNGmh9+fpjmHfIUqbYaHyyuGIPK7wRBfIwgy2zT5MuFZbsGmRjSXaZRjhluNsYi8wVLQdt8Wgjv/W8ZbnsV0Ccp0keh5LRXYwIDAQAB";//RSA.getPublicKey(key);
            String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALueCJtfuEEZ/61eL49r8XPAJsXB62sfYyW7dcn6zzEnjURc0r3yfIsOgQxcTlmGJjK33KkrBO0gE0aaH35+mOYd8hSpthofLK4Yg8rvBEF8jCDLbNPky4VluwaZGNJdplGOGW42xiLzBUtB23xaCO/9bxluexXQJynSR6HktFdjAgMBAAECgYB+UGClEuW/VtyvgTjuC5ONBbJU9EEmZwRek/4ylRzHkERo4UG1RruY95PkmYTaexnejbEPZ/oyF6VCpGNNy7fuFl7/gKE92ubouTYOgFHcchM9jj09lBVoqAVB8bb/EY9odVFgXIVulsMzXw386GYOtGAxc97niHSFRVvYqP9VsQJBAOiDFr8VLmXWDB7Fh3L90BtAyQfgqnylt0xdfqevujb5cNsqqv7LVq8BEe+Jj/l+QwpvNjqJ2OIrZIUj7iv7cOkCQQDOkfAUvCQK9LuJzqZn33MCwkp/bwOEpCTyOFLAMtjlFNNZqKjJGAEdWP7gfT2zc7L/hs6uVSmxq/jbt1mrkzZrAkAZpLuRf4iKer0Dd82khRG6r758O+8RqEU7CuS5Icxr277yrRYG2+5HhtqvjIBwh9hlAjb85c8hwp9nf7r45tZhAkEAge4deo1UhmelRmrrFE7iQov+2+Tx645rhseSlT3mW0EcJzsE32fv24vM1VsxYhyWLE+Y1OLQVOb8owbSqi7wfQJBAMtYJcQ9sETSw2jqbNhdq3B0r5+3ADg3gPUgc2TD2AEG53iYuQFs3jw8B+AelleRoncKXWss5cMw2QroLpgZF9E=";//RSA.getPrivateKey(key);




//            @Bind(R.id.name)
//            EditText name;
//            @Bind(R.id.password)
//            EditText password;
//            @Bind(R.id.sendserver)
//            EditText sendserver;
//            @Bind(R.id.port)
//            EditText port;
//            @Bind(R.id.rmail)
//            EditText rmail;
//            @Bind(R.id.mima)
//            EditText mima;
//            @Bind(R.id.button)
//            Button button;



            Info info = new Info();
            info.setName(name.getText().toString().trim() );
            info.setPassword(password.getText().toString().trim() );
            info.setSendServer(sendserver.getText().toString().trim() );
            info.setPort(port.getText().toString().trim() );
            info.setRmail(rmail.getText().toString().trim() );
            info.setKey(mima.getText().toString().trim() );

            Storage.setUserInfo(info);

            //   Log.d("key",publicKey);
            //   Log.d("key",privateKey);

            // String userData = editText.getText().toString();

            // byte[] encodeData = RSA.encryptByPublicKey(userData.getBytes(), publicKey);

            //   String data =    Base64.encodeToString(encodeData,Base64.DEFAULT);
            //   String encodeStr = new BigInteger(1, encodeData).toString(16);
            //   String data = new String(encodeData);
            //  editText.setText(data);

//            String data = replaceBlank(editText.getText().toString());
////            String r =  DES.decryptDES(data ,SendMessage.KEY);
////            editText4.setText(r);
//
//
//            byte[] decodeData = RSA.decryptByPrivateKey(Base64.decode(data, Base64.DEFAULT), privateKey);
//            String decodeStr = new String(decodeData);
//            editText4.setText(decodeStr);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
