package creditAuto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import creditAuto.model.Client;
import creditAuto.model.Gender;

@Service
public final class ClientMapper implements RowMapper<Client>{

    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
        Client clientTemp = new Client();
        clientTemp.setLastName(rs.getString("lastname"));
        clientTemp.setFirstName(rs.getString("firstname"));
        clientTemp.setGender(rs.getString("gender") ==  "MALE" ? Gender.MALE : Gender.FEMALE);
        clientTemp.setAdress(rs.getString("adress"));
        clientTemp.setId(rs.getLong("id"));
        clientTemp.setAdress(rs.getString("email"));
        
        // get the client contracts list find by client_id
       // clientTemp.setContrat(new ContractDAO().findByClientId(clientTemp.getId()));
        return clientTemp;
    }



}
