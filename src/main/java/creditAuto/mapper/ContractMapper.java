package creditAuto.mapper;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import creditAuto.dao.ContractDAO;
import creditAuto.model.Contract;
import creditAuto.model.VehicleCategory;

@Service
public final class ContractMapper implements RowMapper<Contract> {

	@Autowired
	ContractDAO clientd;

	public Contract mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contract contractTemp = new Contract();
		contractTemp.setId(rs.getLong("id"));

		Date closureDateInDb = rs.getDate("closuredate");

		if (closureDateInDb != null) {
			contractTemp.setClosureDate(closureDateInDb.toLocalDate());
		}

		Date paymentEndDateInDb = rs.getDate("paymentenddate");

		if (paymentEndDateInDb != null) {
			contractTemp.setPaymentEndDate(paymentEndDateInDb.toLocalDate());
		}

		Date paymentStartDateInDb = rs.getDate("paymentstartdate");

		if (paymentStartDateInDb != null) {
			contractTemp.setPaymentStartDate(paymentStartDateInDb.toLocalDate());
		}

		String categoryValue = rs.getString("vehiclecategory");
		contractTemp.setVehicleCategory(VehicleCategory.valueOf(categoryValue));

		contractTemp.setContractNumber(rs.getInt("contractnumber"));
		contractTemp.setLoanDuration(rs.getInt("loanduration"));
		contractTemp.setLoanRate(BigDecimal.valueOf(rs.getInt("loanrate")));
		contractTemp.setLoanTotalCost(BigDecimal.valueOf(rs.getInt("loantotalcost")));
		contractTemp.setPurchaseAmount(BigDecimal.valueOf(rs.getInt("purchaseamount")));

		return contractTemp;
	}

}
