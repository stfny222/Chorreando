package com.example.evaldivieso.chorreando.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.evaldivieso.chorreando.R;
import com.example.evaldivieso.chorreando.ui.mvp.model.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by evaldivieso on 21/09/2015.
 */
public class AmigosAdapter extends RecyclerView.Adapter<AmigosAdapter.AmigosViewHolder> implements View.OnClickListener {
    private LayoutInflater inflater;
    List<DataRequired> amigos;

    public AmigosAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        amigos = new ArrayList<>();
    }

    public void updateData(List<User> newAmigos) {
        this.amigos.clear();
        for(User user : newAmigos){
            amigos.add(new DataRequired(user.getUsername()));
        }
        notifyDataSetChanged();
    }

    @Override
    public AmigosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_amigos, parent, false);
        AmigosViewHolder holder = new AmigosViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(AmigosViewHolder holder, int position) {
        DataRequired current = amigos.get(position);
        holder.tv_amigos_nombre.setText(current.getTv_amigos_nombre());
    }

    @Override
    public int getItemCount() {
        return amigos.size();
    }

    @Override
    public void onClick(View view) {

    }

    class AmigosViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_amigos)
        ImageView iv_amigos;
        @Bind(R.id.tv_amigos_nombre)
        TextView tv_amigos_nombre;

        public AmigosViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class DataRequired {
        String iv_amigos, tv_amigos_nombre;

        public DataRequired(String tv_amigos_nombre) {
            this.tv_amigos_nombre = tv_amigos_nombre;
        }

        public String getIv_amigos() {
            return iv_amigos;
        }

        public void setIv_amigos(String iv_amigos) {
            this.iv_amigos = iv_amigos;
        }

        public String getTv_amigos_nombre() {
            return tv_amigos_nombre;
        }

        public void setTv_amigos_nombre(String tv_amigos_nombre) {
            this.tv_amigos_nombre = tv_amigos_nombre;
        }
    }
}
