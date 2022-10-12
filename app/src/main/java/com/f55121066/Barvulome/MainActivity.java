package com.f55121066.Barvulome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtwidth;
    private EditText edtheight;
    private EditText edtlength;
    private Button btnCalculate;
    private TextView tvresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtwidth = findViewById(R.id.edt_width);
        edtheight = findViewById(R.id.edt_height);
        edtlength = findViewById(R.id.edt_length);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvresult = findViewById(R.id.tv_result);

        btnCalculate.setOnClickListener(this);

        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            tvresult.setText(result);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_calculate) {
            String inputlength =
                    edtlength.getText().toString().trim();
            String inputwidth =
                    edtwidth.getText().toString().trim();
            String inputheight =
                    edtheight.getText().toString().trim();

            boolean isEmptyFields = false;

            if (TextUtils.isEmpty(inputlength)) {
                isEmptyFields = true;
                edtlength.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputwidth)) {
                isEmptyFields = true;
                edtwidth.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputheight)) {
                isEmptyFields = true;
                edtheight.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields) {
                Double volume = Double.parseDouble(inputlength) *
                        Double.parseDouble(inputwidth) * Double.parseDouble(inputheight);
                tvresult.setText(String.valueOf(volume));
            }
        }
    }

    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvresult.getText().toString());
    }
}