package nefersky.catmanualapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private String head_array[] = {
            "00. Начало.",
            "01. Чем кормить кота.",
            "02. Как гладить кота.",
            "03. Как спит кот.",
            "04. Как играть с котом.",
            "05. Как разговаривать с котом.",
            "06. Интересные факты из жизни котов.",
            "07. Как назвать кота."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.listView);
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, head_array);
        listView.setAdapter(arrayAdapter);
        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, DetailActivity.class);
                intent.putExtra("head", position);
                startActivity(intent);
            }
        });
    }
}
