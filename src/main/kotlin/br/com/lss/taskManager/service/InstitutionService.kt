package br.com.lss.taskManager.service

import br.com.lss.taskManager.data.Institution
import br.com.lss.taskManager.data.InstitutionType
import org.springframework.stereotype.Service

@Service
class InstitutionService(
    var institutions: List<Institution>
) {
    init {
        val institution1 = Institution(
            id = 1,
            name = "ACADEMIA GARRA",
            type = InstitutionType.OTHER
        )
       institutions = listOf(institution1)
    }

    fun findInstitutionById(id: Long): Institution {
        return institutions.stream().filter { institution ->
            institution.id == id
        }.findFirst().get()
    }
}