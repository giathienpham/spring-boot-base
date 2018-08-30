package com.example.demo.services;

import java.util.List;

public interface BaseService<T> {
    T save(T t);
    T deactivate(T t);
    void delete(T t);
}
