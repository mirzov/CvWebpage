package com.mirzov.oleg.website.snippet

import _root_.scala.xml.NodeSeq
import _root_.net.liftweb.util.Helpers
import Helpers._
import _root_.java.util.{Calendar, GregorianCalendar}

class AgeOleg {

	val dateOfBirth = new GregorianCalendar(1980, Calendar.DECEMBER, 13)
	val today = Calendar.getInstance()

	private var years = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR)
	private var months = today.get(Calendar.MONTH) - dateOfBirth.get(Calendar.MONTH)
	private var days = today.get(Calendar.DATE) - dateOfBirth.get(Calendar.DATE)

	if(days < 0){
		val monthAgo = Calendar.getInstance()
		monthAgo.roll(Calendar.MONTH, false)
		val daysInPrevMonth = monthAgo.getActualMaximum(Calendar.DATE)
		months = months - 1
		days = days + daysInPrevMonth
	}
	if (months < 0) {
		years = years - 1
		months = months + 12
	}

	def sEnding(number: Int):String = 
		if(number.toString.endsWith("1") && !number.toString.endsWith("11"))
			""
		else "s"

	def getYears(in: NodeSeq): NodeSeq = {
		Helpers.bind("age", in, "years" -> (years.toString + " year" + sEnding(years)))
	}
	def getMonths(in: NodeSeq): NodeSeq = {
		Helpers.bind("age", in, "months" -> (months.toString + " month" + sEnding(months)))
	}
	def getDays(in: NodeSeq): NodeSeq = {
		Helpers.bind("age", in, "days" -> (days.toString + " day" + sEnding(days)))
	}
}

