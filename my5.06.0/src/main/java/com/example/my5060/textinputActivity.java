package com.example.my5060;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class textinputActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textinput);
        final TextInputLayout textInputLayout = (TextInputLayout) findViewById(R.id.textinput);
        EditText editText = textInputLayout.getEditText();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if (s.length()>10) {
                    textInputLayout.setErrorEnabled(true);
                    textInputLayout.setError("请不要超过10个字");
                }else{
                    textInputLayout.setErrorEnabled(false);
                    textInputLayout.setError("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Snackbar make = Snackbar.make(fab, "我是 被点击出来的", Snackbar.LENGTH_SHORT);
            make.setAction("哈哈哈哈", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(textinputActivity.this,"我是点击出来的 ", Toast.LENGTH_SHORT).show();
                }
            });
            make.show();
        }
    });

    }

}
