package com.bluecodesystems.health.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bluecodesystems.health.R;
import com.bluecodesystems.health.models.Children;


import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class DBAdapter2 extends RecyclerView.Adapter<DBAdapter2.ViewHolder> {

    Context context;

    List<Children> children;

    private static final String TAG = "DBAdapter2";

    public DBAdapter2(List<Children> children, Context context){

        super();

        this.children = children;
        this.context = context;
    }

    @Override
    public DBAdapter2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_child, parent, false);

        DBAdapter2.ViewHolder viewHolder = new DBAdapter2.ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DBAdapter2.ViewHolder holder, final int position) {

        final Children ch = children.get(position);

        holder.textName.setText(ch.getChildname());


        holder.lview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }

        });

    }

    @Override
    public int getItemCount() {

        return children.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textName;
        LinearLayout lview;

        public ViewHolder(View itemView) {

            super(itemView);


            textName  = (TextView) itemView.findViewById(R.id.childname);
            lview = (LinearLayout) itemView.findViewById(R.id.itemm);

        }

        // Click event for all items
        @Override
        public void onClick(View v) {

        }
    }

}
