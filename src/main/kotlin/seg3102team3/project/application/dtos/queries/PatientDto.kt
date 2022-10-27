package seg3102team3.project.application.dtos.queries

import java.time.LocalDate

data class PatientDto(val patientID: String,
                      val fullName: String,
                      val fullAddress: String,
                      val email: String,
                      val gender: String,  //to support "other"
                      val dateOfBirth: LocalDate,
                      val languagePref: UByte, //0 or 1 (or more if system supports more languages), this matches to a Language enum defined in the prescription subdomain
                      val healthHistoryNote: String?, //for both drug allergies and intolerances, if any
                      val prescriptionMeds: Array<String>?,
                      val nonPrescriptionMeds: Array<String>?,
                      val insuranceNumber: String?)