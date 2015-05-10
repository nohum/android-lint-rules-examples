package at.fhj.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class FailingReceiver extends BroadcastReceiver {

    private static final String INTENT_ACTION = "at.fhj.demo.START_FAILING_RECEIVER";

    public FailingReceiver() {
    }

    public static void notify(Context context) {
        Intent intent = new Intent(context, FailingReceiver.class);
        intent.setAction(INTENT_ACTION);

        context.sendBroadcast(intent);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent startReceiverActivity = new Intent(context, ReceiverActivity.class);

        // this error is detected by lint rule ReceiverStartActivityFlagsMissing
        context.startActivity(startReceiverActivity);
    }
}
