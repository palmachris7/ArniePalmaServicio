package com.idat.microservicioidatio.repository;

import com.idat.microservicioidatio.model.Ropa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RopaRepository extends JpaRepository<Ropa,Integer> {
}
