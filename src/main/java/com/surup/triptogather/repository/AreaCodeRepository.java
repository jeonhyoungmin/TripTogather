package com.surup.triptogather.repository;

import com.surup.triptogather.domain.AreaCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaCodeRepository extends JpaRepository<AreaCode, Long> {
}
