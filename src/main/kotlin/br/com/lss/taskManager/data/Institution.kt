package br.com.lss.taskManager.data

import org.hibernate.Hibernate
import javax.persistence.*

@Entity
data class Institution(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val name: String,
    @Enumerated(value = EnumType.STRING)
    val type: InstitutionType
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Institution

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}