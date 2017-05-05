package com.MasterBrewer.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MasterBrewer.Entities.ProjectEntity;


@Repository
public interface ProjectsRepository extends CrudRepository<ProjectEntity, Integer> {
	
	@Modifying
	@Query(value="UPDATE Project SET STATUS = 0  WHERE PNAME = :title",nativeQuery=true)
	public void updateStatusByTitle(@Param("title") String title);

	
	@Modifying
	@Query(value="UPDATE Project SET DESCRIPTION = :description  WHERE PROJECT_OWNER_ID = :id",nativeQuery=true)
	public void updateDescription(@Param("description") String description, @Param("id") Integer id);
	
}
