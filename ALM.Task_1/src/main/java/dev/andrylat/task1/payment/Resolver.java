package dev.andrylat.task1.payment;

public interface Resolver<K,T> {
    
    K resolve(T input);    
    
}

