package br.com.lss.taskManager.data

data class Institution(
    val id: Long? = null,
    val name: String,
    val type: InstitutionType = InstitutionType.PROFESSIONAL

)