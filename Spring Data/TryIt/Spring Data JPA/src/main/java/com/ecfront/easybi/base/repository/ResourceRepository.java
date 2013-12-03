package com.ecfront.easybi.base.repository;

import com.ecfront.easybi.base.domain.EZResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ResourceRepository extends PagingAndSortingRepository<EZResource, String> {

    Page<EZResource> findByResourceNameLikeOrderByResourceNameAsc(String resourceName, Pageable pageable);

}
