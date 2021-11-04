package br.com.zupacademy.grupolaranja.recargacelular;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface RecargaCelularRepository extends JpaRepository<RecargaCelular, Long> {
    
    Optional<RecargaCelular> findByNumeroCelular(String numeroCelular);
}
