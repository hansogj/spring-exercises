package no.arktekk.training.spring.repository.impl;

import no.arktekk.training.spring.domain.Auction;
import org.joda.time.DateTime;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: ProgramUtvikling
 * Date: 26.06.14
 * Time: 09:16
 * To change this template use File | Settings | File Templates.
 */
public class AuctionRowMapper implements RowMapper<Auction> {
    @Override
    public Auction mapRow(ResultSet rs, int rowNumber) throws SQLException {
        return new Auction(rs.getDouble("id"),
                rs.getDouble("minimumPrice"),
                rs.getString("description"),
                new DateTime(rs.getDate("starts")),
                new DateTime(rs.getDate("expires")));
    }
}
