package com.ecfront.test.mongodb.repositories;

import com.ecfront.test.mongodb.document.Sortable;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SortableRepository extends MongoRepository<Sortable, ObjectId> {

    public List<Sortable> findByNameOrderBySortDesc(String name, Pageable page);

    public List<Sortable> findByNameOrderBySortAsc(String name, Pageable page);

}
