package jp.ac.meijou.android.s241205141;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import jp.ac.meijou.android.s241205141.databinding.ActivityMainBinding;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private PrefDataStore prefDataStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        prefDataStore = PrefDataStore.getInstance(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //prefDataStore.getString("name")
        //        .ifPresent(name -> binding.kurumi.setText(name));


        //　データの読み込み
        prefDataStore.getString("name")
                .ifPresent(name -> {
            if ("a".equals((name))) {
                binding.kurumi.setText("Aの画像");
                binding.imageView.setImageResource(R.drawable.outline_air_freshener_24);
            } else if ("b".equals((name))) {
                binding.kurumi.setText("Bの画像");
                binding.imageView.setImageResource(R.drawable.outline_adb_24);
            }else{
                binding.kurumi.setText("知らない画像");
            }
        });

        //binding.kurumi.setText(R.string.text);
        //binding.imageView.setImageResource(R.drawable.outline_adb_24);
        binding.change.setOnClickListener(view ->{
            var text = binding.editTextText.getText().toString();
            binding.kurumi.setText(text);
        });

        // データの保存
        binding.save.setOnClickListener(view ->{
            var text = binding.editTextText.getText().toString();
            prefDataStore.setString("name",text);
        });

        binding.editTextText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                //　テキストが更新された後に呼ばれる
                //var text = editable.toString();
                //binding.kurumi.setText(text);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });


    }
}