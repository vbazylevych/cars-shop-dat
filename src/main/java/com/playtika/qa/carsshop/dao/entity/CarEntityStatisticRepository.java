package com.playtika.qa.carsshop.dao.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;

public interface CarEntityStatisticRepository extends JpaRepository<CarEntity,Long>
{
    Map<Integer, Integer> getSoldCarsPerYear();

}
