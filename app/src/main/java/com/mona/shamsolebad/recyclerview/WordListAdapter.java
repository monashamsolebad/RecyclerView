package com.mona.shamsolebad.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    private final LinkedList<String> mWordList;
    private LayoutInflater mInflater;

    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, viewGroup, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView wordItemView;
        final WordListAdapter madapter;

        public WordViewHolder(@NonNull View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.madapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
// Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
// Use that to access the affected item in mWordList.
            String element = mWordList.get(mPosition);
// Change the word in the mWordList.
            mWordList.set(mPosition, "Clicked! " + element);
// Notify the adapter, that the data has changed so it can
// update the RecyclerView to display the data.
            madapter.notifyDataSetChanged();
        }
    }

    public WordListAdapter(Context context, LinkedList<String> mWordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = mWordList;
    }
}
