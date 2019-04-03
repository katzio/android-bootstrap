package todoapp.akatz.io.models

import java.util.*

data class ToDoTask(val title: String, val due: Date) {

    enum class TaskState{
        PENDING,
        DONE
    }

    val state: TaskState = TaskState.PENDING
}