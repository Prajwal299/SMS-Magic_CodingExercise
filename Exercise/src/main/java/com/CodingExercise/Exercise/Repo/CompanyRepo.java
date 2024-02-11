package com.CodingExercise.Exercise.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CodingExercise.Exercise.entity.Company;

public interface CompanyRepo extends JpaRepository<Company, Long>{

}
