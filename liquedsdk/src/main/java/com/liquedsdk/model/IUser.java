package com.liquedsdk.model;

public interface IUser {

    String getName();
    String getPassword();
    int isValidEntry(String name, String password);
}
