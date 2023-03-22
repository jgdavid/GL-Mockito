package com.qa.mock;

public enum RPS {

	ROCK {
		@Override
		public Result beats(RPS otherPlayer) {
			if (otherPlayer == PAPER)
				return Result.LOSE;
			if (otherPlayer == SCISSORS)
				return Result.WIN;
			else
				return Result.DRAW;
		}
	},
	PAPER {
		@Override
		public Result beats(RPS otherPlayer) {
			if (otherPlayer == SCISSORS)
				return Result.LOSE;
			if (otherPlayer == ROCK)
				return Result.WIN;
			else
				return Result.DRAW;
		}
	},
	SCISSORS {
		@Override
		public Result beats(RPS otherPlayer) {
			if (otherPlayer == ROCK)
				return Result.LOSE;
			if (otherPlayer == PAPER)
				return Result.WIN;
			else
				return Result.DRAW;
		}
	};

	public abstract Result beats(RPS otherPlayer);

}
