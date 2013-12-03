package com.ecfront.test.mongodb.repositories;

import com.ecfront.test.mongodb.document.Sequence;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class SequenceRepositoryImpl implements SequenceRepository {
    @Override
    public long getNextUserIdSequence(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        List objs = mongoTemplate.find(query, Sequence.class);
        if (null == objs || objs.size() == 0) {
            mongoTemplate.insert(new Sequence(name, 1));
        }
        Update update = new Update().inc("sequence", 1);
        return mongoTemplate.findAndModify(query, update, Sequence.class).getSequence();
    }

    @Inject
    private MongoTemplate mongoTemplate;
}
