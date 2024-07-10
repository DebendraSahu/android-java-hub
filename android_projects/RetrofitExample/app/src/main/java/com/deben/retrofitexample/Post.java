package com.deben.retrofitexample;

import androidx.annotation.NonNull;

public class Post {
    private final int userId;
    private final int id;
    private final String title;
    private final String body;

    public Post(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    @NonNull
    @Override
    public String toString() {
        return "Post{\n" +
                "userId=" + userId +
                ",\n id=" + id +
                ",\n title='" + title + '\'' +
                ",\n body='" + body + '\'' +
                "\n" + '}';
    }
}
