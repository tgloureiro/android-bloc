package tech.tiagoloureiro.bloc

data class Transition<State, Event>(
    val event: Event,
    val previousState: State,
    val newState: State
)