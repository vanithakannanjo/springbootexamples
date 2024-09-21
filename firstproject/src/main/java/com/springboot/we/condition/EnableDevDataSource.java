package com.springboot.we.condition;

public class EnableDevDataSource implements DataSourceConfig{
    @Override
    public void makeConnection(){
        System.out.println("Connection Established to Dev Data...");
    }
}
