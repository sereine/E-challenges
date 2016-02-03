package com.dao.solution;

import com.model.Solution;


public interface SolutionDao {

    void save(Solution  solution);
	
    Solution findById(int id);
	
	
}
