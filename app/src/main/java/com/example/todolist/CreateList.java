package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateList extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* Setting variables for items created in the activity_main.xml */

    private EditText itemET;
    private Button btn;
    private ListView itemsList;

    /* Creating empty array to hold items */

    private ArrayList<String> items;

    /* Creating Array adapter */

    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Setting references that were created and setting them to variables */

        itemET = findViewById(R.id.item_edit_text);
        btn = findViewById(R.id.add_btn);
        itemsList = findViewById(R.id.items_list);

        /*
        Adding the items and Array created in FileHelper.java
         */

        items = FileHelper.readData(this);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        itemsList.setAdapter(adapter);

        /* Setting onClickListener for the button */

        btn.setOnClickListener(this);

        /*
        We need to be able to delete items from the list.
         */

        itemsList.setOnItemClickListener(this);

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        /*
        Creating code that pulls what is typed in the text edit
         and saves it to the Array list / items list
        */
        switch (v.getId()) {
            case R.id.add_btn:
                String itemEntered = itemET.getText().toString();
                adapter.add(itemEntered);
                itemET.setText("");

                /*
                Need to write the data, so that when the button is pressed,
                the data is saved to file
                 */

                FileHelper.writeData(items, this);

                /*
                Toast creates a pop- up that notifies the user that the item has been added
                 */

                Toast.makeText(this, "Item Added", Toast.LENGTH_SHORT).show();

                break;
        }


    }

    /**
     * Callback method to be invoked when an item in this AdapterView has
     * been clicked.
     * <p>
     * Implementers can call getItemAtPosition(position) if they need
     * to access the data associated with the selected item.
     *
     * @param parent   The AdapterView where the click happened.
     * @param view     The view within the AdapterView that was clicked (this
     *                 will be a view provided by the adapter)
     * @param position The position of the view in the adapter.
     * @param id       The row id of the item that was clicked.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        /*
        position refers to position in the list
        */

        items.remove(position);

        /*
        Update the adapter
        */

        adapter.notifyDataSetChanged();
        FileHelper.writeData(items, this);

         /*

         Toast creates a pop- up that notifies the user that the item has been added

         */

        Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();

    }
}
