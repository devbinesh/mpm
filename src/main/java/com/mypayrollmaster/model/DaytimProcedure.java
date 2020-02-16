package com.mypayrollmaster.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;

@Entity
@Table(name = "tax_heads_details")
public class DaytimProcedure {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "day_time_seq")
	private Long id;
	
	@Column(name = "day_time_desc")
	private String dayTimeDescription;
	
	@Column(name = "Sunday") 
	private String sunday;
	@Column(name = "Sunday_F")
	private String sundayF;
	
	@Column(name = "Monday")
	private String monday;
	@Column(name = "Monday_F")
	private String mondayF;
	@Column(name = "Tuesday")
	private String tuesday;
	@Column(name = "Tuesday_F")
	private String tuesdayF;
	@Column(name = "Wednesday")
	private String wednesday;
	@Column(name = "Wednesday_F")
	private String wednesdayF;
	@Column(name = "Thursday")
	private String thursday;
	@Column(name = "Thursday_F")
	private String thursdayF;
	@Column(name = "Friday")
	private String friday;
	
	@Column(name = "Friday_F")
	private String fridayF;
	@Column(name = "Saturday")
	private String saturday;
	@Column(name = "Saturday_F")
	private String saturdayF;
	@Column(name = "on_dutty1")
	private String onDutty1;
	@Column(name = "off_dutty1")
	private String offDutty1;
	@Column(name = "working_time1")
	private String workingTime1;
	@Column(name = "on_dutty2")
	private String onDutty2;
	@Column(name = "off_dutty2")  
	private String offDutty2;
	@Column(name = "working_time2")
	private String workingTime2;
	@Column(name = "on_dutty3")  
	private String onDutty3;
	@Column(name = "off_dutty3")  
	private String offDutty3;
	@Column(name = "working_time3")
	private String workingTime3;
	@Column(name = "on_dutty4") 
	private String onDutty4;
	@Column(name = "off_dutty4") 
	private String offDutty4;
	@Column(name = "working_time4")
	private String workingTime4;																																
	@Column(name = "minuts_calc_perday")
	private Integer minutsCalcPerday;
	@Column(name = "minuts_aftr_on_dutty_cal_late") 
	private Integer minutesAfterOnDutyCalcLate;
	@Column(name = "minuts_bfr_off_dutty_cal_early")   
	private Integer minutesBeforeOffDutyCalEarly;
	@Column(name = "min_cal_late_ifnoclockin")   
	private Integer minimumCalLateIfNoClockIn;
	@Column(name = "min_cal_leave_early_ifnoclockout")
	private Integer minCalLeaveEarlyIfNoClockOut;
	@Column(name = "min_aftr_off_dutty_cal_ot")   
	private Integer minAfterOffDutyCalOt;
	@Column(name = "min_bfr_on_dutty_cal_ot")  
	private Integer minBeforeOnDutyCalOt;
	@Column(name = "work_time_day_off_cal_ot")   
	private Integer workTimeDayOffCalOt;
	@Column(name = "active")   
	private Integer active;
	@Column(name = "isnextday")   
	private Integer isNextDay;
	@Column(name = "shift_allowance")   
	private String shiftAllowance;
	@Column(name = "otcomponents")
	private String otComponents;
	@Column(name = "start_date_effective") 
	@Temporal(TemporalType.DATE)
	private Date startDateEffective;
	@Column(name = "end_date_effective")
	@Temporal(TemporalType.DATE)
	private Date endtDateEffective;
	
	@Column(name = "strict_monitorings")   
	private String strictMonitorings;
	
	@Column(name = "minutes_per_half") 
	private Integer minutesPerHalf;
	@Column(name = "is_multiple_days")  
	private String isMultipleDays;

	@Column(name = "no_of_shift_days")    
	private Double noOfShiftDays;

	@Column(name = "is_exception")   
	private Integer isException;

	@Column(name = "include_break") 
	private String includeBreak;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDayTimeDescription() {
		return dayTimeDescription;
	}

	public void setDayTimeDescription(String dayTimeDescription) {
		this.dayTimeDescription = dayTimeDescription;
	}

	public String getSunday() {
		return sunday;
	}

	public void setSunday(String sunday) {
		this.sunday = sunday;
	}

	public String getSundayF() {
		return sundayF;
	}

	public void setSundayF(String sundayF) {
		this.sundayF = sundayF;
	}

	public String getMonday() {
		return monday;
	}

	public void setMonday(String monday) {
		this.monday = monday;
	}

	public String getMondayF() {
		return mondayF;
	}

	public void setMondayF(String mondayF) {
		this.mondayF = mondayF;
	}

	public String getTuesday() {
		return tuesday;
	}

	public void setTuesday(String tuesday) {
		this.tuesday = tuesday;
	}

	public String getTuesdayF() {
		return tuesdayF;
	}

	public void setTuesdayF(String tuesdayF) {
		this.tuesdayF = tuesdayF;
	}

	public String getWednesday() {
		return wednesday;
	}

	public void setWednesday(String wednesday) {
		this.wednesday = wednesday;
	}

	public String getWednesdayF() {
		return wednesdayF;
	}

	public void setWednesdayF(String wednesdayF) {
		this.wednesdayF = wednesdayF;
	}

	public String getThursday() {
		return thursday;
	}

	public void setThursday(String thursday) {
		this.thursday = thursday;
	}

	public String getThursdayF() {
		return thursdayF;
	}

	public void setThursdayF(String thursdayF) {
		this.thursdayF = thursdayF;
	}

	public String getFriday() {
		return friday;
	}

	public void setFriday(String friday) {
		this.friday = friday;
	}

	public String getFridayF() {
		return fridayF;
	}

	public void setFridayF(String fridayF) {
		this.fridayF = fridayF;
	}

	public String getSaturday() {
		return saturday;
	}

	public void setSaturday(String saturday) {
		this.saturday = saturday;
	}

	public String getSaturdayF() {
		return saturdayF;
	}

	public void setSaturdayF(String saturdayF) {
		this.saturdayF = saturdayF;
	}

	public String getOnDutty1() {
		return onDutty1;
	}

	public void setOnDutty1(String onDutty1) {
		this.onDutty1 = onDutty1;
	}

	public String getOffDutty1() {
		return offDutty1;
	}

	public void setOffDutty1(String offDutty1) {
		this.offDutty1 = offDutty1;
	}

	public String getWorkingTime1() {
		return workingTime1;
	}

	public void setWorkingTime1(String workingTime1) {
		this.workingTime1 = workingTime1;
	}

	public String getOnDutty2() {
		return onDutty2;
	}

	public void setOnDutty2(String onDutty2) {
		this.onDutty2 = onDutty2;
	}

	public String getOffDutty2() {
		return offDutty2;
	}

	public void setOffDutty2(String offDutty2) {
		this.offDutty2 = offDutty2;
	}

	public String getWorkingTime2() {
		return workingTime2;
	}

	public void setWorkingTime2(String workingTime2) {
		this.workingTime2 = workingTime2;
	}

	public String getOnDutty3() {
		return onDutty3;
	}

	public void setOnDutty3(String onDutty3) {
		this.onDutty3 = onDutty3;
	}

	public String getOffDutty3() {
		return offDutty3;
	}

	public void setOffDutty3(String offDutty3) {
		this.offDutty3 = offDutty3;
	}

	public String getWorkingTime3() {
		return workingTime3;
	}

	public void setWorkingTime3(String workingTime3) {
		this.workingTime3 = workingTime3;
	}

	public String getOnDutty4() {
		return onDutty4;
	}

	public void setOnDutty4(String onDutty4) {
		this.onDutty4 = onDutty4;
	}

	public String getOffDutty4() {
		return offDutty4;
	}

	public void setOffDutty4(String offDutty4) {
		this.offDutty4 = offDutty4;
	}

	public String getWorkingTime4() {
		return workingTime4;
	}

	public void setWorkingTime4(String workingTime4) {
		this.workingTime4 = workingTime4;
	}

	public Integer getMinutsCalcPerday() {
		return minutsCalcPerday;
	}

	public void setMinutsCalcPerday(Integer minutsCalcPerday) {
		this.minutsCalcPerday = minutsCalcPerday;
	}

	public Integer getMinutesAfterOnDutyCalcLate() {
		return minutesAfterOnDutyCalcLate;
	}

	public void setMinutesAfterOnDutyCalcLate(Integer minutesAfterOnDutyCalcLate) {
		this.minutesAfterOnDutyCalcLate = minutesAfterOnDutyCalcLate;
	}

	public Integer getMinutesBeforeOffDutyCalEarly() {
		return minutesBeforeOffDutyCalEarly;
	}

	public void setMinutesBeforeOffDutyCalEarly(Integer minutesBeforeOffDutyCalEarly) {
		this.minutesBeforeOffDutyCalEarly = minutesBeforeOffDutyCalEarly;
	}

	public Integer getMinimumCalLateIfNoClockIn() {
		return minimumCalLateIfNoClockIn;
	}

	public void setMinimumCalLateIfNoClockIn(Integer minimumCalLateIfNoClockIn) {
		this.minimumCalLateIfNoClockIn = minimumCalLateIfNoClockIn;
	}

	public Integer getMinCalLeaveEarlyIfNoClockOut() {
		return minCalLeaveEarlyIfNoClockOut;
	}

	public void setMinCalLeaveEarlyIfNoClockOut(Integer minCalLeaveEarlyIfNoClockOut) {
		this.minCalLeaveEarlyIfNoClockOut = minCalLeaveEarlyIfNoClockOut;
	}

	public Integer getMinAfterOffDutyCalOt() {
		return minAfterOffDutyCalOt;
	}

	public void setMinAfterOffDutyCalOt(Integer minAfterOffDutyCalOt) {
		this.minAfterOffDutyCalOt = minAfterOffDutyCalOt;
	}

	public Integer getMinBeforeOnDutyCalOt() {
		return minBeforeOnDutyCalOt;
	}

	public void setMinBeforeOnDutyCalOt(Integer minBeforeOnDutyCalOt) {
		this.minBeforeOnDutyCalOt = minBeforeOnDutyCalOt;
	}

	public Integer getWorkTimeDayOffCalOt() {
		return workTimeDayOffCalOt;
	}

	public void setWorkTimeDayOffCalOt(Integer workTimeDayOffCalOt) {
		this.workTimeDayOffCalOt = workTimeDayOffCalOt;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public Integer getIsNextDay() {
		return isNextDay;
	}

	public void setIsNextDay(Integer isNextDay) {
		this.isNextDay = isNextDay;
	}

	public String getShiftAllowance() {
		return shiftAllowance;
	}

	public void setShiftAllowance(String shiftAllowance) {
		this.shiftAllowance = shiftAllowance;
	}

	public String getOtComponents() {
		return otComponents;
	}

	public void setOtComponents(String otComponents) {
		this.otComponents = otComponents;
	}

	public Date getStartDateEffective() {
		return startDateEffective;
	}

	public void setStartDateEffective(Date startDateEffective) {
		this.startDateEffective = startDateEffective;
	}

	public Date getEndtDateEffective() {
		return endtDateEffective;
	}

	public void setEndtDateEffective(Date endtDateEffective) {
		this.endtDateEffective = endtDateEffective;
	}

	public String getStrictMonitorings() {
		return strictMonitorings;
	}

	public void setStrictMonitorings(String strictMonitorings) {
		this.strictMonitorings = strictMonitorings;
	}

	public Integer getMinutesPerHalf() {
		return minutesPerHalf;
	}

	public void setMinutesPerHalf(Integer minutesPerHalf) {
		this.minutesPerHalf = minutesPerHalf;
	}

	public String getIsMultipleDays() {
		return isMultipleDays;
	}

	public void setIsMultipleDays(String isMultipleDays) {
		this.isMultipleDays = isMultipleDays;
	}

	public Double getNoOfShiftDays() {
		return noOfShiftDays;
	}

	public void setNoOfShiftDays(Double noOfShiftDays) {
		this.noOfShiftDays = noOfShiftDays;
	}

	public Integer getIsException() {
		return isException;
	}

	public void setIsException(Integer isException) {
		this.isException = isException;
	}

	public String getIncludeBreak() {
		return includeBreak;
	}

	public void setIncludeBreak(String includeBreak) {
		this.includeBreak = includeBreak;
	}

}
