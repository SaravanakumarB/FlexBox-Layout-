package com.example.saravanakumar.flexboxlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    // Array list - interest list
    private String[]  text = {
            "Arts",
            "Articles",
            "Advertisement",
            "Movie",
            "Films",
            "Books",
            "Youtube",
            "Facebook",
            "Entertainment",
            "Games",
            "News",
            "Tv Show",
            "Social media",
            "Climate",
            "Accidents",
            "Videos",
            "Cars",
            "Cartoons",
            "Wrestling",
            "Sports"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recycler to assign the interests in flexbox layout
        recyclerView = (RecyclerView) findViewById(R.id.rl_text);

        // Flexbox layout Manager handles flex box layout with recylerview
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(this);

        //we have arrange the flexbox layout as row,column,row reverse and column reverse.
        // Here i am using row order
        layoutManager.setFlexDirection(FlexDirection.ROW);

        //It is content arrangement
        //5 types - CENTER, FLEX_START, FlEX_END, SPACE_AROUND and SPACE_BETWEEN
        //CENTER - Will display content in center with equal space on both end
        //FlEX_START - display the content from left most
        //FLEX_END - display the content from right most
        //SPACE_AROUND - gives equal amount of space around the content
        //SPACE_BETWEEN - gives eual amount only between the content
        layoutManager.setJustifyContent(JustifyContent.SPACE_AROUND);

        //Content in flex box layout Alignment
        //CENTER , FLEX_START, BASE_LINE, STRETCH and FLEX_END
        layoutManager.setAlignItems(AlignItems.CENTER);

        // setting layout manager for recycler view
        recyclerView.setLayoutManager(layoutManager);

        // initialisng the recycler view adapter
        RecylerViewAdapterClass recylerViewAdapterClass = new RecylerViewAdapterClass(this,text);
        recyclerView.setAdapter(recylerViewAdapterClass);

        // notifyDataSetChanged() - to refresh the adapter
        recylerViewAdapterClass.notifyDataSetChanged();
    }
}
