package tznin.com.receivermanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Administrator on 2015/10/9.
 *
 * 开机启动
 */
public class BoothReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("android.intent.action.BOOT_COMPLETED")){
            Log.i("111", "开机启动...");
          //  Toast.makeText(context,"我启动了....",Toast.LENGTH_SHORT).show();
//            Intent call=new Intent(context, CallService.class);
//            context.startService(call);
        }else if(intent.getAction().equals("android.intent.action.ACTION_SHUTDOWN")){
            Toast.makeText(context,"关机....",Toast.LENGTH_SHORT).show();
          //  Log.i("111","关机...");
        }


    }
}
