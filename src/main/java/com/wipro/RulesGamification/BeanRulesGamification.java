package com.wipro.RulesGamification;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rules")
public class BeanRulesGamification {
	
	@Id
	public ObjectId _id;
	
	private String name;
	private String toolName;
	private double threshold;
	private String mName;
	private String operator;
	private int reward;
	
	public BeanRulesGamification() {
		
	}
	
	public BeanRulesGamification(ObjectId _id, String name, String toolName, double threshold, String mName, String operator, int reward) {
		super();
		this._id = _id;
		this.name = name;
		this.toolName = toolName;
		this.threshold=threshold;
		this.mName = mName;
		this.operator = operator;
		this.reward=reward;
	}
	
	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String gettoolName() {
		return toolName;
	}
	public void settoolName(String toolName) {
		this.toolName = toolName;
	}
	public float getThreshold() {
		return threshold;
	}
	public void setThreshold(float threshold) {
		this.threshold = threshold;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public int getReward() {
		return reward;
	}
	public void setReward(int reward) {
		this.reward = reward;
	}

		
	}



