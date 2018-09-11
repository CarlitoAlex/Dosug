package com.example.artemtkachevi.dosugapp;

import android.app.Activity;
import android.app.assist.AssistStructure;
import android.content.ClipData;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
  static class Item {
       public Item(String word) {
           this.word = word;
       }

       String word;
   }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final EditText word =findViewById(R.id.word);
        final Button add = findViewById(R.id.add);
        final ListView items = findViewById(R.id.items);
        final ItemsAdapter adapter = new ItemsAdapter();

        items.setAdapter(adapter);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.add(new Item(word.getText().toString()));
            }
        });

    }
    private class ItemsAdapter extends ArrayAdapter<Item> {
        ItemsAdapter() {
            super(MainActivity.this, R.layout.item);
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            final View view = getLayoutInflater().inflate(R.layout.item, null);
            final Item item = getItem(position);
            ((TextView) view.findViewById(R.id.word)).setText(item.word);
            return view;
        }
    }
}
