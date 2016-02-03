package com.service.solution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.solution.SolutionDao;
import com.model.Solution;

@Service("solutionService")
@Transactional
public class SolutionServiceImpl implements SolutionService {
   
	@Autowired
	private SolutionDao daoSolution;
	
	@Override
	public void save(Solution solution) {
         
		daoSolution.save(solution);
		
	}

	@Override
	public Solution findById(int id) {
		return daoSolution.findById(id);
		
	}

}
