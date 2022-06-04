package com.idat.microservicioidatio.repository;


import com.idat.microservicioidatio.model.Lavadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LavadoraRepository extends JpaRepository<Lavadora,Integer> {
}
