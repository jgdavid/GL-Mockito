package com.qa.mock;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestRPS {

	@InjectMocks
	private Simulator sim;

	@Mock //
	private Random rand;

	@Test
	void testRockOnRock() {
		Mockito.when(this.rand.nextInt(3)).thenReturn(0);
		for (int i = 0; i < 100; i++)
			Assertions.assertEquals(Result.DRAW, this.sim.playRPS(RPS.ROCK));

	}

	@Test
	void testRockOnpaper() {
		Mockito.when(this.rand.nextInt(3)).thenReturn(1);
		for (int i = 0; i < 100; i++)
			Assertions.assertEquals(Result.DRAW, this.sim.playRPS(RPS.ROCK));

	}

}
