package com.example.androiddemo.com.example.news;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.androiddemo.R;

public class NewsContentFragment extends Fragment {
    private View view;

    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.news_content_frag, container, false);
        return this.view;
    }

    /**
     *  将新闻标题和内容显示在界面上
     * @param newsTitle
     * @param newsContent
     */
    public void showTitleAndContent(String newsTitle, String newsContent){
        View visibilityLayout = view.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
        TextView tvNewsTitle = (TextView) view.findViewById(R.id.news_title);
        TextView tvNewsContent = (TextView) view.findViewById(R.id.news_content);
        tvNewsTitle.setText(newsTitle);
        tvNewsContent.setText(newsContent);
    }
}
