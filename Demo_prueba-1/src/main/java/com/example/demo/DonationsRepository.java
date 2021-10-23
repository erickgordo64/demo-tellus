package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DonationsRepository extends JpaRepository<Donations, Long> {
	@Query("SELECT u FROM Donations u WHERE u.fecha=?1")
	public Donations findByDate(String fecha);
}
