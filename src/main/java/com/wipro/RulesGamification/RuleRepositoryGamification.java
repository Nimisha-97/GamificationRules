package com.wipro.RulesGamification;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.wipro.RulesGamification.BeanRulesGamification;

public interface RuleRepositoryGamification extends MongoRepository<BeanRulesGamification, String> {
	BeanRulesGamification findBy_id(ObjectId _id);
}
