package com.example.androiddemo.mvp;

public class TestModel implements TestContract.Model {
    private static final  TestModel INSTANCE = new TestModel();
    private TestModel() {
    }

    public static TestModel getInstance(){
        return INSTANCE;
    }

    @Override
    public String doData() {
        return "MVP test";
    }
}
