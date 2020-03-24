package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String Notification_MESSAGE = "Welcome Notification";
    private final int Notification_ID=001;
    private Button SignUp;
    private EditText EnterName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EnterName =(EditText) findViewById(R.id.EnterName);
        SignUp =(Button) findViewById(R.id.SignUp);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegistration();
            }
        });
    }

    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.Channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(Notification_MESSAGE, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }



    private void openRegistration() {
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, Notification_MESSAGE)
                .setSmallIcon(R.drawable.ic_welcome)
                .setContentTitle("Welcome!")
                .setContentText("Welcome to"+EnterName)
                .setStyle(new NotificationCompat.BigTextStyle().bigText("This is our MAD GROUP"))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);


    /*NotificationCompat.Builder builder = new NotificationCompat.Builder(this,Notification_MESSAGE);
        builder.setSmallIcon(R.drawable.ic_welcome);
        builder.setContentTitle("Welcome Notification");
        builder.setContentText("“Hello "+EnterName+"! welcome to the 'The Elite' MAD team");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);*/

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(Notification_ID, builder.build());



    }
}
