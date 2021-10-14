package com.example.recyclerviewhelperexample.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewhelperexample.R;
import com.example.recyclerviewhelperexample.listener.OnNormalItemClickListener;
import com.example.recyclerviewhelperexample.model.Status;

import java.util.ArrayList;
import java.util.List;

public class NormalRvAdapter extends RecyclerView.Adapter<NormalRvAdapter.NormalViewHolder> {
    protected Context context;
    protected List<Status> dataList = new ArrayList<>();
    protected OnNormalItemClickListener listener;

    public NormalRvAdapter(Context context, List<Status> datas, OnNormalItemClickListener listener) {
        this.context = context;
        this.dataList.addAll(datas);
        this.listener = listener;
    }

    @NonNull
    @Override
    public NormalRvAdapter.NormalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        // Nạp layout cho View biểu diễn phần tử sinh viên
        View studentView =
                inflater.inflate(R.layout.item_animation, parent, false);

        NormalRvAdapter.NormalViewHolder viewHolder = new NormalViewHolder(studentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NormalViewHolder holder, int position) {
        holder.tweetName.setText(dataList.get(position).getText());
        Log.d("testing", position+"");
        holder.tweetName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(view, holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class NormalViewHolder extends RecyclerView.ViewHolder {
        private final TextView tweetName;

        public NormalViewHolder(@NonNull View itemView) {
            super(itemView);
            tweetName = itemView.findViewById(R.id.tweetName);
        }
    }
}
