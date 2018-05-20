package b12app.vyom.com.simplejunittestexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    private Button btnChange;
    private EditText etInputText;
    private TextView tvOutputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        btnChange = findViewById(R.id.btnChange);
        etInputText = findViewById(R.id.etInputText);
        tvOutputText = findViewById(R.id.tvOutput);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOutputText.setText(etInputText.getText().toString());
            }
        });
    }
}
