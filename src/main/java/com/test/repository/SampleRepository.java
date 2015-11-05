package com.test.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.model.Sample;

public interface SampleRepository extends MongoRepository<Sample, String> {

}
