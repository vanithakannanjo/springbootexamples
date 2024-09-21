package com.springboot.we.condition;

public class EnableProdDataSource implements DataSourceConfig{
    @Override
    public void makeConnection(){
        System.out.println("Connection Established to Prod Data...");
    }
}
