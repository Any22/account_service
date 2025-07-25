package com.fin_app.account_service.respository;

import com.fin_app.account_service.dto.NewAccount;
import com.fin_app.account_service.entity.NewAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AccountRepository extends JpaRepository<NewAccountEntity, Long> {
    boolean existsByCustomerId(Long customerId);
    Optional<NewAccountEntity> findByCustomerId(Long customerId);
}

