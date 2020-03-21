package com.prats.bookstore.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.prats.bookstore.demo.service.UtilityService;

public class UtilityServiceTest {

	@Test
	public void testGetCosineSimilarity() {

		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();

		// WHEN
		list1.add(1);
		list1.add(1);
		list1.add(0);
		list2.add(1);
		list2.add(1);
		list2.add(0);

		// THEN
		double similarity = UtilityService.getCosineSimilarity(list1, list2);
		assertEquals(1.0d, Double.parseDouble(String.format("%.3f", similarity)), " Should be 1 ");

		// WHEN
		list2.clear();
		list2.add(0);
		list2.add(1);
		list2.add(1);

		// THEN
		similarity = UtilityService.getCosineSimilarity(list1, list2);
		assertEquals(0.5d, Double.parseDouble(String.format("%.3f", similarity)), " Should be 0.5 ");

		// When - Unequal size
		list2.add(1);
		Exception exception = assertThrows(RuntimeException.class,
				() -> UtilityService.getCosineSimilarity(list1, list2));
		assertTrue(exception.getMessage().contains("Size of both the vectors should be same"));

	}

	@Test
	public void testGetPriceInEuro() {
		String currencyVal = UtilityService.getPriceInEuro(22.5);
		assertEquals("22,50 €", currencyVal, "Should be '22,50 €'");
	}

}
