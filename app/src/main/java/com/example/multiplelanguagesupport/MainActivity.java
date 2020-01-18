package com.example.multiplelanguagesupport;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    // these two variables will be used by SharedPreferences

    private static final String FILE_NAME = "file_lang"; // preference file name
    private static final String KEY_LANG = "key_lang"; // preference key

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // please load language after super and before setContentView


        setContentView(R.layout.activity_main);

        TextView indicatorText = findViewById(R.id.language_indicator);
        TextView Name = findViewById(R.id.txtName);
        TextView Phone = findViewById(R.id.txtPhone);
        TextView Address = findViewById(R.id.txtAddress);
        TextView Feedback = findViewById(R.id.txtFeedBack);

        EditText name = findViewById(R.id.edtName);
        EditText phone = findViewById(R.id.edtPhone);
        EditText address = findViewById(R.id.edtAddress);
        EditText feedback = findViewById(R.id.edtFeedBack);

        Button NextBtn = findViewById(R.id.btnNext);

        // to display text language after selecting language

        if (getLangCode().contentEquals("en")) {

            indicatorText.setText("English");

            Name.setText("Name" );
            Phone.setText("Phone");
             Address.setText("Address");
             Feedback.setText("FeedBack");

             name.setHint("Name");
             phone.setHint("Phone");
             address.setHint("Address");
             feedback.setHint("FeedBack");

             NextBtn.setText("Next");

        }
        else if (getLangCode().contentEquals("zh")) {

            indicatorText.setText("Chinese");

            Name.setText("名称");
            Phone.setText("电话");
            Address.setText("地址");
            Feedback.setText("反馈");

            name.setHint("名称");
            phone.setHint("电话");
            address.setHint("地址");
            feedback.setHint("反馈");

            NextBtn.setText("下一个");

        }
        else if (getLangCode().contentEquals("hi")) {


            indicatorText.setText("Hindi");

            Name.setText( "नाम");
            Phone.setText( "फ़ोन");
            Address.setText("पता");
            Feedback.setText("प्रतिपुष्टि");

            name.setHint("नाम");
            phone.setHint("फ़ोन");
            address.setHint("पता");
            feedback.setHint("प्रतिपुष्टि");

            NextBtn.setText("आगे");
        }
        else if (getLangCode().contentEquals("sw")) {
            // default

            indicatorText.setText("Swahili");

            Name.setText("Jina");
            Phone.setText("Simu");
            Address.setText("Anwani");
            Feedback.setText("FeedBack");

            name.setHint("Jina");
            phone.setHint("Simu");
            address.setHint("Anwani");
            feedback.setHint("FeedBack");

            NextBtn.setText("Ifuatayo");

        }
    }
    private void saveLanguage(String lang) {

        // we can use this method to save language
        // When we restart the app it will load the same recent language as it was on before app closing

        SharedPreferences preferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_LANG, lang);
        editor.apply();

        // we have saved
        // recreate activity after saving to load the new language, this is the same
        // as refreshing activity to load new language

        recreate();

    }

    private String getLangCode() {

        SharedPreferences preferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        String langCode = preferences.getString(KEY_LANG, "en");

        // save english 'en' as the default language

        return langCode;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    // for menu to displaying option of selected lang
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_english:

                saveLanguage("en");
                break;

            case R.id.action_chinese:
                saveLanguage("zh");
                break;

            case R.id.action_hindi:
                saveLanguage("hi");
                break;

            case R.id.action_swahili:
                saveLanguage("sw");
                break;
        }
        return true;
    }
}