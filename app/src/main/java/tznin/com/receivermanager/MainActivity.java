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


    @Bind(R.id.editText)
    EditText editText;
    @Bind(R.id.editText4)
    EditText editText4;
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
    }

    public static String replaceBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    @OnClick(R.id.button)
    public void onClick()  {

    try{

       //   Map<String, Object> key =  RSA.initKey();
       //   String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC7ngibX7hBGf+tXi+Pa/FzwCbFwetrH2Mlu3XJ+s8xJ41EXNK98nyLDoEMXE5ZhiYyt9ypKwTtIBNGmh9+fpjmHfIUqbYaHyyuGIPK7wRBfIwgy2zT5MuFZbsGmRjSXaZRjhluNsYi8wVLQdt8Wgjv/W8ZbnsV0Ccp0keh5LRXYwIDAQAB";//RSA.getPublicKey(key);


         //   Log.d("key",publicKey);
         //   Log.d("key",privateKey);

           // String userData = editText.getText().toString();

           // byte[] encodeData = RSA.encryptByPublicKey(userData.getBytes(), publicKey);

          //   String data =    Base64.encodeToString(encodeData,Base64.DEFAULT);
            //   String encodeStr = new BigInteger(1, encodeData).toString(16);
     //   String data = new String(encodeData);
          //  editText.setText(data);

            String data = replaceBlank(editText.getText().toString());
//            String r =  DES.decryptDES(data ,SendMessage.KEY);
//            editText4.setText(r);


            byte[] decodeData = RSA.decryptByPrivateKey(Base64.decode(data,Base64.DEFAULT),privateKey);
            String decodeStr = new String(decodeData);
            editText4.setText(decodeStr);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
