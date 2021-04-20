package dev.andrylat.task1.common;

public interface Resolver<K,T> {
    
    K resolve(T input);    
    
}

