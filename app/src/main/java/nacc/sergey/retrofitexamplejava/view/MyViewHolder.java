package nacc.sergey.retrofitexamplejava.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import nacc.sergey.retrofitexamplejava.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView textView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageView);
        textView = itemView.findViewById(R.id.textView);
    }
}
