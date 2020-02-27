package com.example.sampleapp.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sampleapp.R;
import com.example.sampleapp.db.PersonInfo;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    List<PersonInfo> personInfoList;
    public MyAdapter(List<PersonInfo> personInfoList) {
        this.personInfoList = personInfoList;
    }



    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.persons_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.uiD.setText(Integer.toString(personInfoList.get(position).getUid()));
        holder.tvfname.setText(personInfoList.get(position).getFname());
        holder.tvlname.setText(personInfoList.get(position).getLname());
        holder.tvemail.setText(personInfoList.get(position).getEmail());
        holder.tvpassword.setText(personInfoList.get(position).getPassword());
    }

    @Override
    public int getItemCount() {
        return personInfoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvfname,tvlname,tvemail,tvpassword,uiD;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            uiD=itemView.findViewById(R.id.tvUID);
            tvfname = itemView.findViewById(R.id.tvfname);
            tvlname = itemView.findViewById(R.id.tvlname);
            tvemail = itemView.findViewById(R.id.tvemail);
            tvpassword = itemView.findViewById(R.id.tvpassword);
        }
    }
}
