package creditAuto;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public final class ContractMapper implements RowMapper<Contract>{

	public Contract mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contract contractTemp = new Contract();
		contractTemp.setId(rs.getLong("id"));
		
		// set client object for contract
		// find and get the client object by id
		Client clientd = new ClientDAO().findById(rs.getInt("client_id"));
		contractTemp.setClient(clientd);
		
		contractTemp.setClosureDate( new java.sql.Date(rs.getDate("closuredate").getTime()).toLocalDate());
		contractTemp.setContractNumber(rs.getInt("contractnumber"));
		contractTemp.setLoanDuration(rs.getInt("laonduration"));
		contractTemp.setLoanRate(BigDecimal.valueOf(rs.getInt("laonrate")));
		contractTemp.setLoanTotalCost(BigDecimal.valueOf(rs.getInt("laontotalcost")));
		
		contractTemp.setPaymentEndDate(new java.sql.Date(rs.getDate("paymentenddate").getTime()).toLocalDate());
		contractTemp.setPaymentStartDate(new java.sql.Date(rs.getDate("paymentstartdate").getTime()).toLocalDate());
		contractTemp.setPurchaseAmount(BigDecimal.valueOf(rs.getInt("purchaseamount")));
		
		contractTemp.setVehicleCategory(rs.getInt("vehiclecategory") == 1 ? VehicleCategory.A : VehicleCategory.B);
		return contractTemp;
	}



}
