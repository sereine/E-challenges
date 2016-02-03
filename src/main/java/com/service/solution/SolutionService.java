package com.service.solution;

import com.model.Solution;


public interface SolutionService {
   
	 public void save(Solution solution);
		
		public Solution findById(int id);
	
}
