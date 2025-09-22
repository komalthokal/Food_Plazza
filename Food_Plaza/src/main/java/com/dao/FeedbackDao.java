package com.dao;

import java.util.List;

import com.model.Feedback;

public interface FeedbackDao {

	boolean add_feedback(Feedback fd);
	boolean delete_feedback(String c_email);
	List<Feedback>get_allfeedback();
}
