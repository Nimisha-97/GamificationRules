package com.wipro.RulesGamification;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(value="http://ec2-52-66-189-143.ap-south-1.compute.amazonaws.com:3000")
@RestController
@RequestMapping(path="/rule")
public class RestControllerRulesGamification {
	@Autowired
	private RuleRepositoryGamification repository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<BeanRulesGamification> getAllTeam() {
		System.out.println("Nimisha");
	  return repository.findAll();
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public BeanRulesGamification getPetById(@PathVariable("id") ObjectId id) {
	  return repository.findBy_id(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modifyGameById(@PathVariable("id") ObjectId id, @Valid 
	@RequestBody BeanRulesGamification game) {
		game.set_id(id);
	  repository.save(game);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String createGame(@Valid @RequestBody BeanRulesGamification game) {
		/*Query query = new Query();
		query.addCriteria(Criteria.where("name").is(game.getName()));*/
		Query query = new Query();
		query.addCriteria(
		    new Criteria().andOperator(
		        Criteria.where("name").is(game.getName()),
		        Criteria.where("metric").is(game.getMetric()),
		        Criteria.where("threshold").is(game.getThreshold()),
		        Criteria.where("mName").is(game.getmName()),
		        Criteria.where("operator").is(game.getOperator()),
		        Criteria.where("reward").is(game.getReward())
		    )
		);
		
		BeanRulesGamification userTest1 = mongoTemplate.findOne(query, BeanRulesGamification.class);
		if(userTest1==null)
		{
			System.out.println("inside ex");
		game.set_id(ObjectId.get());
		repository.save(game);
		return "Success";
		}
		else
		{
			System.out.println("outside ex");
			return "Sorry same name exists";
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void deleteGame(@PathVariable ObjectId id) {
	    repository.delete(repository.findBy_id(id));
	  }

}
