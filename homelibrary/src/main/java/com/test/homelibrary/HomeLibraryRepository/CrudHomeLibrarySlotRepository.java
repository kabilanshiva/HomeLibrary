package com.test.homelibrary.HomeLibraryRepository;

import com.test.homelibrary.HomeLibraryEntity.SlotEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudHomeLibrarySlotRepository extends CrudRepository<SlotEntity,Integer> {
}
