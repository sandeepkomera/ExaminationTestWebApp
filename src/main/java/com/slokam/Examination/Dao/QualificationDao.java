package com.slokam.Examination.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slokam.Examination.entity.Qualification;

@Repository
public interface QualificationDao extends JpaRepository<Qualification, Integer>{

}
