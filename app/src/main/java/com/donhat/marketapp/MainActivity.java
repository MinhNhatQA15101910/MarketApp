package com.donhat.marketapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {
    private RecyclerView _itemsRecyclerView;
    private List<Item> _items;
    private ItemAdapter _itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        _itemsRecyclerView = findViewById(R.id.items_recycler_view);

        _items = new ArrayList<>(
                Arrays.asList(
                        new Item(R.drawable.fruit, "Fruits", "Fresh Fruits from the Garden"),
                        new Item(R.drawable.vegetables, "Vegetables", "Delicious Vegetables"),
                        new Item(R.drawable.bread, "Bakery", "Bread, Wheat and Beans"),
                        new Item(R.drawable.beverage, "Beverage", "Juice, Tea, Coffee and Soda"),
                        new Item(R.drawable.milk, "Milk", "Milk, Shakes and Yogurt"),
                        new Item(R.drawable.popcorn, "Snacks", "Popcorn, Donut and Drinks")
                )
        );

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        _itemsRecyclerView.setLayoutManager(linearLayoutManager);

        _itemAdapter = new ItemAdapter(_items);

        _itemsRecyclerView.setAdapter(_itemAdapter);

        _itemAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v, int position) {
        Toast.makeText(this, "You choose: " + _items.get(position).getTitle(), Toast.LENGTH_SHORT).show();
    }
}