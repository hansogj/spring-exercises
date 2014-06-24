package no.arktekk.training.spring.service.impl;

import no.arktekk.training.spring.domain.Auction;
import no.arktekk.training.spring.repository.AuctionRepository;
import no.arktekk.training.spring.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author <a href="mailto:kaare.nilsen@arktekk.no">Kaare Nilsen</a>
 */
@Component
public class DefaultAuctionService implements AuctionService {
    @Autowired
    private final AuctionRepository auctionRepository = null;


    public DefaultAuctionService() {}


    public List<Auction> allRunningAuctions() {
        return auctionRepository.listAllRunningAuctions();
    }

    public Auction findById(Double auctionId) {
        return auctionRepository.findById(auctionId);
    }
}
