package by.epam.javaonline.task4_1_6;

import java.util.Objects;

/* 6. Составьте описание класса для представления времени. Предусмотрите
 * возможности установки времени и изменения его отдельных полей
 * (час, минута, секунда) с проверкой допустимости вводимых значений.
 * В случае недопустимых значений полей поле устанавливается в значение 0.
 * Создать методы изменения времени на заданное количество часов, минут и секунд.*/

public class Time {
	
	private int hours = 0;
	private int minutes = 0;
	private int seconds = 0;
	
	public Time() {
		
	}
	
	public Time(int hours, int minutes) {
		this.hours = checkHours(hours);
		this.minutes = checkMinAndSec(minutes);
	}

	public Time(int hours, int minutes, int seconds) {
		this.hours = checkHours(hours);
		this.minutes = checkMinAndSec(minutes);
		this.seconds = checkMinAndSec(seconds);
	}
	
	public int getHours() {
		return hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setHours(int hours) {
		this.hours = checkHours(hours);
	}

	public void setMinutes(int minutes) {
		this.minutes = checkMinAndSec(minutes);
	}

	public void setSeconds(int seconds) {
		this.seconds = checkMinAndSec(seconds);
	}
	
	public void setTime(int hours, int minutes, int seconds) {
		this.hours = checkHours(hours);
		this.minutes = checkMinAndSec(minutes);
		this.seconds = checkMinAndSec(seconds);
	}
	
	// to increase number of hours argument must be > 0
	// to decrease number of hours argument must be < 0
	public int changeHours(int hoursNum) {
		
		hours = hours + hoursNum;
		
		if(hours >= 24) {
			hours = Math.abs(hours) % 24;
		}
		
		if(hours < 0) {
			hours = 24 - Math.abs(hours) % 24;
		}
		return hours;
	}
	
	// to increase number of minutes argument must be > 0
	// to decrease number of minutes argument must be < 0
	public int changeMinutes(int minuteNum) {
		
		minutes = minutes + minuteNum;
		
		if(minutes >= 60) {
			minutes = Math.abs(minutes) % 60;
		}
		
		if(minutes < 0) {
			minutes = 60 - Math.abs(minutes) % 60;
		}
		return minutes;
	}
	
	// to increase number of seconds argument must be > 0
	// to decrease number of seconds argument must be < 0
	public int changeSeconds(int secondNum) {
		
		seconds = seconds + secondNum;
		
		if(seconds >= 60) {
			seconds = Math.abs(seconds) % 60;
		}
		
		if(seconds < 0) {
			seconds = 60 - Math.abs(seconds) % 60;
		}
		return seconds;
	}
	
	// method adding or subtracting set number of hours, minutes and seconds
	// from current time
	// to increasing, boolean argument 'needToIncrease' must get value - true,
	// and to decreasing  - false
	public Time changeTime(boolean needToIncrease, int hours, int minutes, int seconds) {
		
		Time initTime;
		Time resultTime;
		int initSeconds;
		int currentSeconds;
		int resulSeconds;
		int seconsIn24Hours;
		
		initTime = new Time(hours, minutes, seconds);
		initSeconds = timeToSeconds(initTime);
		currentSeconds = timeToSeconds(this);
		
		if(needToIncrease) {
			resulSeconds = initSeconds + currentSeconds;
		} else {
			resulSeconds = currentSeconds - initSeconds;
		}
		
		// case if result number of seconds more than number of 
		// seconds in 24 hours
		seconsIn24Hours = 24 * 60 * 60;
		
		if (resulSeconds >= seconsIn24Hours) {
			resulSeconds = resulSeconds % seconsIn24Hours;
		}
		
		if (resulSeconds < 0) {
			resulSeconds = seconsIn24Hours - Math.abs(resulSeconds) % seconsIn24Hours;
		}
		
		resultTime = secondsToTime(resulSeconds);
		this.hours = resultTime.getHours();
		this.minutes = resultTime.getMinutes();
		this.seconds = resultTime.getSeconds();
		
		return this;
	}
	
	// method converting number of seconds into Time object
	private Time secondsToTime(int secNum) {
		
		int hours;
		int minutes;
		int seconds;
		
		hours = Math.abs(secNum) / 3600;
		minutes = (Math.abs(secNum) - hours * 3600) / 60;
		seconds = Math.abs(secNum) - hours * 3600 - minutes * 60;
		
		return new Time(hours, minutes, seconds);
	}
	
	// method converting Time object into number of seconds
	private int timeToSeconds(Time time) {
		
		int hours;
		int minutes;
		int seconds;
		
		hours = time.getHours();
		minutes = time.getMinutes();
		seconds = time.getSeconds();
		
		return hours * 3600 + minutes * 60 + seconds;
	}
	
	private int checkHours(int hours) {
		
		if (hours >= 0 && hours <= 23) {
			return hours;
		} else {
			return 0;
		}
	}
	
	private int checkMinAndSec(int minutes) {
		
		if (minutes >= 0 && minutes <= 59) {
			return minutes;
		} else {
			return 0;
		}
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(hours, minutes, seconds);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return hours == other.hours && minutes == other.minutes && seconds == other.seconds;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [hours=" + hours + ", minutes=" + minutes + ", seconds=" + seconds + "]";
	}
	
	
}
