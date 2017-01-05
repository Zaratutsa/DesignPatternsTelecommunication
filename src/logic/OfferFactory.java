package logic;

public class OfferFactory {
	static public Offer factory(String nameType) {
		if (nameType == null) {
			return null;
		}

		if (nameType.equalsIgnoreCase("Card")) {
			CardOffer of=new CardOffer();
			of.setFreeMinutes();
			of.setInternet();
			of.setPeriod();
			of.setPrice();
			of.setPriceMinute();
			of.setStatus(1);
			of.setType();
			return of;
		}

		if (nameType.equalsIgnoreCase("Subscription")) {
			SubscriptionOffer of=new SubscriptionOffer();
			of.setFreeMinutes();
			of.setInternet();
			of.setPeriod();
			of.setPrice();
			of.setPriceMinute();
			of.setStatus(1);
			of.setType();
			return of;
		}

		if (nameType.equalsIgnoreCase("Mix")) {
			MixOffer of=new MixOffer();
			of.setFreeMinutes();
			of.setInternet();
			of.setPeriod();
			of.setPrice();
			of.setPriceMinute();
			of.setStatus(1);
			of.setType();
			return of;
		}

		return null;
	}
}
