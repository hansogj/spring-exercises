package no.arktekk.training.spring.form;

import no.arktekk.training.spring.domain.Auction;
import org.joda.time.DateTime;

/**
 * @author <a href="mailto:kaare.nilsen@arktekk.no">Kaare Nilsen</a>
 */
public class AuctionForm implements Form<Auction> {
    private Double id;
    private Double minimumPrice;
    private String description;
    private DateTime starts;
    private DateTime expires;


    @Override
    public Auction to() {
        return new Auction(id, minimumPrice, description, starts, expires);
    }

    @Override
    public AuctionForm apply(Auction domainObject) {
        id = domainObject.id();
        minimumPrice = domainObject.minimumPrice();
        description = domainObject.description();
        starts = domainObject.starts();
        expires = domainObject.expires();
        return this;
    }


    @Override
    public String toString() {
        return "AuctionForm{" +
                "id=" + id +
                ", minimumPrice=" + minimumPrice +
                ", description='" + description + '\'' +
                ", starts=" + starts +
                ", expires=" + expires +
                '}';
    }

    /**
     * *********************************************************************
     * Getters and Setters section.. Unfortunatly needed by spring mvc :(  *
     * *********************************************************************
     */
    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public Double getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(Double minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DateTime getStarts() {
        return starts;
    }

    public void setStarts(DateTime starts) {
        this.starts = starts;
    }

    public DateTime getExpires() {
        return expires;
    }

    public void setExpires(DateTime expires) {
        this.expires = expires;
    }
}
