package games.bad.taskcrawler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import Model.Icon;
import Adapters.IconSelectListAdapter;

public class IconSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon_select);

        //enable the back button in the action bar.
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        //get all icons from the database
        List<Icon> icons = Icon.getAllPurchasedEnemyIcons(this);

        //fill the recyclerview with the items! using the default itemListAdapter.
        RecyclerView iconRecyclerView = findViewById(R.id.iconRecyclerView);
        IconSelectListAdapter iconSelectListAdapter = new IconSelectListAdapter(icons, this);
        iconRecyclerView.setAdapter(iconSelectListAdapter);
        iconRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
