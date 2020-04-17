package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SbOperationsOnStreamsTest {

	 SbOperationsOnStreams operation = new SbOperationsOnStreams();

	@Test
	void testGetSumOfHighest() {
		assertTrue(!operation.getSumOfHighestAndLowestEarnings().isEmpty());
		assertEquals(101999, operation.getSumOfHighest());
	}

	@Test
	void testGetSumOfLowest() {
		assertTrue(!operation.getSumOfHighestAndLowestEarnings().isEmpty());
		assertEquals(38900, operation.getSumOfLowest());
	}

	@Test
	void testGetCzCount() {
		assertTrue(!operation.getNumberOfPeopleFromEachCountry().isEmpty());
		assertEquals(3, operation.getCzCount());
	}

	@Test
	void testGetPlCount() {
		assertTrue(!operation.getNumberOfPeopleFromEachCountry().isEmpty());
		assertEquals(6, operation.getPlCount());
	}

	@Test
	void testGetDeCount() {
		assertTrue(!operation.getNumberOfPeopleFromEachCountry().isEmpty());
		assertEquals(2, operation.getDeCount());
	}

	@Test
	void testGetUsCount() {
		assertTrue(!operation.getNumberOfPeopleFromEachCountry().isEmpty());
		assertEquals(2, operation.getUsCount());
	}

}
