package com.example.saravanakumar.flexboxlayout;

/**
 * Created by saravanakumar on 27/09/17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;

public class RecylerViewAdapterClass extends RecyclerView.Adapter<RecylerViewAdapterClass.ViewHolder> {
    private Context activity;
    private String[] text= new String[20];

    //boolean array to maintain the selected position
    private Boolean[] isSelect=new Boolean[20];

    public RecylerViewAdapterClass(Context activity, String[] text) {
        this.text = text;
        this.activity = activity;
        Arrays.fill(isSelect, false);
    }

    @Override
    public RecylerViewAdapterClass.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_recyclerview, viewGroup, false);
        return new RecylerViewAdapterClass.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecylerViewAdapterClass.ViewHolder viewHolder, final int position) {
        viewHolder.tvText.setText(text[position]);
        viewHolder.tvText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isSelect[position]){
                    viewHolder.tvText.setBackgroundResource(R.drawable.textview_style);   // differentiating the selected text with green color
                    isSelect[position] = false;
                }else{
                    viewHolder.tvText.setBackgroundResource(R.drawable.textview_unselect);  // displaying the unselected position with pink color
                    isSelect[position] = true;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return text == null ? 0 : text.length;
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvText;    //textview

        public ViewHolder(View itemView) {
            super(itemView);
            tvText = (TextView) itemView.findViewById(R.id.tv_text);
        }
    }
}