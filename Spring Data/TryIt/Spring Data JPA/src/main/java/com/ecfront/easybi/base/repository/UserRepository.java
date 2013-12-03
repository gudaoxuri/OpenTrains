package com.ecfront.easybi.base.repository;

import com.ecfront.easybi.base.domain.EZUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<EZUser, String> {

    EZUser getByUserNameOrEmail(String userName, String email);

    Page<EZUser> findByUserNameLikeOrEmailLikeOrderByUserNameAsc(String userName, String email, Pageable pageable);

}
