package com.example.myapplication.ui.scrollable;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ScrollingFragment extends Fragment {

    public ScrollingFragment() {
        // Required empty public constructor
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_scrolling, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Sample data
        List<WidgetItem> widgetItemList = new ArrayList<>();
        for(int i=0;i<10;i++){
            widgetItemList.add(new WidgetItem(R.drawable.samplehome1, "Home 1", "$20", "Description of home 1"));
            widgetItemList.add(new WidgetItem(R.drawable.samplehome2, "Home 2", "$30", "Description of home 2"));
            widgetItemList.add(new WidgetItem(R.drawable.samplehome3, "Home 3", "$40", "Description of home 3"));
            widgetItemList.add(new WidgetItem(R.drawable.samplehome4, "Home 4", "$40", "Description of home 4"));
        }
        // Set up the adapter
        WidgetAdapter widgetAdapter = new WidgetAdapter(widgetItemList);
        recyclerView.setAdapter(widgetAdapter);

        return view;
    }
}