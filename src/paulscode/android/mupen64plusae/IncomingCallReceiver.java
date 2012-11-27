package paulscode.android.mupen64plusae;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;

public class IncomingCallReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
                Bundle bundle = intent.getExtras();
               
                if(null == bundle)
                        return; 
               
                String state = bundle.getString(TelephonyManager.EXTRA_STATE);
               
                if(state.equals(TelephonyManager.EXTRA_STATE_RINGING))
                {
					GameActivityCommon.saveSession();  // Workaround, allows us to force-close later
                }
        }

}


