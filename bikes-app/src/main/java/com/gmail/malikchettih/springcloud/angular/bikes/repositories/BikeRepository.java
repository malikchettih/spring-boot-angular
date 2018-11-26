package com.gmail.malikchettih.springcloud.angular.bikes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmail.malikchettih.springcloud.angular.bikes.models.Bike;

public interface BikeRepository extends JpaRepository<Bike, Long>{

}
