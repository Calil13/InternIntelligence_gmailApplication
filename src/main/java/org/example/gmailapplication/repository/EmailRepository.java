package org.example.gmailapplication.repository;

import org.example.gmailapplication.entity.Email;
import org.example.gmailapplication.enums.EmailFolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

    List<Email> findByUserIdAndFolderOrderByCreatedAtDesc(Long userId, EmailFolder folder);

    List<Email> findByUserIdAndIsStarredTrueAndFolderNotOrderByCreatedAtDesc(Long userId, EmailFolder folder);

    Optional<Email> findByIdAndUserId(Long id, Long userId);

    long countByUserIdAndFolderAndIsReadFalse(Long userId, EmailFolder folder);
}
