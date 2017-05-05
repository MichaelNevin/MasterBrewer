package com.MasterBrewer.Repository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.MasterBrewer.Entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

	public UserEntity findByUname(String string);
	
	@Modifying
	@Query(value="UPDATE Users SET CREDIT = :amount  WHERE USER_ID = :id",nativeQuery=true)
	public void updateCreditById(@Param("amount") double amount, @Param("id") int id);
	

}
