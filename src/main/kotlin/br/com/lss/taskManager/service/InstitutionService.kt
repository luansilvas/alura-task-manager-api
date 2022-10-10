package br.com.lss.taskManager.service

import br.com.lss.taskManager.data.Institution
import br.com.lss.taskManager.repository.InstitutionRepository
import org.springframework.stereotype.Service

@Service
class InstitutionService(
    private val repository: InstitutionRepository
) {
    fun findInstitutionById(id: Long): Institution {
        return repository.getById(id)
    }
}