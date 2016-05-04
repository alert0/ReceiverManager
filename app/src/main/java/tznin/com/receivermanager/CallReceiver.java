package tznin.com.receivermanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.util.Date;

/**
 * Created by PC on 2016/4/29.
 */
public class CallReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        Log.i("CallReceiver", "CallReceiver Start...");

        TelephonyManager   telephonyManager= (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
       // final  WifiManager mWifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        PhoneStateListener listener=new PhoneStateListener(){
            @Override
            public void onCallStateChanged(int state, String incomingNumber) {
                super.onCallStateChanged(state, incomingNumber);
                switch (state){
                    case  TelephonyManager.CALL_STATE_IDLE:
                        //无任何状态
                        break;
                    case  TelephonyManager.CALL_STATE_OFFHOOK:
                        //挂机
//                        recorder.stop();
//                        recorder.release();
//                        recorder.reset();
                        break;
                    case TelephonyManager.CALL_STATE_RINGING:

                     //   Log.i("111",incomingNumber+"：来电");

//                        if(!App.isConnetNet()) {
//                            mWifiManager.setWifiEnabled(true);
//
//                        }

                        SendMessage.create("电话："+incomingNumber,incomingNumber+ "\r\n----"+ new Date() );

                        //响铃
//                        try {
//                            Log.i("111",incomingNumber+"：来电");
// recorder.prepare();
//                            recorder.start();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
                        break;
                }
            }
        };
        telephonyManager.listen(listener,PhoneStateListener.LISTEN_CALL_STATE);

    }
}