package com.example.recycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Fruit> fruits = new ArrayList<Fruit>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // начальная инициализация списка
        setInitialData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        // создаем адаптер
        FruitAdapter.OnStateClickListener stateClickListener = new FruitAdapter.OnStateClickListener() {
            @Override
            public void onStateClick(Fruit fruit, int position) {

                Toast.makeText(getApplicationContext(), "Выбран элемент — " + fruit.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        };
        FruitAdapter adapter = new FruitAdapter(this, fruits, stateClickListener);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
    }
    private void setInitialData(){
        fruits.add(new Fruit ("Лимон", "Желтый весь", R.drawable.lemon));
        fruits.add(new Fruit ("Киви", "Зеленый внутри", R.drawable.kiwi));
        fruits.add(new Fruit ("Яблоко", "Красный снаружи", R.drawable.apple));
        fruits.add(new Fruit ("Ананас", "Желтый внутри", R.drawable.pineapple));
    }



}