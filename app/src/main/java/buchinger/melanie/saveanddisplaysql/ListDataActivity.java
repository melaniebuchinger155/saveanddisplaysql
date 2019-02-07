package buchinger.melanie.saveanddisplaysql;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class ListDataActivity extends AppCompatActivity {

   private static final String TAG = "ListDataActivity";
   DatabaseHelper mDatabasehelper;
   private ListView mListView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.list_layout );
        mListView = (ListView) findViewById( R.id.listView );
        mDatabasehelper = new DatabaseHelper( this );

        populateListView();
    }

    private void populateListView() {
        Log.d(TAG, "populateListView: Displaying data in the ListView.");

        //get the data and append to a list
        Cursor data = mDatabasehelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext()) {
            //get the value from the database in column 1
            // them add it to the ArrayList
            listData.add( data.getString( 1 ) );

        }
        //create the listadapter and set the adapter
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter( adapter );

    }

    /**
     * customaziable toast
     * @param message
     */

    private void toastMessage(String message) {
        Toast.makeText( this,message, Toast.LENGTH_SHORT ).show();
    }

}
