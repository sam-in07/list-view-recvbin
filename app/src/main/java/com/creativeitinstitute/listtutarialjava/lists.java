package com.creativeitinstitute.listtutarialjava;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText edt;
    Button btn;
    ArrayList<String> fruits = new ArrayList<>();
 /*

 ListViewActivity extends AppCompatActivity, creating an activity that uses a ListView.
 It also declares the variables for
 ListView, EditText, Button, and an ArrayList to hold the fruit names.
  */
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
        listView =findViewById(R.id.list);
        edt = findViewById(R.id.edit);
        btn = findViewById(R.id.btn);


        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Apple");
        fruits.add("Jackfruit");
        /*
        Here, the XML components (ListView, EditText, Button) are linked to
         their corresponding views i
        n the layout file. It also initializes the ArrayList with some fruits.
         */
        ArrayAdapter<String> fruitadapter = new
                //An ArrayAdapter is created to manage the data (fruits) and connect it to the ListView.
                ArrayAdapter<>(this, android.R.layout.simple_list_item_1,fruits);
        listView.setAdapter(fruitadapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "This is item: "+i, Toast.LENGTH_SHORT).show();
                //This sets an item click listener for the ListView. When an item is clicked, a Toast message is shown displaying the item's position.
       /*
      oast.makeText(...): This is the static method used to create a new Toast object. It takes three arguments:
ListViewActivity.this: This refers to the current context of the activity where the toast is being displayed. It's likely that this code is inside an activity named ListViewActivity.
"This is item: " + i: This is the message that will be displayed in the toast. It's a string that includes the value of a variable i, probably representing an item index.
Toast.LENGTH_SHORT: This sets the duration of the toast to be short.
.show(): This method is called on the Toast object to actually display it on the screen.
        */
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edt.getText().toString();
                fruits.add(text);
                fruitadapter.notifyDataSetChanged();
                /*
                This sets a click listener for the button. When the button is clicked,
                it gets the text from the EditText,
                 adds it to the fruits list, and notifies the adapter to update the ListView.
                 */
            }
        });
    }
}
