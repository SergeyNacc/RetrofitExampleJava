package nacc.sergey.retrofitexamplejava;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import nacc.sergey.retrofitexamplejava.data.Hero;
import nacc.sergey.retrofitexamplejava.view.MyAdapter;
import nacc.sergey.retrofitexamplejava.viewmodel.MyViewModel;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter myAdapter;
    List<Hero> heroList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);

        MyViewModel model = ViewModelProviders.of(this).get(MyViewModel.class);

        model.getHeroes().observe(this, new Observer<List<Hero>>() {
            @Override
            public void onChanged(@Nullable List<Hero> heroList) {
                myAdapter = new MyAdapter(MainActivity.this, heroList);
                recyclerView.setAdapter(myAdapter);
            }
        });
    }
}