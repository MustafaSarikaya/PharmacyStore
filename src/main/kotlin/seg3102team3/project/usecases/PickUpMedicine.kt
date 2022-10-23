package seg3102team3.project.usecases

import java.util.*

interface PickUpMedicine {
    fun PickUpMedicine(medicineInfo: MedicinePickUpDto): Boolean
    
}