package com.ari.userTask.repository;

import com.ari.userTask.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Arittek-002 on 27/07/2021.
 */

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity,Integer> {


    public UserEntity findByUsername(String username);

//    @Modifying
//    @Query(" update  UserEntity  e SET e.address = :address, e.email=:email, e.firstName=:firstName, e.lastName=:lastName,e.phoneNo=:phoneNo,e.cnic=:cnic WHERE e.id = :id")
//    public UserEntity updateUser(@Param("id") Long id, @Param("address") String address, @Param("email") String email,@Param("firstName") String firstName,@Param("lastName") String lastName
//    ,@Param("phoneNo") String phoneNo,@Param("cnic") String cnic);
}
