package creditAuto;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public final class ContractMapper implements RowMapper<Contract>{
	
	@Autowired
	ContractDAO clientd;

	public Contract mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contract contractTemp = new Contract();
		contractTemp.setId(rs.getLong("id"));
		
		contractTemp.setClosureDate( new java.sql.Date(rs.getDate("closuredate").getTime()).toLocalDate());
		contractTemp.setContractNumber(rs.getInt("contractnumber"));
		contractTemp.setLoanDuration(rs.getInt("loanduration"));
		contractTemp.setLoanRate(BigDecimal.valueOf(rs.getInt("loanrate")));
		contractTemp.setLoanTotalCost(BigDecimal.valueOf(rs.getInt("loantotalcost")));
		contractTemp.setPaymentEndDate(new java.sql.Date(rs.getDate("paymentenddate").getTime()).toLocalDate());
		contractTemp.setPaymentStartDate(new java.sql.Date(rs.getDate("paymentstartdate").getTime()).toLocalDate());
		contractTemp.setPurchaseAmount(BigDecimal.valueOf(rs.getInt("purchaseamount")));
		
		contractTemp.setVehicleCategory(rs.getString("vehiclecategory").contentEquals( "A") ? VehicleCategory.A : VehicleCategory.B);
		
		return contractTemp;
	}



}
