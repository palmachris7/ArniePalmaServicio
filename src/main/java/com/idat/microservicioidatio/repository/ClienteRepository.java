package com.idat.microservicioidatio.repository;


import com.idat.microservicioidatio.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
