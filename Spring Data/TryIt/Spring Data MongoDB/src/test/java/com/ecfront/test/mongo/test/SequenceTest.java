package com.ecfront.test.mongo.test;

import com.ecfront.easybi.BaseTest;
import com.ecfront.test.mongodb.repositories.SequenceRepository;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SequenceTest extends BaseTest {

    @Inject
    private SequenceRepository sequenceRepository;
    @Inject
    private MongoTemplate mongoTemplate;

    @Before
    public void setup() {
        mongoTemplate.dropCollection("sequence");
    }

    @Test
    public void test() {
        Assert.assertEquals(sequenceRepository.getNextUserIdSequence("a"), 1L);
        Assert.assertEquals(sequenceRepository.getNextUserIdSequence("a"), 2L);
        Assert.assertEquals(sequenceRepository.getNextUserIdSequence("b"), 1L);

    }
}
