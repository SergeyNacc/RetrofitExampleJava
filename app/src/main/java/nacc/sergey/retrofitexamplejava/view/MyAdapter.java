package nacc.sergey.retrofitexamplejava.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import nacc.sergey.retrofitexamplejava.R;
import nacc.sergey.retrofitexamplejava.data.Hero;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context mContext;
    List<Hero> heroList;

    public MyAdapter(Context mContext, List<Hero> heroList) {
        this.mContext = mContext;
        this.heroList = heroList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_layout, parent ,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Hero hero = heroList.get(position);

        Glide.with(mContext)
                .load(hero.getImageurl())
                .into(holder.imageView);

        holder.textView.setText(hero.getName());
    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }
}
