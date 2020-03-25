package com.jk.dealo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String mTitle[] = {"Iphone4s", "Iphone5s", "Iphone6s", "Iphone7s", "Iphone8s"};
    String mDescription[] = {"Iphone4s Description", "Iphone5s Description", "Iphone6s Description", "Iphone7s Description", "Iphone8s Description"};
    ArrayAdapter<String> adapter;//search adapter
    int mImages[] = {R.drawable.ip, R.drawable.ip, R.drawable.ip, R.drawable.ip, R.drawable.ip,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        //search adapter
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,mTitle);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,mDescription);
        listView.setAdapter(adapter);

        MyAdapter adapter = new MyAdapter( this, mTitle , mDescription , mImages);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position== 0){
                    Intent intent = new Intent(getApplicationContext(),secondActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putInt("image", mImages[0]);
                    intent.putExtras(bundle);
                    intent.putExtra("title",mTitle[0]);
                    intent.putExtra("description", mDescription[0]);
                    intent.putExtra("position",""+0);
                    startActivity(intent);

                }

                if (position== 1){
                    Intent intent = new Intent(getApplicationContext(),secondActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putInt("image", mImages[1]);
                    intent.putExtras(bundle);
                    intent.putExtra("title",mTitle[1]);
                    intent.putExtra("description", mDescription[1]);
                    intent.putExtra("position",""+1);
                    startActivity(intent);

                }
                if (position== 2){
                    Intent intent = new Intent(getApplicationContext(),secondActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putInt("image", mImages[2]);
                    intent.putExtras(bundle);
                    intent.putExtra("title",mTitle[2]);
                    intent.putExtra("description", mDescription[2]);
                    intent.putExtra("position",""+2);
                    startActivity(intent);

                }
                if (position== 3){
                    Intent intent = new Intent(getApplicationContext(),secondActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putInt("image", mImages[3]);
                    intent.putExtras(bundle);
                    intent.putExtra("title",mTitle[3]);
                    intent.putExtra("description", mDescription[3]);
                    intent.putExtra("position",""+3);
                    startActivity(intent);

                }
                if (position== 4){
                    Intent intent = new Intent(getApplicationContext(),secondActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putInt("image", mImages[4]);
                    intent.putExtras(bundle);
                    intent.putExtra("title",mTitle[4]);
                    intent.putExtra("description", mDescription[4]);
                    intent.putExtra("position",""+4);
                    startActivity(intent);

                }
            }
        });
    }
   //search bar view//
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_search_view,menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)menuItem.getActionView();
        searchView.setQueryHint("Type here to search");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String mTitle[];
        String mDescription[];
        int mimages[];

        MyAdapter(Context c, String[] title, String[] description, int[] i) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.mTitle = title;
            this.mDescription = description;
            this.mimages = mImages;

        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row  = layoutInflater.inflate(R.layout.row,parent,false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            myTitle.setText(mTitle[position]);
            myDescription.setText(mDescription[position]);
            images.setImageResource(mimages[position]);

            return row;
        }
    }
    }