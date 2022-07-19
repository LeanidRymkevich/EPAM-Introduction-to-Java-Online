package by.epam.javaonline.task5_3.entity;

public enum Month {

	JANUARY(31,31),
	FEBRUARY(28,29),
	MARCH(31,31),
	APRIL(30,30),
	MAY(31,31),
	JUNE(30,30),
	JULY(31,31),
	AUGUST(31,31),
	SEPTEMBER(30,30),
	OCTOBER(31,31),
	NOVEMBER(30,30),
	DECEMBER(31,31);
	
	private final int normalYearDayNum;
	private final int leapYearDayNum;
	
	Month(int normalYearDayNum, int leapYearDayNum) {
		this.normalYearDayNum = normalYearDayNum;
		this.leapYearDayNum = leapYearDayNum;
	}

	public int getNormalYearDayNum() {
		return normalYearDayNum;
	}

	public int getLeapYearDayNum() {
		return leapYearDayNum;
	}
	
	
}
