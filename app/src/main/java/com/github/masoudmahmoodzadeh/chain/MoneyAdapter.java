package com.github.masoudmahmoodzadeh.chain;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.masoudmahmoodzadeh.chain.base.WithdrawAble;
import com.github.masoudmahmoodzadeh.chain.databinding.MoneyListItemBinding;

import java.util.List;

public class MoneyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<WithdrawAble> list;

    public MoneyAdapter(List<WithdrawAble> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        MoneyListItemBinding binding = MoneyListItemBinding.inflate(inflater);
        return new MoneyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MoneyViewHolder viewHolder = (MoneyViewHolder) holder;

        WithdrawAble withdrawAble = list.get(position);
        viewHolder.binding.tvCount.setText(String.valueOf(withdrawAble.getCount()).concat(" X "));
        viewHolder.binding.tvInventory.setText(String.valueOf(withdrawAble.getMoney().getPrice()).concat("$"));
        viewHolder.binding.ivDollar.setBackgroundResource(withdrawAble.getMoney().getIcon());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private static class MoneyViewHolder extends RecyclerView.ViewHolder {
        private final MoneyListItemBinding binding;

        public MoneyViewHolder(@NonNull MoneyListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
