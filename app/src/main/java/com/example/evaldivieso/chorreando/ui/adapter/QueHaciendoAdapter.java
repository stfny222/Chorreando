package com.example.evaldivieso.chorreando.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.evaldivieso.chorreando.R;
import com.example.evaldivieso.chorreando.ui.mvp.model.UserPost;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by evaldivieso on 15/09/2015.
 */
public class QueHaciendoAdapter extends RecyclerView.Adapter<QueHaciendoAdapter.QueHaciendoViewHolder> implements View.OnClickListener {
    private LayoutInflater inflater;
    List<DataRequired> userPosts;

    public QueHaciendoAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        userPosts = new ArrayList<>();
    }

    public void updateData(List<UserPost> newUserPostList) {
        this.userPosts.clear();
        for(UserPost up : newUserPostList){
            userPosts.add(new DataRequired(up.getUsername(), up.getLugar(), up.getFecha()));
        }
        notifyDataSetChanged();
    }

    @Override
    public QueHaciendoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_que_haciendo, parent, false);
        QueHaciendoViewHolder holder = new QueHaciendoViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(QueHaciendoViewHolder holder, int position) {
        DataRequired current = userPosts.get(position);
        holder.tv_usuario.setText(current.getTv_usuario());
        holder.tv_lugar.setText(current.getTv_lugar());
        holder.tv_fecha.setText(current.getTv_fecha());
    }

    @Override
    public int getItemCount() {
        return userPosts.size();
    }

    @Override
    public void onClick(View view) {

    }

    class QueHaciendoViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_que_haciendo)
        ImageView iv_que_haciendo;
        @Bind(R.id.tv_usuario)
        TextView tv_usuario;
        @Bind(R.id.tv_lugar)
        TextView tv_lugar;
        @Bind(R.id.tv_fecha)
        TextView tv_fecha;

        public QueHaciendoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class DataRequired {
        String iv_que_haciendo, tv_usuario, tv_lugar, tv_fecha;

        public DataRequired(String tv_usuario, String tv_lugar, String tv_fecha) {
            this.tv_usuario = tv_usuario;
            this.tv_lugar = tv_lugar;
            this.tv_fecha = tv_fecha;
        }

        public String getIv_que_haciendo() {
            return iv_que_haciendo;
        }

        public void setIv_que_haciendo(String iv_que_haciendo) {
            this.iv_que_haciendo = iv_que_haciendo;
        }

        public String getTv_usuario() {
            return tv_usuario;
        }

        public void setTv_usuario(String tv_usuario) {
            this.tv_usuario = tv_usuario;
        }

        public String getTv_lugar() {
            return tv_lugar;
        }

        public void setTv_lugar(String tv_lugar) {
            this.tv_lugar = tv_lugar;
        }

        public String getTv_fecha() {
            return tv_fecha;
        }

        public void setTv_fecha(String tv_fecha) {
            this.tv_fecha = tv_fecha;
        }
    }
}
