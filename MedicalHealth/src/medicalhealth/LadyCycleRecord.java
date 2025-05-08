package medicalhealth;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LadyCycleRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id; // Database ID
    
    // Encapsulated property
    private Date startDate;
    
    
    private int cycleLength;
    private int periodLength;
    private String symptom;
    private String mood;
    private int painLevel;

    public LadyCycleRecord(int id, Date startDate, int cycleLength, int periodLength, String symptom, String mood, int painLevel) {
        this.id = id;
        this.startDate = startDate;
        this.cycleLength = cycleLength;
        this.periodLength = periodLength;
        this.symptom = symptom;
        this.mood = mood;
        this.painLevel = painLevel;

        // Debugging Log
        System.out.println("Lady Cycle Record created: \n" + this.toString());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    // Getter
    public Date getStartDate() {
        return startDate;
    }
    // Setter
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getCycleLength() {
        return cycleLength;
    }

    public void setCycleLength(int cycleLength) {
        this.cycleLength = cycleLength;
    }

    public int getPeriodLength() {
        return periodLength;
    }

    public void setPeriodLength(int periodLength) {
        this.periodLength = periodLength;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public int getPainLevel() {
        return painLevel;
    }

    public void setPainLevel(int painLevel) {
        this.painLevel = painLevel;
    }
    
    // Calculate End Date
    public Date getEndDate() {
        if (startDate == null || periodLength <= 0) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        // Include the start date in the calculation
        calendar.add(Calendar.DAY_OF_MONTH, periodLength - 1);
        return calendar.getTime();
    }
    
    @Override
    public final String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        // Constructing the symptom, pain level, and mood into one sentence
        String symptomsSummary = "Menstrual Flow(" + symptom + "), Pain Level(" + painLevel + "/10), Mood(" + mood + ")";

        // Return the formatted string
        return "ID: " + id + "\n" +
                "Start Date: " + (startDate != null ? sdf.format(startDate) : "N/A") + "\n" +
                "End Date: " + (getEndDate() != null ? sdf.format(getEndDate()) : "N/A") + "\n" +
                "Symptoms: " + symptomsSummary + "\n";
    }
}
