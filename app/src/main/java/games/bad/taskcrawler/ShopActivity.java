package games.bad.taskcrawler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import Model.Item;
import Model.ItemListAdapter;

public class ShopActivity extends AppCompatActivity {

    private static final String TAG = "ShopActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d(TAG, "OnCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Item.initializeItems(this, this.getResources());

        List<Item> items = Item.getItems(this);

        RecyclerView shopListRecyclerView = findViewById(R.id.item_recyclerview);

        ItemListAdapter shopItemListRecyclerViewAdapter = new ItemListAdapter(items, this);

        shopListRecyclerView.setAdapter(shopItemListRecyclerViewAdapter);

        shopListRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }


}
