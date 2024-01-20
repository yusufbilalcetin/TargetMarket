package utils;

import pages.InarAcademyHomePage;
import pages.TargetMarketHomePage;
import pages.TargetMarketLogOutPage;
import pages.TargetMarketLoginPage;

public class Pages {

	private InarAcademyHomePage inarAcademyHomePage;

	private TargetMarketLoginPage targetMarketLoginPage;

	private TargetMarketHomePage targetMarketHomePage;

	private TargetMarketLogOutPage targetMarketLogOutPage;

	public Pages() {
		inarAcademyHomePage = new InarAcademyHomePage();
		targetMarketLoginPage = new TargetMarketLoginPage();
		targetMarketHomePage = new TargetMarketHomePage();
		targetMarketLogOutPage = new TargetMarketLogOutPage();
	}

	public InarAcademyHomePage getInarAcademyHomePage() {
		return inarAcademyHomePage;
	}

	public TargetMarketLoginPage getTargetMarketLoginPage() {
		return targetMarketLoginPage;
	}

	public TargetMarketHomePage getTargetMarketHomePage() {
		return targetMarketHomePage;
	}

	public TargetMarketLogOutPage getTargetMarketLogOutPage() {
		return targetMarketLogOutPage;
	}

}
