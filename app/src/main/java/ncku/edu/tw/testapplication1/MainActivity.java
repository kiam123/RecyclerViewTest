package ncku.edu.tw.testapplication1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    HobbyListAdapter hobbyListAdapter;
    RecyclerView recyclerView1;
    EditText editText1;
    ImageView hobbyAddImage;

    ExperienceListAdapter experienceListAdapter;
    RecyclerView recyclerView2;
    EditText editText2;
    ImageView experienceAddImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initHobbyView();
        addHobby();

        initExperienceView();
    }

    public void initHobbyView() {
        hobbyListAdapter = new HobbyListAdapter(this);
        editText1 = (EditText) findViewById(R.id.editText1);
        hobbyAddImage = (ImageView) findViewById(R.id.hobbyAddImage);
        recyclerView1 = (RecyclerView) findViewById(R.id.recyclerView1);

//        GridLayoutManager manager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        GridLayoutManager manager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyclerView1.setLayoutManager(manager);
        recyclerView1.setAdapter(hobbyListAdapter);

        //動態新增
        hobbyAddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editText1.getText().toString().trim().equals("")) {
                    hobbyListAdapter.addItem(new Hobby(editText1.getText().toString()));
                    editText1.setText("");
                }
            }
        });
    }

    private void addHobby() {
        //測試使用
        hobbyListAdapter.addItem(new Hobby("游泳"));
        hobbyListAdapter.addItem(new Hobby("寫程式"));
        hobbyListAdapter.addItem(new Hobby("玩遊戲"));
        hobbyListAdapter.addItem(new Hobby("跑步"));
        hobbyListAdapter.addItem(new Hobby("跳高"));
        hobbyListAdapter.addItem(new Hobby("跳水"));
    }

    public void initExperienceView() {
        experienceListAdapter = new ExperienceListAdapter(this);
        editText2 = (EditText) findViewById(R.id.editText2);
        experienceAddImage = (ImageView) findViewById(R.id.experienceAddImage);
        recyclerView2 = (RecyclerView) findViewById(R.id.recyclerView2);

        GridLayoutManager manager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyclerView2.setLayoutManager(manager);
        recyclerView2.setAdapter(experienceListAdapter);

        //動態新增
        experienceAddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editText2.getText().toString().trim().equals("")) {
                    experienceListAdapter.addItem(new Experience(editText2.getText().toString()));
                    editText2.setText("");
                }
            }
        });
    }

    //請自行完成？
    public void initMaterialView() {

    }
}
