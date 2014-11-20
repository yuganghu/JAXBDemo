package com.waycoolsearch.tutorials.jaxb;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.waycoolsearch.tutorials.search.jaxb.redirect.RedirectRuleType;
import com.waycoolsearch.tutorials.search.jaxb.redirect.RedirectRulesType;

public class JAXBUtils {

	/*
	 * private constructor
	 */
	private JAXBUtils() {
	}

	/**
	 * Get redirect rules from a file
	 *
	 * @param file
	 *            - source file
	 * @return a list of redirect rules
	 * @throws JAXBException
	 */
	public static List<RedirectRuleType> getRedirectRules(String file)
			throws JAXBException {
		JAXBContext jc = JAXBContext
				.newInstance("com.waycoolsearch.tutorials.search.jaxb.redirect");
		Unmarshaller u = jc.createUnmarshaller();
		@SuppressWarnings("unchecked")
		JAXBElement<RedirectRulesType> redirectRules = (JAXBElement<RedirectRulesType>) u
				.unmarshal(new File(file));
		List<RedirectRuleType> list = redirectRules.getValue()
				.getRedirectRule();
		return list;
	}

}
