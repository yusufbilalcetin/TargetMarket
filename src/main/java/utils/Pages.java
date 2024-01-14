package utils;

import pages.InarAcademyHomePage;
import pages.TargetMarketHomePage;
import pages.TargetMarketLoginPage;

public class Pages {

	private InarAcademyHomePage inarAcademyHomePage;

	private TargetMarketLoginPage targetMarketLoginPage;

	private TargetMarketHomePage targetMarketHomePage;

	public Pages() {
		inarAcademyHomePage = new InarAcademyHomePage();
		targetMarketLoginPage = new TargetMarketLoginPage();
		targetMarketHomePage = new TargetMarketHomePage();
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

}
