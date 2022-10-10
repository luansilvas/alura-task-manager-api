package br.com.lss.taskManager.repository

import br.com.lss.taskManager.data.Institution
import org.springframework.data.jpa.repository.JpaRepository

interface InstitutionRepository : JpaRepository<Institution, Long> {
}