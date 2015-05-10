package at.fhj.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class WorkingReceiver extends BroadcastReceiver {

    private static final String INTENT_ACTION = "at.fhj.demo.START_WORKING_RECEIVER";

    public WorkingReceiver() {
    }

    public static void notify(Context context) {
        Intent intent = new Intent(context, WorkingReceiver.class);
        intent.setAction(INTENT_ACTION);

        context.sendBroadcast(intent);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent startReceiverActivity = new Intent(context, ReceiverActivity.class);

        // this is correct and works
        startReceiverActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(startReceiverActivity);
    }

    public void neverCalled(Context context) {
        // this is wrong but is actually never called, thus a correct warning. nevertheless, still a false positive
        context.startActivity(new Intent(context, ReceiverActivity.class));
    }
}
