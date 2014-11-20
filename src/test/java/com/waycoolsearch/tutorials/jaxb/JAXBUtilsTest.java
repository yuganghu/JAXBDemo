package com.waycoolsearch.tutorials.jaxb;

import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.waycoolsearch.tutorials.search.jaxb.redirect.RedirectRuleType;

public class JAXBUtilsTest {

	Logger logger = Logger.getLogger(JAXBUtilsTest.class);

	@Test
	public void testGetRedirectRules() throws JAXBException {
		List<RedirectRuleType> redirectRules = JAXBUtils
				.getRedirectRules("src/test/resources/redirects.xml");
		for (RedirectRuleType redirectRule : redirectRules) {
			logger.info("Name=" + redirectRule.getName());
			logger.info("Query=" + redirectRule.getQueries().getQuery());
			logger.info("redirectURL="
					+ redirectRule.getRedirects().getRedirectURL());
		}
	}
}
