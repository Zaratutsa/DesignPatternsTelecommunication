package logic;

public class OfferFactoryDemo {
	static public Offer factory(String nameType) {
		if (nameType == null) {
			return null;
		}

		if (nameType.equalsIgnoreCase("Card")) {
			return new CardOffer();
		}

		if (nameType.equalsIgnoreCase("Subscription")) {
			return new SubscriptionOffer();
		}

		if (nameType.equalsIgnoreCase("Mix")) {
			return new MixOffer();
		}

		return null;
	}
}
