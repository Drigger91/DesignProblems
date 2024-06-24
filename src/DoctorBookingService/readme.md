Design a doctor booking system

Solution: 

 - Whole service will revolve around doctors. 
 - DOCTOR: 
   - id
   - name
   - speciality (Indexed & ENUM)
   - address
   - consultation fee
   - Slots (Corresponding to day/date)
   - city tag
   - mobile number
   - Preferred slot duration
 - APPOINTMENT:
   - doctorId
   - patientId
   - date time (SLOT)
   - notes
   - fees
 - PATIENT:
   - name
   - id
   - address //excluded
   - mobileNumber
 - SLOT
   - start time
   - duration in minutes