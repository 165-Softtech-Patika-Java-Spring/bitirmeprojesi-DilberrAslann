package com.dilberaslan.graduationProject.graduationProject.usr.dao;

import com.dilberaslan.graduationProject.graduationProject.usr.entity.UsrUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Dilber
 */
@Repository
public interface UsrUserDao extends JpaRepository<UsrUser, Long> {

    boolean existsByUserName(String userName);

    Optional<UsrUser> findByUserName(String username);

}
