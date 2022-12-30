package com.ditya.sima1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterAbsentHistory extends RecyclerView.Adapter<AdapterAbsentHistory.myViewHolder> {

    ArrayList<ModelAbsentHistory> absentArrayList;

    public AdapterAbsentHistory(ArrayList<ModelAbsentHistory> absentArrayList) {
        this.absentArrayList = absentArrayList;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.recycler_absent,parent,false);
        return new AdapterAbsentHistory.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.in_title.setText(absentArrayList.get(position).getTitle());
        holder.in_date.setText(absentArrayList.get(position).getDatetime());
        holder.in_note.setText(absentArrayList.get(position).getNote());
    }

//    @Override
//    public void onBindViewHolder(@NonNull myViewHolder holder, @SuppressLint("RecyclerView") int position) {
//        holder.enip.setText(absentArrayList.get(position).getTitle());
//        holder.enama.setText(absentArrayList.get(position).getDatetime());
//        holder.ejnskel.setText(absentArrayList.get(position).getNote());
//
//        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(view.getContext(), EditDataPolisi.class);
//                intent.putExtra("nip",absentArrayList.get(position).getNip());
//                intent.putExtra("nama_pol",absentArrayList.get(position).getNama_pol());
//                intent.putExtra("jns_kel",absentArrayList.get(position).getJns_kel());
//
//                view.getContext().startActivity(intent);
//            }
//        });
//    }

    @Override
    public int getItemCount() {
        return absentArrayList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView in_title, in_date,in_note;
        RelativeLayout relativeLayout;
        public myViewHolder(@NonNull View itemView) {

            super(itemView);
            in_title=itemView.findViewById(R.id.in_title);
            in_date=itemView.findViewById(R.id.in_date);
            in_note=itemView.findViewById(R.id.in_note);

        }
    }
}
