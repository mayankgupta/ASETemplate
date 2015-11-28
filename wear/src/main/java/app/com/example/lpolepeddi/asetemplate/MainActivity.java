package app.com.example.lpolepeddi.asetemplate;


import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WearableListView;
import android.widget.Toast;

public class MainActivity extends Activity implements WearableListView.ClickListener {
    // Sample dataset for the list
    String[] elements = {
            "Group 1",
            "Group 2",
            "Group 3",
            "Group 4"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the list component from the layout of the activity
        WearableListView listView = (WearableListView) findViewById(R.id.wearable_list);

        // Assign an adapter to the list
        listView.setAdapter(new ListAdapter(this, elements));

        // Set a click listener
        listView.setClickListener(this);
    }

    // WearableListView click listener
    @Override
    public void onClick(WearableListView.ViewHolder v) {
        Integer tag = (Integer) v.itemView.getTag();

        // temp
        Toast.makeText(this, "Clicked item", Toast.LENGTH_SHORT).show();

        // use this data to complete some action ...
    }

    @Override
    public void onTopEmptyRegionClick() {
    }
}