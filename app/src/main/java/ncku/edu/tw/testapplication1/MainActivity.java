package ncku.edu.tw.testapplication1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListAdapter listAdapter = new ListAdapter(this);
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
    }
}
