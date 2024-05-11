package develop.differexemples.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShareAppActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    // Метод для отправки ссылки на приложение
    public void shareApp(View view) {
        String appPackageName = getPackageName(); // Получаем имя пакета текущего приложения
        String shareUrl = "https://play.google.com/store/apps/details?id=" + appPackageName;

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Попробуйте наше приложение: " + shareUrl);
        startActivity(Intent.createChooser(shareIntent, "Поделиться приложением"));
    }


    // Email приглашения:
    // Позвольте пользователям отправлять приглашения через электронную почту, что также дает возможность персонализировать сообщения.
    public void sendEmailInvite(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("message/rfc822");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Попробуйте это приложение");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Я хочу порекомендовать это приложение...");
        startActivity(Intent.createChooser(emailIntent, "Отправить приглашение по Email"));
    }

}
