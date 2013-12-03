package com.ecfront.test.mongo.test;

import com.ecfront.easybi.BaseTest;
import com.ecfront.test.mongodb.document.Sortable;
import com.ecfront.test.mongodb.repositories.SortableRepository;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SortableTest extends BaseTest {

    @Inject
    private SortableRepository sortableRepository;

    @Before
    public void setup() {
        sortableRepository.deleteAll();
        Sortable sortable = new Sortable();
        sortable.setName("a");
        sortable.setSort(2);
        sortableRepository.save(sortable);
        sortable = new Sortable();
        sortable.setName("a");
        sortable.setSort(3);
        sortableRepository.save(sortable);
        sortable = new Sortable();
        sortable.setName("a");
        sortable.setSort(1);
        sortableRepository.save(sortable);
        sortable = new Sortable();
        sortable.setName("b");
        sortable.setSort(4);
        sortableRepository.save(sortable);
    }

    @Test
    public void testSortable() {
        //倒序查询name为a的实体，预期id是3
        List<Sortable> sortables = sortableRepository.findByNameOrderBySortDesc("a", new PageRequest(0, 1));
        Assert.assertEquals(sortables.get(0).getSort(), 3);
        //正序查询name为a的实体，预期id是1
        sortables = sortableRepository.findByNameOrderBySortAsc("a", new PageRequest(0, 1));
        Assert.assertEquals(sortables.get(0).getSort(), 1);
    }
}
