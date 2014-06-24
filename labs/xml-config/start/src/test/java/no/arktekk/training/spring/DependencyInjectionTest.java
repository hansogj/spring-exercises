package no.arktekk.training.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import no.arktekk.training.spring.domain.Auction;
import no.arktekk.training.spring.repository.AuctionRepository;
import no.arktekk.training.spring.service.AuctionService;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author <a href="mailto:kaare.nilsen@arktekk.no">Kaare Nilsen</a>
 * @author <a href="mailto:marten@haglind.com">Marten Haglind</a>
 */
public class DependencyInjectionTest {

	/**
	 * Configure necessary bean in applicationContext.xml and complete the
	 * helper methods in order to get this test to run.
	 * <p/>
	 * TIP: The repository implementation is:
	 * no.arktekk.training.spring.repository.impl.StubAuctionRepository
	 */
	@Test
	public void step_1() {
		ApplicationContext ctx = createSpringContainer();
		assertNotNull(ctx);
		AuctionRepository auctionRepository = lookupAuctionRepository(ctx);
		assertNotNull(auctionRepository);
	}

	/**
	 * Configure necessary beans in applicationContext.xml and complete the
	 * helper methods in order to get this test to run.
	 * <p/>
	 * TIP: The repository implementation is:
	 * no.arktekk.training.spring.service.impl.DefaultAuctionService TIP: The
	 * service needs the repository in order to work.
	 */
	@Test
	public void step_2() {
		ApplicationContext ctx = createSpringContainer();
		AuctionService auctionService = lookupAuctionService(ctx);
		assertNotNull(auctionService);
	}

	/**
	 * Complete TODO's Replace all calls to fail() with proper test code
	 */
	@Test
	public void step_3() {

		ApplicationContext ctx = createSpringContainer();
		AuctionRepository auctionRepository = lookupAuctionRepository(ctx);
		AuctionService auctionService = lookupAuctionService(ctx);

		// TODO: Check that there are no running auctions present using the
		// allRunningAuctions() in AuctionService
		assertEquals(0, auctionService.allRunningAuctions().size());
		

		// TODO: Add 2 new Auction objects, using the auctionRepository
		Auction auctionOne = new Auction(1, "Old Chair");
		auctionRepository.createNewAuction(new Auction(0, "Old Table"));
		auctionRepository.createNewAuction(auctionOne);
		assertEquals(2, auctionService.allRunningAuctions().size());

		// TODO: Check that there are now 2 running auctions
		

		// TODO: Use the auction service to query by id, and verify that the
		// result is as expected
		assertEquals(auctionOne, auctionService.findById(auctionOne.id()));
	}

	private ApplicationContext createSpringContainer() {
		return new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	private AuctionRepository lookupAuctionRepository(ApplicationContext ctx) {
		return ctx.getBean("auctionRepository", AuctionRepository.class);
	}

	private AuctionService lookupAuctionService(ApplicationContext ctx) {
		return ctx.getBean("auctionService", AuctionService.class);
	}
}
