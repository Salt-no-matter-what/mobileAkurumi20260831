package jp.ac.meijou.android.s241205141;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import jp.ac.meijou.android.s241205141.databinding.ActivityMain2Binding;
import jp.ac.meijou.android.s241205141.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {

    private ActivityMain3Binding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //intent取得
        Intent intent = getIntent();
        String sentText = intent.getStringExtra("editText");
        binding.cal.setText(sentText);

        //okボタン
        binding.buttonOk.setOnClickListener(viwe -> {
            var ok_intent = new Intent();
            ok_intent.putExtra("ret", "OK");
            setResult(RESULT_OK,ok_intent);
            finish();
        });

        //cancelボタン
        binding.buttonCancel.setOnClickListener(view -> {
            setResult(RESULT_CANCELED);
            finish();
        });


        //電卓用code
        binding.text0.setOnClickListener(view -> {

        });
    }
}