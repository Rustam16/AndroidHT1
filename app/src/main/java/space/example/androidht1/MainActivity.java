package space.example.androidht1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button buttonApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        buttonApplication = findViewById(R.id.btnApplication);

        EditText editText = findViewById(R.id.editText);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND){
                    handled =true;
                }
                return handled;
            }
        });

        buttonApplication.setOnClickListener(v -> {
           String query = editText.getText().toString();
           Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
           intent.putExtra("query",query);
           startActivity(intent);
        });
    }
}
