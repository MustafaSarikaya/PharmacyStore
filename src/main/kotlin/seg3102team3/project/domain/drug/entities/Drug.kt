class Drug(
        val id: UInt,
        var name: String,
        var tradeName: String,
        var formula: String,
        var strengthMgPerMl: Float,
        var monographPDF: ByteArray,
        var counsellingDocsPDF: Set<ByteArray>,
        var pastReports: Set<ByteArray>
) {}