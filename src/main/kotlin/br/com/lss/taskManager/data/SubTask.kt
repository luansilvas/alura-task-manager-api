package br.com.lss.taskManager.data

import org.hibernate.Hibernate
import javax.persistence.*

@Entity
data class SubTask(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val title: String="",
    @Enumerated(value = EnumType.STRING)
    val status: StatusTask = StatusTask.TO_DO,
    @ManyToOne
    val task: Task? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as SubTask

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}