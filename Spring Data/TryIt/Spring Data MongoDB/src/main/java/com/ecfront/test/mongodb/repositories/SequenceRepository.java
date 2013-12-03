package com.ecfront.test.mongodb.repositories;

public interface SequenceRepository {

    public long getNextUserIdSequence(String name);

}
