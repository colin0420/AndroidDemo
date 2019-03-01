package com.example.androiddemo.mvp;

public interface TestContract {
    interface  View{
        //显示数据
        void showData(String str);
    }

    interface Presenter{
        //通知model获取数据，并将数据返回给View层
        void getData();
    }

    interface  Model{
        //处理数据
        String doData();
    }

}
