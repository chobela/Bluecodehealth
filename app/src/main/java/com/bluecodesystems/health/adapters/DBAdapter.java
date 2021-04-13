package com.bluecodesystems.health.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bluecodesystems.health.R;
import com.bluecodesystems.health.SingleMother;
import com.bluecodesystems.health.models.Mothers;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class DBAdapter extends RecyclerView.Adapter<DBAdapter.ViewHolder>{


    Context context;

    List<Mothers> mothers;

    private static final String TAG = "DBAdapter";

    public DBAdapter(List<Mothers> mothers, Context context){

        super();

        this.mothers = mothers;
        this.context = context;
    }

    @Override
    public DBAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_mother, parent, false);

        DBAdapter.ViewHolder viewHolder = new DBAdapter.ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DBAdapter.ViewHolder holder, final int position) {

        final Mothers mth = mothers.get(position);

        holder.textName.setText(mth.getName());
        holder.textNrc.setText("NRC : " + mth.getNrc() + " ...");


        holder.lview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {


                    case (R.id.itemm):

                        Intent intent = new Intent(context, SingleMother.class);
                        intent.putExtra("mothers",  mothers.get(position));
                        context.startActivity(intent);
                        break;
                }
            }

        });

    }

    @Override
    public int getItemCount() {

        return mothers.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textName, textNrc;
        LinearLayout lview;

        public ViewHolder(View itemView) {

            super(itemView);


            textName  = (TextView) itemView.findViewById(R.id.name);
            textNrc  = (TextView) itemView.findViewById(R.id.nrc);
            lview = (LinearLayout) itemView.findViewById(R.id.itemm);

        }

        // Click event for all items
        @Override
        public void onClick(View v) {

        }
    }

}
