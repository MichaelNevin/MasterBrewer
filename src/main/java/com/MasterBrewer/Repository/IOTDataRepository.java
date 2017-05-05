package com.MasterBrewer.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.MasterBrewer.Entities.IOTDataEntity;

/**
 * Created by michael on 10/12/16.
 */
@Repository
public interface IOTDataRepository extends CrudRepository<IOTDataEntity, Integer>{

}
