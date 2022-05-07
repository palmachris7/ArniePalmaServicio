package com.idat.microservicioidatio.repository;


import com.idat.microservicioidatio.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfesorRepository extends JpaRepository<Profesor,Integer> {
}
