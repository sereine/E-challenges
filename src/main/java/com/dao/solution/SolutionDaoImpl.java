package com.dao.solution;

import org.springframework.stereotype.Repository;

import com.dao.AbstractDao;
import com.dao.UserDao;
import com.model.Compte;
import com.model.Solution;


@Repository("solutionDao")
public class SolutionDaoImpl extends AbstractDao<Integer, Solution> implements SolutionDao  {

	@Override
	public void save(Solution solution) {
		persist(solution);
	}

	@Override
	public Solution findById(int id) {
		return getByKey(id);
	}

	
	
}
