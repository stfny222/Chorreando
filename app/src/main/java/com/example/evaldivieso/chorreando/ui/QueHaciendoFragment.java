package com.example.evaldivieso.chorreando.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.evaldivieso.chorreando.AppChorreando;
import com.example.evaldivieso.chorreando.R;
import com.example.evaldivieso.chorreando.ui.adapter.QueHaciendoAdapter;
import com.example.evaldivieso.chorreando.ui.mvp.model.UserPost;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class QueHaciendoFragment extends Fragment {
    @Bind(R.id.rv_que_haciendo)
    RecyclerView rv_que_haciendo;
    QueHaciendoAdapter queHaciendoAdapter;

    public static QueHaciendoFragment newInstance() {
        QueHaciendoFragment fragment = new QueHaciendoFragment();
        return fragment;
    }

    public QueHaciendoFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_que_haciendo, container, false);
        ButterKnife.bind(this, view);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.title_activity_que_haciendo);

        queHaciendoAdapter = new QueHaciendoAdapter(getActivity());

        List<UserPost> userPosts;

        String json = "[\n" +
                "  {\n" +
                "    \"username\": \"User1\",\n" +
                "    \"lugar\": \"Lugar1\",\n" +
                "    \"fecha\": \"21/10/2015\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"username\": \"User2\",\n" +
                "    \"lugar\": \"Lugar1\",\n" +
                "    \"fecha\": \"20/10/2015\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"username\": \"User3\",\n" +
                "    \"lugar\": \"Lugar2\",\n" +
                "    \"fecha\": \"17/9/2015\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"username\": \"User1\",\n" +
                "    \"lugar\": \"Lugar3\",\n" +
                "    \"fecha\": \"11/9/2015\"\n" +
                "  }\n" +
                "]";

        Gson gson = new Gson();
        Type token = new TypeToken<List<UserPost>>() {}.getType();
        userPosts = gson.fromJson(json, token);

        queHaciendoAdapter.updateData(userPosts);
        rv_que_haciendo.setAdapter(queHaciendoAdapter);
        rv_que_haciendo.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

}
