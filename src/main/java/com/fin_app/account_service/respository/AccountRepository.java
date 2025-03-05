package com.fin_app.account_service.respository;

import com.fin_app.account_service.entity.NewAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<NewAccountEntity, UUID> {
}
