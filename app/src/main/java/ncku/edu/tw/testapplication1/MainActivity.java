package ncku.edu.tw.testapplication1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    EditText editText1;
    ImageView imageView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListAdapter listAdapter = new ListAdapter(this);
        editText1 = (EditText) findViewById(R.id.editText);
        imageView1 = (ImageView) findViewById(R.id.imageView);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

//        GridLayoutManager manager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        GridLayoutManager manager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(listAdapter);

        listAdapter.addItem(new Hobby("游泳"));
        listAdapter.addItem(new Hobby("寫程式"));
        listAdapter.addItem(new Hobby("玩遊戲"));
        listAdapter.addItem(new Hobby("跑步"));
        listAdapter.addItem(new Hobby("跳高"));
        listAdapter.addItem(new Hobby("跳水"));


        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listAdapter.addItem(new Hobby(editText1.getText().toString()));
                editText1.setText("");
            }
        });
    }
}
