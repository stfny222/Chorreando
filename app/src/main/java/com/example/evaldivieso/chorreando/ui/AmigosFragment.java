package com.example.evaldivieso.chorreando.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.evaldivieso.chorreando.R;
import com.example.evaldivieso.chorreando.ui.adapter.AmigosAdapter;
import com.example.evaldivieso.chorreando.ui.mvp.model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AmigosFragment extends Fragment {
    @Bind(R.id.rv_amigos)
    RecyclerView rv_amigos;
    AmigosAdapter amigosAdapter;

    public static AmigosFragment newInstance() {
        AmigosFragment fragment = new AmigosFragment();
        return fragment;
    }

    public AmigosFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_amigos, container, false);
        ButterKnife.bind(this, view);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.title_activity_amigos);

        List<User> users;

        String json = "[\n" +
                "  {\n" +
                "    \"username\": \"amigo1\",\n" +
                "    \"pais\": \"\",\n" +
                "    \"fotoURL\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"username\": \"amigo2\",\n" +
                "    \"pais\": \"\",\n" +
                "    \"fotoURL\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"username\": \"amigo3\",\n" +
                "    \"pais\": \"\",\n" +
                "    \"fotoURL\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"username\": \"amigo4\",\n" +
                "    \"pais\": \"\",\n" +
                "    \"fotoURL\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"username\": \"amigo5\",\n" +
                "    \"pais\": \"\",\n" +
                "    \"fotoURL\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"username\": \"amigo6\",\n" +
                "    \"pais\": \"\",\n" +
                "    \"fotoURL\": \"\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"username\": \"amigo7\",\n" +
                "    \"pais\": \"\",\n" +
                "    \"fotoURL\": \"\"\n" +
                "  }\n" +
                "]";

        Gson gson = new Gson();
        Type token = new TypeToken<List<User>>() {}.getType();
        users = gson.fromJson(json, token);

        amigosAdapter = new AmigosAdapter(getActivity());
        amigosAdapter.updateData(users);
        rv_amigos.setAdapter(amigosAdapter);
        rv_amigos.setLayoutManager(new GridLayoutManager(getActivity(),3));

        return view;
    }

}
