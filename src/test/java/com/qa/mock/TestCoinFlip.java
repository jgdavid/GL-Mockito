package com.qa.mock;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) // enables mockito for these tests
public class TestCoinFlip {

	@Mock // create the mock Random object
	private Random rand;

	@InjectMocks // inserts the mock into the Simulator
	private Simulator sim;

	@Test
	void testHeadsSuccess() {
		Mockito.when(this.rand.nextInt(101)).thenReturn(25);
		for (int i = 0; i < 1000; i++)
			assertTrue(this.sim.coinflip(CoinFlip.HEADS));

		Mockito.verify(this.rand, Mockito.times(1000)).nextInt(101);
	}

	@Test
	void testHeadsFail() {
		Mockito.when(this.rand.nextInt(101)).thenReturn(55);
		for (int i = 0; i < 1000; i++)
			assertFalse(this.sim.coinflip(CoinFlip.HEADS));

		Mockito.verify(this.rand, Mockito.times(1000)).nextInt(101);
	}

	@Test
	void testTailsSuccess() {
		Mockito.when(this.rand.nextInt(101)).thenReturn(55);
		for (int i = 0; i < 1000; i++)
			assertTrue(this.sim.coinflip(CoinFlip.TAILS));

		Mockito.verify(this.rand, Mockito.times(1000)).nextInt(101);
	}

	@Test
	void testTailsFail() {
		Mockito.when(this.rand.nextInt(101)).thenReturn(25);
		for (int i = 0; i < 1000; i++)
			assertFalse(this.sim.coinflip(CoinFlip.TAILS));

		Mockito.verify(this.rand, Mockito.times(1000)).nextInt(101);
	}

	@Test
	void testEdgeSuccess() {
		Mockito.when(this.rand.nextInt(101)).thenReturn(100);
		for (int i = 0; i < 1000; i++)
			assertTrue(this.sim.coinflip(CoinFlip.EDGE));

		Mockito.verify(this.rand, Mockito.times(1000)).nextInt(101); // check I actually used the mock
	}

	@Test
	void testEdgeFail() {
		Mockito.when(this.rand.nextInt(101)).thenReturn(25);
		for (int i = 0; i < 1000; i++)
			assertFalse(this.sim.coinflip(CoinFlip.EDGE));

		Mockito.verify(this.rand, Mockito.times(1000)).nextInt(101);
	}

}
