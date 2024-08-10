package com.gamerum.backend.external.persistence.relational.repository;

import com.gamerum.backend.external.persistence.relational.entity.Notification;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByNotifiedProfileIdSortByCreatedDateDesc(Long profileId, Pageable pageable);
    void deleteByIdAndProfileId(Long id, Long profileId);
    void deleteAllByProfileId(Long profileId);
    Long countByNotifiedProfileId(Long profileId);
}
