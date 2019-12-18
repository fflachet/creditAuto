
package creditAuto.mapper;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.ResultSetExtractor;

import creditAuto.model.Client;
import creditAuto.model.Contract;
import creditAuto.model.Gender;
import creditAuto.model.VehicleCategory;


public final class ContractAndClientMapExtractor implements ResultSetExtractor<Map<Integer, Contract>> {

	@Override
	public Map<Integer, Contract> extractData(ResultSet rs) throws SQLException {
		Map<Integer, Contract> map = new HashMap<>();

		while (rs.next()) {

			Contract contractTemp = new Contract();

			
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
			
//			// Contract map
//			contractTemp.setId(rs.getLong("id"));
//			
//			Date closureDateInDb = rs.getDate("closuredate");
//			LocalDate closureLocalDate = closureDateInDb.toInstant()
//				      .atZone(ZoneId.systemDefault())
//				      .toLocalDate();
//			
//			contractTemp.setClosureDate(closureLocalDate);
//			
//			Date paymentEndDateInDb = rs.getDate("paymentenddate");
//			LocalDate paymentEndLocalDate = paymentEndDateInDb.toInstant()
//				      .atZone(ZoneId.systemDefault())
//				      .toLocalDate();
//			
//			contractTemp.setPaymentEndDate(paymentEndLocalDate);
//
//			Date paymentStartDateInDb = rs.getDate("paymentstartdate");
//			LocalDate paymentStartLocalDate = paymentStartDateInDb.toInstant()
//					.atZone(ZoneId.systemDefault())
//					.toLocalDate();
//			
//			contractTemp.setPaymentStartDate(paymentStartLocalDate);
//			
////			contractTemp.setPaymentEndDate(rs.getString("paymentenddate"));
////			contractTemp.setPaymentStartDate(rs.getString("paymentstartdate"));
////			contractTemp.setClosureDate(rs.getString("closuredate"));
			
			
			contractTemp.setContractNumber(rs.getInt("contractnumber"));
			contractTemp.setLoanDuration(rs.getInt("loanduration"));
			contractTemp.setLoanRate(BigDecimal.valueOf(rs.getInt("loanrate")));
			contractTemp.setLoanTotalCost(BigDecimal.valueOf(rs.getInt("loantotalcost")));
			contractTemp.setPurchaseAmount(BigDecimal.valueOf(rs.getInt("purchaseamount")));
//			contractTemp.setVehicleCategory(rs.getString("vehiclecategory") == "A" ? VehicleCategory.A : VehicleCategory.B);

			// add Contract map to map collection
			map.put((int) rs.getLong("id"), contractTemp);

			// add client map to Contract map
			// need to complete the client map
			Client clientTest = new Client();
			clientTest.setId(rs.getLong("client_id"));
			clientTest.setFirstName(rs.getString("firstname"));
			clientTest.setLastName(rs.getString("lastname"));
			clientTest.setAdress(rs.getString("adress"));
			clientTest.setGender(rs.getString("gender").contentEquals("MALE") ? Gender.MALE : Gender.FEMALE);
			clientTest.setEmail(rs.getString("email") == null ? "null" : rs.getString("email") );
			contractTemp.setClient(clientTest);
		}

		return map;
	}

}

