package app.com.example.lpolepeddi.asetemplate;


import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WearableListView;
import android.widget.Toast;

public class MainActivity extends Activity implements WearableListView.ClickListener {
    // Sample dataset for the list

    GroupMember[] g1 = new GroupMember[] {
            new GroupMember("Harshit Sharma", 33.777187, -84.397421, 1448582400),
            new GroupMember("Mayank Gupta", 33.77653,-84.388336, 1448582400),
            new GroupMember("Chris Ernst", 33.775493,-84.397343, 1448582400)
    };
    GroupMember[] g2 = new GroupMember[] {
            new GroupMember("Person 1", 33.778723,-84.398507, 1448582400),
            new GroupMember("Person 2", 33.777185, -84.397419, 1448582400),
            new GroupMember("Person 3", 33.777181, -84.397417, 1448582400),
            new GroupMember("Person 4", 33.777179, -84.397415, 1448582400)
    };
    Group[] groupData = new Group[] {
            new Group("Group 1", 1448582400, g1),
            new Group("Group 2", 1448582400, g2),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the list component from the layout of the activity
        WearableListView listView = (WearableListView) findViewById(R.id.wearable_list);

        // Assign an adapter to the list
        listView.setAdapter(new ListAdapter(this, groupData));

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