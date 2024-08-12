package com.gamerum.backend.external.persistence.relational.repository;

import com.gamerum.backend.external.persistence.relational.entity.notification.Notification;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByNotifiedProfileIdOrderByCreatedDateDesc(Long profileId, Pageable pageable);
    void deleteByIdAndNotifiedProfileId(Long id, Long profileId);
    void deleteAllByNotifiedProfileId(Long profileId);
    Long countByNotifiedProfileId(Long profileId);
}
