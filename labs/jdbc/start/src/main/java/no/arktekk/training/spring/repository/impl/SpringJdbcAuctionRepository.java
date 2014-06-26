package no.arktekk.training.spring.repository.impl;

import no.arktekk.training.spring.domain.Auction;
import no.arktekk.training.spring.repository.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ProgramUtvikling
 * Date: 26.06.14
 * Time: 08:58
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class SpringJdbcAuctionRepository implements AuctionRepository{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SpringJdbcAuctionRepository (DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Auction> listAllRunningAuctions() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Auction findById(Double auctionId) {

        String sql = "select * from Auctions where id = ?";
        List<Auction> auctions = jdbcTemplate.query(sql, new AuctionRowMapper(), auctionId);
        if(! auctions.isEmpty()) {
            return auctions.get(0);
        } else return null;
    }
}
