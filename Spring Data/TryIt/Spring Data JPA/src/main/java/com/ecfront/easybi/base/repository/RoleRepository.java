package com.ecfront.easybi.base.repository;

import com.ecfront.easybi.base.domain.EZRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoleRepository extends PagingAndSortingRepository<EZRole, String> {

    Page<EZRole> findByRoleNameLikeOrderByRoleNameAsc(String roleName, Pageable pageable);

}
