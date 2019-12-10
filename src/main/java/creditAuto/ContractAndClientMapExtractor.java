
package creditAuto;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.ResultSetExtractor;


final class ContractAndClientMapExtractor implements ResultSetExtractor<Map<Integer, Contract>> {

	@Override
	public Map<Integer, Contract> extractData(ResultSet rs) throws SQLException {
		Map<Integer, Contract> map = new HashMap<>();

		while (rs.next()) {

			Contract contractTemp = new Contract();

			// Contract map
			contractTemp.setId(rs.getLong("id"));
			contractTemp.setClosureDate( new java.sql.Date(rs.getDate("closuredate").getTime()).toLocalDate());
			contractTemp.setContractNumber(rs.getInt("contractnumber"));
			contractTemp.setLoanDuration(rs.getInt("loanduration"));
			contractTemp.setLoanRate(BigDecimal.valueOf(rs.getInt("loanrate")));
			contractTemp.setLoanTotalCost(BigDecimal.valueOf(rs.getInt("loantotalcost")));
			contractTemp.setPaymentEndDate(new java.sql.Date(rs.getDate("paymentenddate").getTime()).toLocalDate());
			contractTemp.setPaymentStartDate(new java.sql.Date(rs.getDate("paymentstartdate").getTime()).toLocalDate());
			contractTemp.setPurchaseAmount(BigDecimal.valueOf(rs.getInt("purchaseamount")));
			contractTemp.setVehicleCategory(rs.getString("vehiclecategory") == "A" ? VehicleCategory.A : VehicleCategory.B);

			// add Contract map to map collection
			map.put((int) rs.getLong("id"), contractTemp);

			// add client map to Contract map
			Client clientTest = new Client();
			clientTest.setId(rs.getLong("client_id"));
			clientTest.setFirstname(rs.getString("firstname"));
			contractTemp.setClient(clientTest);
		}

		return map;
	}

}

