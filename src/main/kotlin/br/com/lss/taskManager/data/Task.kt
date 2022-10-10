package br.com.lss.taskManager.data

import org.hibernate.Hibernate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Task(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var title: String="",
    var description: String="",
    val creationDate : LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val institution: Institution?=null,
    @Enumerated(value = EnumType.STRING)
    val type: TaskType = TaskType.PERSONAL,
    @ManyToOne
    val author: User?= null,
    @Enumerated(value = EnumType.STRING)
    val status: StatusTask = StatusTask.TO_DO,
    @OneToMany(mappedBy = "task")
    val subtasks: List<SubTask> = listOf(),
    val isVisible: Boolean = true
    ) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Task

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}

