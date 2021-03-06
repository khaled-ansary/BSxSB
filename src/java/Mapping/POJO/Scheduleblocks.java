package Mapping.POJO;
// Generated Mar 18, 2015 11:06:19 AM by Hibernate Tools 4.3.1



/**
 * Scheduleblocks generated by hbm2java
 */
public class Scheduleblocks  implements java.io.Serializable {


     private Integer scheduleblockid;
     private Integer schoolid;
     private Integer period;
     private String days;
     private transient int[] daysarrays;

    public Scheduleblocks() {
    }

    public Scheduleblocks(Integer schoolid, Integer period, String days) {
       this.schoolid = schoolid;
       this.period = period;
       this.days = days;
       String[] daysarraysString = days.split(days);
       this.daysarrays = new int[daysarraysString.length];
       for(int i = 0; i < daysarrays.length; i++){
           daysarrays[i] = Integer.parseInt(daysarraysString[i]);
       }
       
    }
   
    public Integer getScheduleblockid() {
        return this.scheduleblockid;
    }
    
    public void setScheduleblockid(Integer scheduleblockid) {
        this.scheduleblockid = scheduleblockid;
    }
    public Integer getSchoolid() {
        return this.schoolid;
    }
    
    public void setSchoolid(Integer schoolid) {
        this.schoolid = schoolid;
    }
    public Integer getPeriod() {
        return this.period;
    }
    
    public void setPeriod(Integer period) {
        this.period = period;
    }
    public String getDays() {
        return this.days;
    }
    
    public void setDays(String days) {
        this.days = days;
    }
    /**
     * This override method is use to present the scheduleblock data in the
     * appropriate form {<period>;<day1>,<day2>}
     * @return a String
     */
    @Override
    public String toString(){
         return "<" + period + ";" + days + ">";
    }




}


