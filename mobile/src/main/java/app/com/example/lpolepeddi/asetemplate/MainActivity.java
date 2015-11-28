package app.com.example.lpolepeddi.asetemplate;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    /**
     * A numeric value that uniquely identifies the notification that we'll be sending.
     * If you send two notifications with the same id, the old one gets overwritten.
     * This value needs to be unique within this app, but it doesn't need to be
     * unique system-wide.
     */
    public static final int NOTIFICATION_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sendUpcomingClassNotification(View view) {
        /*
        * 1. Create an intent that will be fired when the user clicks the notification.
        * The intent needs to be packaged into a {@link android.app.PendingIntent} so that the
        * notification service can fire it on our behalf.
        */
        Uri geoUri = Uri.parse("google.navigation:q=801+Atlantic+Drive+Atlanta+GA+30332&mode=w");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, geoUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, mapIntent, 0);

        // 2. Create the wearable-specific action
        NotificationCompat.Action action = new NotificationCompat.Action.Builder(R.drawable.ic_directions, getString(R.string.directionsLabel), pendingIntent).build();

        // 3. Build the notification. We'll call methods on this to set it up
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        // 4. Set the icon that will appear in the notification bar
        builder.setSmallIcon(R.drawable.ic_stat_notification);

        // 5. Tell the notification what intent to use (the one we created earlier) when the user taps the notification.
        builder.setContentIntent(pendingIntent);

        // 6. Tell the notification to disappear after the user taps on it
        builder.setAutoCancel(true);

        // 7. Set the large icon, which appears on the left of the notification.
        // Here it's the same as the app icon
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));

        // 8. Set the text of the notification.
        builder.setContentTitle("Time to leave for CS 8803");
        builder.setContentText("Leave by 3:10 PM to arrive on time");

        // 9. Extend the notification with the action
        builder.extend(new NotificationCompat.WearableExtender().addAction(action));

        // 10. Send the notification. This will immediately display the notification icon in the bar
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    public void sendGroupInvitationNotification(View view) {

        /*
        * 1. Create an intent that will be fired when the user clicks the notification.
        * The intent needs to be packaged into a {@link android.app.PendingIntent} so that the
        * notification service can fire it on our behalf.
        */

        // TODO: This intent needs to call updateGroup(groupId) if someone joins a group; currently tapping the notification will open the Android docs
        // TODO: how to show trigger two separate intents for join v ignore?
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://developer.android.com/reference/android/app/Notification.html"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        // 2. Create the wearable-specific action
        NotificationCompat.Action joinAction = new NotificationCompat.Action.Builder(R.drawable.ic_check, getString(R.string.joinLabel), pendingIntent).build();
        NotificationCompat.Action ignoreAction = new NotificationCompat.Action.Builder(R.drawable.ic_close, getString(R.string.ignoreLabel), pendingIntent).build();


        // 3. Build the notification. We'll call methods on this to set it up
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        // 4. Set the icon that will appear in the notification bar
        builder.setSmallIcon(R.drawable.ic_stat_notification);

        // 5. Tell the notification what intent to use (the one we created earlier) when the user taps the notification.
        builder.setContentIntent(pendingIntent);

        // 6. Tell the notification to disappear after the user taps on it
        builder.setAutoCancel(true);

        // 7. Set the large icon, which appears on the left of the notification.
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));

        // 8. Set the text of the notification.
        builder.setContentTitle("New group invitation");
        builder.setContentText("Lalith Polepeddi has invited you to join their group");

        // 9. Extend the notification with the action
        builder.extend(new NotificationCompat.WearableExtender().addAction(joinAction).addAction(ignoreAction));

        // 10. Send the notification. This will immediately display the notification icon in the bar
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }
}
