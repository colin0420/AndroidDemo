package com.example.androiddemo.com.example.news;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.androiddemo.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewsTitleFragment extends Fragment {
    private boolean isTwoPane;

    class NewsAdpater extends RecyclerView.Adapter<NewsAdpater.ViewHolder> {
        private List<News> mNewsList;

        class ViewHolder extends RecyclerView.ViewHolder{
            TextView newsTitleText;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                newsTitleText = (TextView) itemView.findViewById(R.id.news_title);
            }
        }

        public NewsAdpater(List<News> newsList) {
            mNewsList = newsList;
        }

        @NonNull @Override
        public NewsAdpater.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_item, parent, false);
            final ViewHolder holder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    News news = mNewsList.get(holder.getAdapterPosition());
                    if (isTwoPane){
                        // 左边是标题列表，右边是内容页面
                        NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager()
                            .findFragmentById(R.id.news_content_fragment);
                        newsContentFragment.showTitleAndContent(news.getTitle(), news.getContent());
                    }
                    else{
                        // 如果是竖屏,直接拉起内容页面
                        NewsContentActivity.actionStart(getActivity(), news.getTitle(), news.getContent());
                    }
                }
            });

            return holder;
        }

        @Override public void onBindViewHolder(@NonNull NewsAdpater.ViewHolder viewHolder, int position) {
            News news = mNewsList.get(position);
            viewHolder.newsTitleText.setText(news.getTitle());
        }

        @Override public int getItemCount() {
            return mNewsList.size();
        }
    }

    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
        @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_frag, container, false);

        // 新闻标题RecyclerView
        RecyclerView newsTitleRecycleView = (RecyclerView) view.findViewById(R.id.news_title_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        newsTitleRecycleView.setLayoutManager(layoutManager);
        NewsAdpater newsAdpater = new NewsAdpater(getNews());
        newsTitleRecycleView.setAdapter(newsAdpater);

        return view;
    }

    @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO colin 横竖屏
        if (getActivity().findViewById(R.id.news_conotent_layout) != null){
            isTwoPane = true;
        } else {
            isTwoPane = false;
        }
    }

    private List<News> getNews() {
        List<News> newsList = new ArrayList<>();

        for (int i = 0; i < 50; i++){
            News news = new News();
            news.setTitle("This is title " + i);
            news.setContent(getRandomLengthContent("This is content " + i + ". "));
            newsList.add(news);
        }
        return newsList;
    }

    private String getRandomLengthContent(String content){
        Random random = new Random();
        int length = random.nextInt(20) + 1;

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++){
            builder.append(content);
        }

        return builder.toString();
    }
}
