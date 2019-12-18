package creditAuto.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import creditAuto.dao.ContractDAO;
import creditAuto.model.Contract;
import creditAuto.model.VehicleCategory;

@Service
public class ContractService {

	@Autowired
	private ContractDAO contractDao;

	public void createContract(Contract contract) {
		contractDao.persist(contract);
	}

	public List<Contract> findContractsByDates(LocalDate beginingDate, LocalDate endDate ) {
		return contractDao.findStatisticsByDate(beginingDate, endDate);
	}
	
	
}