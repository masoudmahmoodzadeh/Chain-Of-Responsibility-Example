package com.github.masoudmahmoodzadeh.chain;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.masoudmahmoodzadeh.chain.base.WithdrawAble;

import java.util.List;

public class MoneyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<WithdrawAble> list;

    public MoneyAdapter(List<WithdrawAble> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.inc_dollar, parent, false);
        return new MoneyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MoneyViewHolder viewHolder = (MoneyViewHolder) holder;

        WithdrawAble withdrawAble = list.get(position);
        viewHolder.tv_count.setText(String.valueOf(withdrawAble.getCount()).concat(" X "));
        viewHolder.tv_dollar.setText(String.valueOf(withdrawAble.getMoney().getPrice()).concat("$"));
        viewHolder.iv_dollar.setBackgroundResource(withdrawAble.getMoney().getIcon());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private static class MoneyViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_count;
        private final TextView tv_dollar;
        private final ImageView iv_dollar;

        public MoneyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_count = itemView.findViewById(R.id.tv_count);
            tv_dollar = itemView.findViewById(R.id.tv_dollar);
            iv_dollar = itemView.findViewById(R.id.iv_dollar);
        }
    }
}
