package com.download.files.fileLoader.repository;

import com.download.files.fileLoader.entity.CustomerEntity;
import com.download.files.fileLoader.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{
    <T extends Model> T save (T customer);
}
