package no.arktekk.training.spring.repository;

import no.arktekk.training.spring.domain.Auction;

import java.util.List;
import java.util.Map;


/**
 * @author <a href="mailto:kaare.nilsen@arktekk.no">Kaare Nilsen</a>
 */
public interface AuctionRepository {
    List<Auction> listAllRunningAuctions();

    Auction findById(Double auctionId);

    List<Auction> getAuctions(Map parameters);
}
