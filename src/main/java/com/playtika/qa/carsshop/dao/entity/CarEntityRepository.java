package com.playtika.qa.carsshop.dao.entity;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CarEntityRepository extends JpaRepository<CarEntity,Long>,
CarEntityStatisticRepository{
@Query("select c.year, count(c) from CarEntity c wher c.brand= :brand group by c.year")

//or @Query(value = "", nativeQuery = true)
Map<Integer, Integer> getSoldCarsPerYear(String brand);

    List<CarEntity> findByYear(String s);
    void deleteByBrandContains(String keyword);

    List<CarEntity> findByYearAndBrand(String s, String y);

    List<CarEntity> findByYearAndOwnerFirstName(int year, String firstName);

    Optional<CarEntity> getByPlateNumber(String plateNumber);

    Optional<CarEntity>  findByYearAndBrandOrderByPlateNumber(int year, String brand, Sort sort, Pageable pageble);

}

