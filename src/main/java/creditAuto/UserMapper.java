package creditAuto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public final class UserMapper implements RowMapper<User>{

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user1 = new User();
		user1.setUserFirstname(rs.getString("firstname"));
		user1.setUserLastname(rs.getString("lastname"));
		user1.setId(rs.getLong("id"));
		return user1;
	}



}
