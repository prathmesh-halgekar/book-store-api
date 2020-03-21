package com.prats.bookstore.demo.service;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class UtilityService {

	/**
	 * This method calculates the Cosine Similarity between two vectors represented
	 * by a java.util.list. The similarity value lies in the range of 0 to 1, 0
	 * indicating the maximum distance and 1 indicating the minimum distance. This
	 * method assumes that the size of both the vectors should be same. If different
	 * then this method throws RuntimeException
	 * 
	 * @param list1
	 * @param list2
	 * @return double value
	 * @throws RuntimeException
	 */
	public static double getCosineSimilarity(List<Integer> list1, List<Integer> list2) {
		double result = 0.0d; // default value
		if (list1 != null && list2 != null) {
			if (list1.size() != list2.size())
				throw new RuntimeException("Size of both the vectors should be same");

			double numerator = 0.0d; // default value
			for (int index = 0; index < list1.size(); index++) {
				numerator += list1.get(index) * list2.get(index);
			}
			double denominator1 = 0.0d; // default value
			double denominator2 = 0.0d; // default value
			for (int index = 0; index < list1.size(); index++) {
				denominator1 += list1.get(index) * list1.get(index);
				denominator2 += list2.get(index) * list2.get(index);
			}
			double denominator = Math.sqrt(denominator1) * Math.sqrt(denominator2);
			result = numerator / denominator;
		}
		return Double.parseDouble(String.format("%.3f", result));
	}

	public static String getPriceInEuro(Double value) {
		Locale locale = new Locale("de", "DE");
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		return currencyFormatter.format(value);
	}

}
