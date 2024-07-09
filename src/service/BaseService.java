package service;

import java.util.*;

public interface BaseService<T> {
    T add(T t);
    List<T> list();
    void delete(UUID id);
    T update(UUID id, T t);
}
