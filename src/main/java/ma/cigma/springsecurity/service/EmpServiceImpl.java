package ma.cigma.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.cigma.springsecurity.aop.Admin1Profile;
import ma.cigma.springsecurity.aop.LogExecutionTime;
import ma.cigma.springsecurity.aop.Tracabilite;
import ma.cigma.springsecurity.dao.EmpRepository;
import ma.cigma.springsecurity.domaine.EmpConverter;
import ma.cigma.springsecurity.domaine.EmpVo;
import ma.cigma.springsecurity.service.model.Emp;

@Service
@Transactional
public class EmpServiceImpl implements IEmpService {
	@Autowired
	private EmpRepository empRepository;
	@Override
	public List<EmpVo> getEmployees() {
		List<Emp> list = empRepository.findAll();
		return EmpConverter.toListVo(list);
	}
	@Override
	@Tracabilite
	@LogExecutionTime
	public void save(EmpVo emp) {
		empRepository.save(EmpConverter.toBo(emp));
	}
	@Override
	@Tracabilite
	@LogExecutionTime
	public EmpVo getEmpById(Long id) {
		boolean trouve = empRepository.existsById(id);
		if (!trouve)
			return null;
		return EmpConverter.toVo(empRepository.findById(id).get());
	}
	@Override
	@LogExecutionTime
	@Admin1Profile(noms= {"admin1","admin2"})
	public void delete(Long id) {
		empRepository.deleteById(id);
	}
	@Override
	public List<EmpVo> findBySalary(Double salaty) {
		List<Emp> list = empRepository.findBySalary(salaty);
		return EmpConverter.toListVo(list);
	}
	@Override
	@Tracabilite
	public List<EmpVo> findByFonction(String fonction) {
		List<Emp> list = empRepository.findByFonction(fonction);
		return EmpConverter.toListVo(list);
	}
	@Override
	public List<EmpVo> findBySalaryAndFonction(Double salary, String fonction) {
		List<Emp> list = empRepository.findBySalaryAndFonction(salary, fonction);
		return EmpConverter.toListVo(list);
	}
	@Override
	public EmpVo getEmpHavaingMaxSalary() {
		return EmpConverter.toVo(empRepository.getEmpHavaingMaxSalary());
	}
	@Override
	public List<EmpVo> findAll(int pageId, int size) {
		Page<Emp> result = empRepository.findAll(PageRequest.of(pageId, size, Direction.ASC, "name"));
		return EmpConverter.toListVo(result.getContent());
	}
	@Override
	public List<EmpVo> sortBy(String fieldName) {
		return EmpConverter.toListVo(empRepository.findAll(Sort.by(fieldName)));
	}
}
